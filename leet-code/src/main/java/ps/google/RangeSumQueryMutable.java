package ps.google;

import org.jace.cs.review.lc.dp.Util;
import ps.google.design.RandomizedSet;

import java.util.Arrays;

/**
 * This is a naive implementation using prefix table to compute the range of sums.
 * Creation (n^2)
 * Update (n^2)
 * Query (1)
 *
 * Another implementation is to use Bit-Indexed-Array for each row/column
 * Creation (n^2)
 * Update (log(n))
 * Query (nlog(n))
 */
public class RangeSumQueryMutable {

    int[][] copy;
    long[][] prefixSum;

    public RangeSumQueryMutable(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        copy = new int[matrix.length][];
        for(int i = 0; i < matrix.length; i++) {
            copy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }

        prefixSum = new long[matrix.length][matrix[0].length];

        prefixSum[0][0] = copy[0][0];

        for(int i = 1; i < copy[0].length; i++) {
            prefixSum[0][i] = copy[0][i] + prefixSum[0][i-1];
        }
        for(int i = 1; i < copy.length; i++) {
            prefixSum[i][0] = copy[i][0] + prefixSum[i-1][0];
        }


        for(int i = 1; i < copy.length; i++) {
            for(int j = 1; j < copy[i].length; j++) {
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + copy[i][j];
            }
        }

//        Util.print2DArray(copy);
//        Util.print2DArray(prefixSum);
    }

    public void update(int row, int col, int val) {
        if(copy == null) return;
        int diff = val - copy[row][col];
        copy[row][col] = val;

        for(int i = row; i < prefixSum.length; i++) {
            for(int j = col; j < prefixSum[i].length; j++) {
                prefixSum[i][j] += diff;
            }
        }
//        Util.print2DArray(copy);
//        Util.print2DArray(prefixSum);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(copy == null) return 0;
        if(row1 == 0 && col1 == 0) {
            return (int)prefixSum[row2][col2];
        } else if(row1 == 0) {
            return (int)(prefixSum[row2][col2] - prefixSum[row2][col1 - 1]);
        } else if(col1 == 0) {
            return (int)(prefixSum[row2][col2] - prefixSum[row1 -1][col2]);
        } else {
            return (int)(prefixSum[row2][col2] - prefixSum[row1-1][col2] - prefixSum[row2][col1-1] + prefixSum[row1-1][col1-1]);
        }
    }

    public static void main(String[] args) {
        RangeSumQueryMutable rsqm = new RangeSumQueryMutable(new int[][]{
                new int[]{3, 0, 1, 4, 2},
                new int [] {5, 6, 3, 2, 1},
                new int[] {1, 2, 0, 1, 5},
                new int[] {4, 1, 0, 1, 7},
                new int[] {1, 0, 3, 0, 5}
        });

        System.out.println(rsqm.sumRegion(2, 1, 4, 3));
        rsqm.update(3, 2, 2);
        System.out.println(rsqm.sumRegion(2, 1, 4, 3));

        System.out.println(rsqm.sumRegion(0, 0, 4, 3));

        System.out.println(rsqm.sumRegion(1, 0, 4, 3));
        System.out.println(rsqm.sumRegion(0, 1, 4, 3));
        System.out.println(rsqm.sumRegion(2, 0, 4, 0 ));
        System.out.println(rsqm.sumRegion(0, 3, 0, 4 ));

        rsqm = new RangeSumQueryMutable(new int[][]{});
        System.out.println(rsqm.sumRegion(2,1,4,3));
    }
}
