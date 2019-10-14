package org.jace.cs.review.lc.binarysearch.p34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }

    private int findFirst(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = (left + right) >>> 1;
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if(nums[right] != target) {
            return -1;
        } else {
            return right;
        }
    }

    private int findLast(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = (left + right + 1) >>> 1;

            if(nums[mid] > target) {
                //exclude mid
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if(nums[left] != target) {
            return -1;
        } else {
            return left;
        }
    }
}
