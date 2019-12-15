package contest.c167;

import org.jace.cs.review.lc.dp.Util;

public class Q3 {
    long[][] prefixSum;

    public int maxSideLength(int[][] matrix, int threshold) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        prefixSum = new long[matrix.length][matrix[0].length];

        prefixSum[0][0] = matrix[0][0];

        for (int i = 1; i < matrix[0].length; i++) {
            prefixSum[0][i] = matrix[0][i] + prefixSum[0][i - 1];
        }
        for (int i = 1; i < matrix.length; i++) {
            prefixSum[i][0] = matrix[i][0] + prefixSum[i - 1][0];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + matrix[i][j];
            }
        }

//        Util.print2DArray(prefixSum);
        int maxLen = 0;
        for (int i = 0; i < matrix.length; i++) {
            //enumerate all lengths;
            for (int j = 0; j < matrix[i].length; j++) {
                int len = 1;
                while (i - len + 1 >= 0 && j - len + 1 >= 0) {
                    if (sumRegion(i - len + 1, j - len + 1, i, j) <= threshold) {
                        maxLen = Math.max(maxLen, len);
                    }
                    len++;
                }
            }
        }
        return maxLen;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (prefixSum == null) return 0;
        if (row1 == 0 && col1 == 0) {
            return (int) prefixSum[row2][col2];
        } else if (row1 == 0) {
            return (int) (prefixSum[row2][col2] - prefixSum[row2][col1 - 1]);
        } else if (col1 == 0) {
            return (int) (prefixSum[row2][col2] - prefixSum[row1 - 1][col2]);
        } else {
            return (int) (prefixSum[row2][col2] - prefixSum[row1 - 1][col2] - prefixSum[row2][col1 - 1] + prefixSum[row1 - 1][col1 - 1]);
        }
    }

    public static void main(String[] args) {
        Q3 solution = new Q3();
       System.out.println(solution.maxSideLength(new int[][]{
                new int[]{1, 1, 3, 2, 4, 3, 2},
                new int[]{1, 1, 3, 2, 4, 3, 2},
                new int[]{1, 1, 3, 2, 4, 3, 2}
        }, 4));

        System.out.println(solution.maxSideLength(new int[][]{
                new int[]{2,2,2,2,2},
                new int[]{2,2,2,2,2},
                new int[]{2,2,2,2,2},
                new int[]{2,2,2,2,2}
        }, 1));

        System.out.println(solution.maxSideLength(new int[][]{
                new int[]{1,1,1,1},
                new int[]{1,0,0,0},
                new int[]{1,0,0,0},
                new int[]{1,0,0,0}
        }, 6));
    }
}
