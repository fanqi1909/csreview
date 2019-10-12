package org.jace.cs.review.lc.binarysearch.p33;

import java.util.Arrays;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[left] < nums[right]) {
                if(target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if(nums[mid] >= nums[left]) {
                if(target <= nums[right] || target > nums[mid]) {
                    left = mid +1;
                } else {
                    right = mid - 1;
                }
            } else if(nums[mid] <= nums[right]) {
                if(target >= nums[left]) {
                    right = mid - 1;
                } else if(target > nums[right]) {
                    return -1;
                } else if(target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                //nums[mid] is in between left and right, which is not possible
                return -1;
            }
        }

        return -1;
    }
}