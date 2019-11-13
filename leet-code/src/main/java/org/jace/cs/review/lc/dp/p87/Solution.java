package org.jace.cs.review.lc.dp.p87;

import java.util.Arrays;

public class Solution {

    public boolean isScramble2(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.equals(s2)) return true;

        int n = s1.length();

        char[] s1s = s1.toCharArray();
        char[] s2s = s2.toCharArray();
        Arrays.sort(s1s); Arrays.sort(s2s);
        if(!Arrays.equals(s1s, s2s)) {
            return false;
        } else {
            for(int i = 1; i < n; i++) {
                if(isScramble2(s1.substring(0, i), s2.substring(0, i))
                 && isScramble2(s1.substring(i), s2.substring(i))) {
                    return true;
                } else if(isScramble2(s1.substring(0, i), s2.substring(n-i))
                    && isScramble2(s1.substring(i), s2.substring(0, n - i))) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean isScramble(String s1, String s2) {
        if (s1.length() == 0) return true;

        Boolean[][][][] lookUpTable = new Boolean[s1.length() + 1][s1.length() + 1][s1.length() + 1][s1.length() + 1];
        return scrambleMem(s1, 0, s1.length(), s2, 0, s2.length(), lookUpTable);
    }

    private boolean scrambleMem(String s1, int start1, int end1, String s2, int start2, int end2, Boolean[][][][] lookUpTable) {
        if (lookUpTable[start1][end1][start2][end2] == null) {
            boolean isScramble = false;

            if (end1 - start1 != end2 - start2) {
            } else if (s1.substring(start1, end1).equals(s2.substring(start2, end2))) {
                isScramble = true;
            } else if (!sameCharSet(s1, start1, end1, s2, start2, end2)) {
                isScramble = false;
            } else if (end1 - start1 <= 3) {
                isScramble = true;
            } else { //real dp
                for (int k = 1; k < end1 - start1; k++) {
                    isScramble = isScramble
                            ||
                            (scrambleMem(s1, start1, start1 + k, s2, start2, start2 + k, lookUpTable) &&
                                    scrambleMem(s1, start1 + k, end1, s2, start2 + k, end2, lookUpTable))
                            ||
                            (scrambleMem(s1, start1, start1 + k, s2, end2 - k, end2, lookUpTable) &&
                                    scrambleMem(s1, start1 + k, end1, s2, start2, end2 - k, lookUpTable));
                }
            }
            lookUpTable[start1][end1][start2][end2] = isScramble;
        }
        return lookUpTable[start1][end1][start2][end2];
    }

    private boolean sameCharSet(String s1, int start1, int end1, String s2, int start2, int end2) {
        int[] hist = new int[58];
        for(int i = start1; i < end1; i++) {
            hist[s1.charAt(i) - 'A']++;
        }
        for(int i = start2; i < end2; i++) {
            hist[s2.charAt(i) - 'A']--;
        }

        for (int count : hist) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(!solution.isScramble("g", "t") + "\t" + !solution.isScramble2("g", "t"));

        System.out.println(solution.isScramble("g", "g") + "\t" + solution.isScramble2("g", "g"));

        System.out.println(solution.isScramble("great", "rgeat") +"\t" + solution.isScramble2("great", "rgeat"));
        System.out.println(solution.isScramble("great", "eatrg") + "\t" +solution.isScramble2("great", "eatrg") );

        System.out.println(!solution.isScramble("abcde", "caebd") + "\t" + !solution.isScramble2("abcde", "caebd"));

        System.out.println(solution.isScramble("abcde", "cbade") + "\t" + solution.isScramble2("abcde", "cbade"));
    }
}
