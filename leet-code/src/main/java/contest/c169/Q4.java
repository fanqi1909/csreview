package contest.c169;

import java.util.*;

public class Q4 {

    public boolean isSolvable(String[] words, String result) {
        int[] mapping = new int[26];
        int[] leadingChar = new int[26];
        Set<Character> allChars = new HashSet<>();
        for(String s : words) {
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                allChars.add(aChar);
            }
            leadingChar[chars[0] - 'A'] = 1;
        }
        char[] chars = result.toCharArray();
        for (char aChar : chars) {
            allChars.add(aChar);
        }

        char[] allchars = new char[allChars.size()];
        int next = 0;
        for(char c: allChars) {
            allchars[next++] = c;
        }

        leadingChar[chars[0] - 'A'] = 1;
        int[] used = new int[10];

        return dfs(0, mapping, used, allchars, leadingChar, words, result);
    }

    private boolean dfs(int next, int[] mapping, int[] used, char[] allChars, int[] leadingChars, String[] words, String result) {
        if(next == allChars.length) {
            return checkPerm(mapping, words, result);
        } else {
            boolean ans = false;

            if(leadingChars[allChars[next] - 'A'] == 0) {
                if(used[0] != 1) {
                    used[0] = 1;
                    mapping[allChars[next] - 'A'] = 0;
                    ans = dfs(next + 1, mapping, used, allChars, leadingChars, words, result);
                    used[0] = 0;
                }
            }

            for(int i = 1; i <=9; i++) {
                if(used[i] != 1) {
                    used[i] = 1;
                    mapping[allChars[next] - 'A'] = i;
                    ans = ans || dfs(next + 1, mapping, used, allChars, leadingChars, words, result);
                    used[i] = 0;
                }
            }

            return ans;
        }
    }

    private boolean checkPerm(int[] mapping, String[] words, String result) {
        int sum = 0;
//        List<Integer> sums = new ArrayList<>();
        for(String word : words) {
            int acc = mapWordToValue(word, mapping);
//            sums.add(acc);
            sum += acc;
        }

        int target = mapWordToValue(result, mapping);
//        if(sum == target) {
//            System.out.println(Arrays.toString(mapping));
//            System.out.println(sums + " = " + target);
//        }
        return sum == target;
    }

    private int mapWordToValue(String word, int[] mapping) {
        int sum = 0;
        char[] chars = word.toCharArray();
        for (char digit : chars) {
            sum = sum * 10 + mapping[digit - 'A'];
        }
        return sum;
    }

    public static void main(String[] args) {
        Q4 sol = new Q4();
        System.out.println(sol.isSolvable(new String[]{"SEND", "MORE"}, "MONEY"));

        System.out.println(sol.isSolvable(new String[]{"SIX", "SEVEN", "SEVEN"}, "TWENTY"));
        System.out.println(sol.isSolvable(new String[]{"THIS", "IS", "TOO"}, "FUNNY"));
        System.out.println(sol.isSolvable(new String[]{"LEET", "CODE"}, "POINT"));
    }
}
