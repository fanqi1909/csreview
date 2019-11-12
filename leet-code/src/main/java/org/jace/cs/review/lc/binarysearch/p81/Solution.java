package org.jace.cs.review.lc.binarysearch.p81;

public class Solution {

    public boolean search(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) return true;
        }
        return false;
    }

    public boolean search3(int[] nums, int target) {
        if (nums.length == 0) return false;

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = (l + r + 1) >>> 1;
            if (nums[l] == nums[m] && nums[m] == nums[r]) {
                l++;
                r--;
                continue;
            }
            if (nums[l] <= nums[m]) {
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
        return nums[l] == target;
    }

    public boolean search2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int mid = nums[m];
            int left = nums[l];
            int right = nums[r];

            if (mid == target || left == target || right == target) {
                return true;
            }

            if (left == mid && right == mid) {
                l++;
                r--;
            } else if (left < mid) {
                if (target < mid && target > left) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (target > mid && target < right) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] test = new int[]{
                2, 2, 5, 5, 6, 0, 0, 1, 1
        };

        for (int i = 0; i < 10; i++) {
            System.out.println(solution.search(test, i) + "\t" + solution.search2(test, i) + "\t" + solution.search3(test, i));
        }


        test = new int[]{
                2, 2, 2, 0, 1
        };
        System.out.println(solution.search3(test, 0));

    }
}
