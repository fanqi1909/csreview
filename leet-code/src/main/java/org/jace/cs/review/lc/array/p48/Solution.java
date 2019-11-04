package org.jace.cs.review.lc.array.p48;

import org.jace.cs.review.lc.dp.Util;

import java.util.Arrays;
import java.util.List;

/**
 * Rotate the matrix layer by layer. For each layer, use the positions formula to calculate the next position
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int rank = matrix.length;
        for (int i = 0; i < rank / 2; i++) {
            rotateLayer(matrix, i, rank - i * 2);
        }
    }

    private void rotateLayer(int[][] matrix, int base, int n) {
        for (int x = 0; x < n - 1; x++) {
            List<Pair> positions = positions(base, n, x);
            rotate(matrix, positions);
        }
    }

    private void rotate(int[][] matrix, List<Pair> positions) {
        Pair first = positions.get(0);
        int prev = matrix[first.row][first.column];
        for (int i = 1; i < positions.size(); i++) {
            Pair current = positions.get(i);
            int temp = matrix[current.row][current.column];
            matrix[current.row][current.column] = prev;
            prev = temp;
        }
        matrix[first.row][first.column] = prev;
    }

    private List<Pair> positions(int base, int n, int x) {
        return Arrays.asList(
                Pair.of(base, base + x),
                Pair.of(base + x, n + base - 1),
                Pair.of(n + base - 1, n + base - 1 - x),
                Pair.of(n + base - 1 - x, base)
        );
    }

    static class Pair {
        public int row;
        public int column;

        public Pair(int r, int c) {
            row = r;
            column = c;
        }

        public static Pair of(int r, int c) {
            return new Pair(r, c);
        }

        @Override
        public String toString() {
            return String.format("[%d, %d]", row, column);
        }
    }

    public static void main(String[] args) {
        int[][] matrix;

        matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
        };

        Solution solution = new Solution();
        solution.rotate(matrix);
        Util.print2DArray(matrix);

        matrix = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
                new int[]{13, 14, 15, 16},
        };
        solution.rotate(matrix);
        Util.print2DArray(matrix);

        matrix = new int[][]{
                new int[]{1, 2, 3, 4, 5, 6},
                new int[]{7, 8, 9, 10, 11, 12},
                new int[]{13, 14, 15, 16, 17, 18},
                new int[]{19, 20, 21, 22, 23, 24},
                new int[]{25, 26, 27, 28, 29, 30},
                new int[]{31, 32, 33, 34, 35, 36},
        };

        solution.rotate(matrix);
        Util.print2DArray(matrix);

        matrix = new int[][]{
                new int[]{1, 2, 3, 4, 5, 6, 7, 8},
                new int[]{9, 10, 11, 12, 13, 14, 15, 16},
                new int[]{17, 18, 19, 20, 21, 22, 23, 24},
                new int[]{25, 26, 27, 28, 29, 30, 31, 32},
                new int[]{33, 34, 35, 36, 37, 38, 39, 40},
                new int[]{41, 42, 43, 44, 45, 46, 47, 48},
                new int[]{49, 50, 51, 52, 53, 54, 55, 56},
                new int[]{57, 58, 59, 60, 61, 62, 63, 64},
        };

        solution.rotate(matrix);
        Util.print2DArray(matrix);
    }

}
