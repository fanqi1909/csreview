package org.jace.cs.review.lc.array.p53;

import java.util.Arrays;

public class Solution {
    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            max = Math.max(currentSum, max);
            currentSum = Math.max(currentSum, 0);
        }

        return max;
    }


    public static void main(String[] args ) {
        int[] test;
        Solution solution = new Solution();

        test = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(Arrays.toString(test) + "\t 6 === " + (solution.maxSubArray(test) == 6));
    }

}
