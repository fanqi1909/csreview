package org.jace.cs.review.lc.dp.p97;

import org.jace.cs.review.lc.dp.Util;

public class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() == 0) {
            return s3.equals(s2);
        }
        if (s2.length() == 0) {
            return s3.equals(s1);
        }

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        String min = s1, max = s2;
        if (s1.length() > s2.length()) {
            min = s2;
            max = s1;
        }
        s1 = min;
        s2 = max;


        boolean[][] dp = new boolean[s3.length() + 1][s1.length() + 1];
        dp[0][0] = true;
        for (int k = 1; k <= s3.length() && dp[k - 1][0]; k++) {
            dp[k][0] = dp[k - 1][0] && k <= s2.length() && s2.charAt(k - 1) == s3.charAt(k - 1); //&& s2.substring(0, k) .equals(s3.substring(0, k));
        }


        for (int k = 1; k <= s3.length(); k++) {
            for (int i = 1; i <= s1.length(); i++) {
                int j = k - i;
                dp[k][i] = dp[k - 1][i - 1] && s1.charAt(i - 1) == s3.charAt(k - 1);
                if (j > 0 && j <= s2.length()) {
                    dp[k][i] |= dp[k - 1][i] && s2.charAt(j - 1) == s3.charAt(k - 1);
                }
            }
        }

        return dp[s3.length()][s1.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(!solution.isInterleave("a", "b", "a"));

        System.out.println(solution.isInterleave("ab", "aac", "aabac"));
        System.out.println(solution.isInterleave("aac", "ab", "aabac"));
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(!solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));

    }
}
