package org.jace.cs.review.lc.sorting.p16;

public class SolutionBF implements Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = 0;
        int minGap = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                //find the closest k;
                int twoSum = nums[i] + nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int threeSum = twoSum + nums[k];
                    int gap = Math.abs(target - threeSum);
                    if (gap < minGap) {
                        minGap = gap;
                        closestSum = threeSum;
                    }
                }
            }
        }
        return closestSum;
    }
}
