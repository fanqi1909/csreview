package ps.google.array.string.matrix;

import org.jace.cs.review.lc.dp.Util;

public class RotateImage {

    /**
     * Rote an image by 90 degree equals to do two operations:
     *
     * 1. transpose the matrix
     * 2. reverse each rows
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix.length - 1;
            while (left < right) {
                int tmp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = tmp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage solution = new RotateImage();

        int[][] matrix = new int[][]{
                new int[]{5, 1, 9, 11},
                new int[]{2, 4, 8, 10},
                new int[]{13, 3, 6, 7},
                new int[]{15, 14, 12, 16}
        };
        Util.print2DArray(matrix);
        solution.rotate(matrix);
        Util.print2DArray(matrix);
    }
}
