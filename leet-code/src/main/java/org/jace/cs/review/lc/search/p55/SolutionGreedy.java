package org.jace.cs.review.lc.search.p55;

import java.util.Arrays;

public class SolutionGreedy {
    public boolean canJump(int[] nums) {
        int lastReachable = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastReachable) {
                lastReachable = i;
            }
        }
        return lastReachable == 0;
    }

    public static void main(String[] args) {
        SolutionGreedy solution = new SolutionGreedy();
        int[] test;

        test = new int[]{2, 3, 1, 1, 4};
        System.out.println(Arrays.toString(test) + "\t" + solution.canJump(test));

        test = new int[]{3, 2, 1, 0, 4};
        System.out.println(Arrays.toString(test) + "\t" + !solution.canJump(test));
    }
}