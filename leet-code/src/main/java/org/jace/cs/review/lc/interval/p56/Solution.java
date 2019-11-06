package org.jace.cs.review.lc.interval.p56;

import org.jace.cs.review.lc.dp.Util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Use a stack to iterate intervals in ascending order of starting point.
 * If two interval can merge, they will merge and generate a new interval
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        //sort the intervals;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        Stack<int[]> stack = new Stack<>();

        for (int[] interval : intervals) {
            if (stack.isEmpty()) {
                stack.push(interval);
            } else {
                int[] top = stack.peek();
                if (top[1] >= interval[0]) {
                    //can merge
                    int[] merged = new int[]{top[0], Math.max(top[1], interval[1])};
                    stack.pop();
                    stack.push(merged);
                } else {
                    stack.push(interval);
                }
            }
        }
        int[][] output = new int[stack.size()][];
        for (int i = 0; i < output.length; i++) {
            output[i] = stack.pop();
        }
        return output;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test;

        test = new int[][]{
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{15, 18},
                new int[]{8, 10},
        };

        Util.print2DArray(solution.merge(test));

        test = new int[][]{
                new int[]{1, 4},
                new int[]{4, 5},
        };

        Util.print2DArray(solution.merge(test));


        test = new int[][]{
                new int[]{1, 4},
                new int[]{2 ,3},
        };
        Util.print2DArray(solution.merge(test));
    }
}
