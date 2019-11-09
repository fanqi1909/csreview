package org.jace.cs.review.lc.dp.p63;

import org.jace.cs.review.lc.dp.Util;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;

        int[][] ways = new int[obstacleGrid.length][obstacleGrid[0].length];

        ways[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < ways.length; i++) {
            ways[i][0] = obstacleGrid[i][0] == 1 ? 0 : ways[i-1][0];
        }

        for (int i = 1; i < ways[0].length; i++) {
            ways[0][i] = obstacleGrid[0][i] == 1 ? 0 : ways[0][i-1];
        }

        for (int i = 1; i < ways.length; i++) {
            for (int j = 1; j < ways[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    ways[i][j] = 0;
                } else {
                    ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
                }
            }
        }

        return ways[ways.length - 1][ways[0].length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] tests;

        tests = new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 0}
        };

        System.out.println("2 === " + solution.uniquePathsWithObstacles(tests));

        tests = new int[][]{
                new int[]{0, 0, 0,0},
                new int[]{0, 1, 0,0},
                new int[]{0, 0, 0,0},
                new int[]{0, 0, 0,0}
        };
        System.out.println("8 === " + solution.uniquePathsWithObstacles(tests));

        tests = new int[][]{
                new int[]{0, 0, 0,0},
                new int[]{0, 1, 0,0},
                new int[]{0, 0, 1,0},
                new int[]{0, 0, 0,0}
        };
        System.out.println("4 === " + solution.uniquePathsWithObstacles(tests));

        tests = new int[][]{
                new int[]{1, 0}
        };
        System.out.println("0 === " + solution.uniquePathsWithObstacles(tests));
    }
}

