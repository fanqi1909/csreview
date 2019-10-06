package org.jace.cs.review.lc.sorting.p16;

import java.util.Arrays;

public class SolutionN2LogN implements Solution {

    @Override
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int closestSum = 0;
        int minGap = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                //find the closest k;
                int twoSum = nums[i] + nums[j];
                int insertionPoint = Arrays.binarySearch(nums, j + 1, nums.length, target - twoSum);
                if (insertionPoint >= 0) {
                    //found;
                    return target;
                } else {
                    //recover insertionPoint;
                    insertionPoint = Math.max(-insertionPoint - 2, j + 1);
                    int threeSum = twoSum + nums[insertionPoint];
                    int gap = Math.abs(threeSum - target);
                    if (gap < minGap) {
                        minGap = gap;
                        closestSum = threeSum;
                    }
                    if (insertionPoint < nums.length - 1) {
                        insertionPoint++;
                        threeSum = twoSum + nums[insertionPoint];
                        gap = Math.abs(threeSum - target);
                        if (gap < minGap) {
                            minGap = gap;
                            closestSum = threeSum;
                        }
                    }
                }
            }
        }
        return closestSum;
    }
}
