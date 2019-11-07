package org.jace.cs.review.lc.interval.p57;

import org.jace.cs.review.lc.dp.Util;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        Queue<int[]> tempResult = new LinkedList<>();
        boolean inserted = false;
        for (int[] current : intervals) {
            //mergeable
            if (current[1] < newInterval[0]) {
                tempResult.add(current);
            } else if (newInterval[1] < current[0]) {
                if (!inserted) {
                    tempResult.add(newInterval);
                    inserted = true;
                }
                tempResult.add(current);
            } else {
                newInterval = new int[]{Math.min(current[0], newInterval[0]),
                        Math.max(current[1], newInterval[1])};
            }
        }


        //newInterval at last position
        if(!inserted) {
            tempResult.add(newInterval);
        }

        int[][] result = new int[tempResult.size()][2];
        int i = 0;
        while(!tempResult.isEmpty()) {
            result[i++] = tempResult.poll();
        }

        return result;
    }


    public static void main(String[] args) {
        int[][] intervals;
        int[] newInterval;
        Solution solution = new Solution();

        intervals = new int[][]{
                new int[]{1, 3},
                new int[]{6, 9},
        };
        newInterval = new int[]{2, 5};

        Util.print2DArray(solution.insert(intervals, newInterval));


        intervals = new int[][]{
                new int[]{1, 2},
                new int[]{3, 5},
                new int[]{6, 7},
                new int[]{8, 10},
                new int[]{12, 16},
        };
        newInterval = new int[]{4, 8};

        Util.print2DArray(solution.insert(intervals, newInterval));


        intervals = new int[][]{
                new int[]{1, 2},
                new int[]{3, 5},
        };
        newInterval = new int[]{17,20};

        Util.print2DArray(solution.insert(intervals, newInterval));

        intervals = new int[][]{
                new int[]{3, 5},
                new int[]{6, 7},
        };
        newInterval = new int[]{0,2};

        Util.print2DArray(solution.insert(intervals, newInterval));

        intervals = new int[][]{
                new int[]{3, 5},
                new int[]{6, 7},
        };
        newInterval = new int[]{0,4};

        Util.print2DArray(solution.insert(intervals, newInterval));

        intervals = new int[][]{
                new int[]{3, 5},
                new int[]{6, 7},
        };
        newInterval = new int[]{0,9};

        Util.print2DArray(solution.insert(intervals, newInterval));

        intervals = new int[][]{
                new int[]{3, 5},
                new int[]{9, 10},
        };
        newInterval = new int[]{6,8};

        Util.print2DArray(solution.insert(intervals, newInterval));
    }
}
