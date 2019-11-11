package org.jace.cs.review.lc.dp.p72;

public class Solution {

    public int minDistance(String word1, String word2) {
        if (word1.isEmpty()) return word2.length();
        if (word2.isEmpty()) return word1.length();

        int[][] dp = new int[word1.length()][word2.length()];

        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = word1.charAt(0) == word2.charAt(i) ? i : dp[0][i - 1] + 1;
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = word1.charAt(i) == word2.charAt(0) ? i: dp[i - 1][0] + 1;
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int replace = word1.charAt(i) == word2.charAt(j) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
                int delete = dp[i - 1][j] + 1;
                int insert = dp[i][j - 1] + 1;
                dp[i][j] = Math.min(replace, Math.min(delete, insert));
            }
        }

        return dp[word1.length()-1][word2.length()-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("3 === " + solution.minDistance("house", "ros"));
        System.out.println("5 === " + solution.minDistance("intention", "execution"));
        System.out.println("9 === " + solution.minDistance("", "execution"));
        System.out.println("0 === " + solution.minDistance("", ""));

        System.out.println("27 === " + solution.minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"));
    }
}
