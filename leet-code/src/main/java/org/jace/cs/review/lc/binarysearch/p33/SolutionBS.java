package org.jace.cs.review.lc.binarysearch.p33;

public class SolutionBS {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int m = (l + r + 1) >>> 1;
            if (nums[l] < nums[m]) {
                //pivot is in [m, r]
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m;
                }
            } else {
                if (target > nums[r] || target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m;
                }
            }

        }
        return nums[l] == target ? l : -1;
    }
}