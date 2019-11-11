package org.jace.cs.review.lc.matrix.p73;

import org.jace.cs.review.lc.dp.Util;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(Integer row: rows) {
            for(int i = 0; i < matrix[row].length; i++) {
                matrix[row][i] = 0;
            }
        }

        for(Integer col: cols) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test;

        test = new int[][]{
                new int[]{1,1,1},
                new int[]{1,0,1},
                new int[]{1,1,1}
        };

        solution.setZeroes(test);
        Util.print2DArray(test);

        test = new int[][]{
          new int[]{0, 1, 2, 0},
                new int[]{3, 4, 5, 2},
                new int[]{1, 3, 1, 5},
        };
        solution.setZeroes(test);
        Util.print2DArray(test);

        test = new int[][]{};
        solution.setZeroes(test);
        Util.print2DArray(test);

    }
}
