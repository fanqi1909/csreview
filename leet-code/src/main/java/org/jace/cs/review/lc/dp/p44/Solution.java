package org.jace.cs.review.lc.dp.p44;

public class Solution {
    public boolean isMatch(String s, String p) {
        s = "#" + s;
        p = "#" + p;

        boolean[][] matching = new boolean[p.length()][s.length()];
        matching[0][0] = true;
        for (int i = 1; i < p.length(); i++) {
            matching[i][0] = p.charAt(i) == '*' && matching[i-1][0];
        }

        for (int i = 1; i < p.length(); i++) {
            char cp = p.charAt(i);
            for (int j = 1; j < s.length(); j++) {
                char cs = s.charAt(j);

                if(cp == cs || cp == '?') {
                    matching[i][j] = matching[i-1][j-1]; // depends on previous match
                } else if(cp != '*') {
                    matching[i][j] = false;
                } else { //cp == '*'
                    matching[i][j] = matching[i][j-1] || matching[i-1][j];
                }
            }
        }

        return matching[p.length() - 1][s.length() - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s, p;

        s = "aa";
        p = "a";
        System.out.println(s + "\t" + p + "\t" + (!solution.isMatch(s, p)));

        s = "aa";
        p = "*";
        System.out.println(s + "\t" + p + "\t" + (solution.isMatch(s, p)));

        s = "cb";
        p = "?a";
        System.out.println(s + "\t" + p + "\t" + (!solution.isMatch(s, p)));

        s = "adceb";
        p = "*a*b";
        System.out.println(s + "\t" + p + "\t" + (solution.isMatch(s, p)));

        s = "acdcb";
        p = "a*c?b";
        System.out.println(s + "\t" + p + "\t" + (!solution.isMatch(s, p)));

        s = "aab";
        p = "c*a*b";
        System.out.println(s + "\t" + p + "\t" + (!solution.isMatch(s, p)));

        s = "a";
        p = "a*";
        System.out.println(s + "\t" + p + "\t" + (solution.isMatch(s, p)));

    }
}

