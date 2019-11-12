package org.jace.cs.review.lc.array.p75;

import java.util.Arrays;

public class Solution {

    public void sortColors(int[] nums) {
        if (nums.length == 1) return;
        int p0 = 0;
        int p2 = nums.length - 1;

        while (p2 >= 0 && nums[p2] == 2) p2--;
        while (p0 < nums.length && nums[p0] == 0) p0++;

        int p1 = p0;
        while (p1 <= p2) {
            if (nums[p1] == 2) {
                swap(nums, p1, p2);
                p2--;
            } else if (nums[p1] == 0) {
                swap(nums, p0, p1);
                p0++;
                p1++;
            } else {
                p1++;
            }
        }
    }

    private void swap(int[] nums, int p0, int p2) {
        int tmp = nums[p0];
        nums[p0] = nums[p2];
        nums[p2] = tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] test;

        test = new int[]{2, 0, 2, 1, 1, 0};
        solution.sortColors(test);
        System.out.println(Arrays.toString(test));


        test = new int[]{2, 0, 2, 1, 1, 0, 1, 2, 2, 0, 0, 0, 1, 2, 0, 0, 1, 2};
        solution.sortColors(test);
        System.out.println(Arrays.toString(test));

        test = new int[]{1, 0, 0, 0, 2, 2, 2, 2, 1, 1, 1, 1, 2, 0, 1};
        solution.sortColors(test);
        System.out.println(Arrays.toString(test));

        test = new int[]{0, 0};
        solution.sortColors(test);
        System.out.println(Arrays.toString(test));
    }
}
