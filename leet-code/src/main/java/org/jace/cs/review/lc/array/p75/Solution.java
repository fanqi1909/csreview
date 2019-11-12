package org.jace.cs.review.lc.array.p75;

import java.util.Arrays;

/**
 * bound two points, p0 and p2, which states next cell for zero and prev cell for two.
 * use p1 as a pointer to scan in between p0 and p2.
 * if found 0, swap with p0 and increment both
 * if found 2, swap with p2 and decrease p2. we cannot increase p1 as the value p2 holds has not been examined yet, instead, it will be examined in the next round
 * if found 1, then increment p1
 */
public class Solution {

    public void sortColors(int[] nums) {
        if (nums.length == 1) return;
        int p0 = 0;
        int p2 = nums.length - 1;

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
