package org.jace.cs.review.lc.dp.p64;

import org.jace.cs.review.lc.dp.Util;

public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;
        if(grid[0].length == 0) return 0;

        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                dp[i][j] = grid[i][j] + Math.min(
                        dp[i][j-1], dp[i-1][j]
                );
            }
        }

//        Util.print2DArray(dp);

        return dp[dp.length -1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] test;

        test = new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1}
        };

        System.out.println("7 ===" + solution.minPathSum(test));

        test = new int[][]{
                new int[]{1, 3, 1},
        };
        System.out.println("5 ===" + solution.minPathSum(test));

        test = new int[][]{
                new int[]{1},
                new int[]{3},
                new int[]{1}
        };
        System.out.println("5 ===" + solution.minPathSum(test));

        test = new int[][]{
                new int[]{1, 3, 1, 5},
                new int[]{1, 5, 1, -1},
                new int[]{4, 2, -10, 8},
                new int[]{3, 2, -2, 5}
        };

        System.out.println("7 ===" + solution.minPathSum(test));

    }
}
