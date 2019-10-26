package org.jace.cs.review.lc.dp.p300;

import java.util.Arrays;

/**
 * Classic DP solution
 */
public class SolutionDP implements Solution {

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int[] lisSofar = new int[nums.length];

        int max = 1;
        lisSofar[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            lisSofar[i] = 1;
            for(int j = i-1; j >= 0; j--) {
                if(nums[i] > nums[j]){
                    lisSofar[i] = Math.max(lisSofar[i], lisSofar[j] + 1);
                }
            }
            if(lisSofar[i] > max) {
                max = lisSofar[i];
            }
        }

        return max;
    }
}
