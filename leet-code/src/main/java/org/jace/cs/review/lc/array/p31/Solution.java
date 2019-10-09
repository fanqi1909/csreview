package org.jace.cs.review.lc.array.p31;

import java.util.Arrays;

public class Solution {

    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        while(i > 0 && nums[i] <= nums[i-1]) {
            i--;
        }
        if(i > 0) {
            Arrays.sort(nums, i, nums.length);
            int j = i-1;
            int k = i;
            while(k < nums.length && nums[k] <= nums[j]) {
                k++;
            }
            swap(nums, j, k);
        } else {
            //reverser array
            int l = 0, r = nums.length - 1;
            while(l < r) {
                swap(nums, l, r);
                l++;
                r--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}