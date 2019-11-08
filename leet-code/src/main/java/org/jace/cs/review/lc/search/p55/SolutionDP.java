package org.jace.cs.review.lc.search.p55;

import java.util.Arrays;

public class SolutionDP {
    public boolean canJump(int[] nums) {

        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i] = dp[i] || (dp[j] && i + nums[i] >= j);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[0];
    }

    public static void main(String[] args) {
        SolutionDP solution = new SolutionDP();
        int[] test;

        test = new int[]{2,3,1,1,4};
        System.out.println(Arrays.toString(test) + "\t" + solution.canJump(test));

        test = new int[]{3,2,1,0,4};
        System.out.println(Arrays.toString(test) + "\t" + !solution.canJump(test));
    }
}