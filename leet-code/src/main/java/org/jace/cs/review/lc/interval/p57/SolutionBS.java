package org.jace.cs.review.lc.interval.p57;

import org.jace.cs.review.lc.dp.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionBS {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int leftMostIndex = latestRightBound(intervals, newInterval[0]);
        int rightMostIndex = earlistLeftBound(intervals, newInterval[1]);

        System.out.println(leftMostIndex + "\t" + rightMostIndex);
        List<int[]> buffer = new ArrayList<>();

        for (int i = 0; i <= leftMostIndex; i++) {
            buffer.add(intervals[i]);
        }

        for (int i = leftMostIndex + 1; i <= rightMostIndex - 1; i++) {
            //merge all intervals;
            int[] current = intervals[i];
            newInterval = new int[]{Math.min(current[0], newInterval[0]),
                    Math.max(current[1], newInterval[1])};
        }
        buffer.add(newInterval);
        for (int i = rightMostIndex; i < intervals.length; i++) {
            buffer.add(intervals[i]);
        }

        int[][] result = new int[buffer.size()][2];
        for (int i = 0, len = buffer.size(); i < len; i++) {
            result[i] = buffer.get(i);
        }

        return result;
    }


    private int latestRightBound(int[][] intervals, int target) {
        int left = -1;
        int right = intervals.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (intervals[mid][1] >= target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }


    private int earlistLeftBound(int[][] intervals, int target) {
        int left = 0;
        int right = intervals.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (intervals[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[][] intervals;
        int[] newInterval;
        SolutionBS solution = new SolutionBS();

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
        newInterval = new int[]{17, 20};

        Util.print2DArray(solution.insert(intervals, newInterval));

        intervals = new int[][]{
                new int[]{3, 5},
                new int[]{6, 7},
        };
        newInterval = new int[]{0, 2};

        Util.print2DArray(solution.insert(intervals, newInterval));

        intervals = new int[][]{
                new int[]{3, 5},
                new int[]{6, 7},
        };
        newInterval = new int[]{0, 4};

        Util.print2DArray(solution.insert(intervals, newInterval));

        intervals = new int[][]{
                new int[]{3, 5},
                new int[]{6, 7},
        };
        newInterval = new int[]{0, 9};

        Util.print2DArray(solution.insert(intervals, newInterval));

        intervals = new int[][]{
                new int[]{3, 5},
                new int[]{9, 10},
        };
        newInterval = new int[]{6, 8};

        Util.print2DArray(solution.insert(intervals, newInterval));

        intervals = new int[][]{
                new int[]{1, 5}
        };
        newInterval = new int[]{5, 7};

        Util.print2DArray(solution.insert(intervals, newInterval));
    }
}
