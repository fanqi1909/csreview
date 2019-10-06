package org.jace.cs.review.lc.sorting.p16;

import java.util.Arrays;

public class SolutionN2 implements Solution {

    @Override
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = 0;
        int minGap = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {

            int l = i + 1;
            int r = nums.length - 1;

            while( l < r) {
                int threeSum = nums[i] + nums[l] + nums[r];
                int gap = Math.abs(target - threeSum);
                if (gap < minGap) {
                    minGap = gap;
                    closestSum = threeSum;
                }
                if(threeSum < target) {
                    l++;
                } else if(threeSum > target){
                    r--;
                } else {
                    //if the question does not restrict only one solution
//                    l++;
//                    r--;
                    return target;
                }
            }
        }
        return closestSum;
    }
}
