package org.jace.cs.review.lc.contest.c162.p1253;

public class Solution {

    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];

        int odd = 0;
        for (int[] index : indices) {
            for (int i = 0; i < m; i++) {
                if((matrix[index[0]][i] & 1)  == 1) {
                    odd--;
                } else {
                    odd++;
                }
                matrix[index[0]][i]++;
            }
            for (int j = 0; j < n; j++) {
                if(( matrix[j][index[1]] & 1)  == 1) {
                    odd--;
                } else {
                    odd++;
                }
                matrix[j][index[1]]++;
            }
        }

////        int odd = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if ((matrix[i][j] & 1) == 1) {
////                    odd++;
//                }
//            }
//        }
        return odd;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] testIndices;

        testIndices = new int[][] {
                new int[]{0, 1},
                new int[]{1, 1}
        };

        System.out.println(solution.oddCells(2, 3, testIndices));

        testIndices = new int[][] {
                new int[]{1, 1},
                new int[]{0, 0}
        };

        System.out.println(solution.oddCells(2, 2, testIndices));
    }
}
