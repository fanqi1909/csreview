package org.jace.cs.review.lc.matrix.p74;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        if(matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        long left = 0; long right = m * n - 1;

        while(left < right) {
            long mid = (left + right ) >>> 1;

            int midRow = (int)(mid/n);
            int midCol = (int)(mid%n);
            if(matrix[midRow][midCol] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return matrix[(int)(left/n)][(int)(left%n)] == target;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 50}
        };

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j] + " in " + solution.searchMatrix(matrix, matrix[i][j]));
            }
        }

        System.out.println("13 not in " + !solution.searchMatrix(matrix, 13));

    }
}
