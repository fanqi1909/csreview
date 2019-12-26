package org.jace.cs.review.lc.array.p452;

import org.jace.cs.review.lc.dp.Util;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Greedily bursting balloons from left to right,
 * for every target balloon, shot as right as possible
 *
 * Use currentEnd to find the current shoting position.
 */
public class MinNumOfArrowsOfBurstBalloon {

    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
//        Util.print2DArray(points);
        int burst = 1;
        int i = 0;
        int currentEnd = points[i][1];
        while (i < points.length) {
            if (points[i][0] <= currentEnd) {
                currentEnd = Math.min(currentEnd, points[i][1]);
                i++;
            } else {
                currentEnd = points[i][1];
                burst++;
            }
        }
        return burst;
    }

    public static void main(String[] args) {
        MinNumOfArrowsOfBurstBalloon mab = new MinNumOfArrowsOfBurstBalloon();
        System.out.println(mab.findMinArrowShots(new int[][]{
                new int[]{10, 16},
                new int[]{2, 8},
                new int[]{1, 6},
                new int[]{7, 12}
        }));

        System.out.println(mab.findMinArrowShots(new int[][]{
                new int[]{3, 9},
                new int[]{7, 12},
                new int[]{3, 8},
                new int[]{6, 8},
                new int[]{9, 10},
                new int[]{2, 9},
                new int[]{0, 9},
                new int[]{3, 9},
                new int[]{0, 6},
                new int[]{2, 8},
        }));


        System.out.println(mab.findMinArrowShots(new int[][]{
                new int[]{9, 12},
                new int[]{1, 10},
                new int[]{4, 11},
                new int[]{8, 12},
                new int[]{3, 9},
                new int[]{6, 9},
                new int[]{6, 7}
        }));
    }
}
