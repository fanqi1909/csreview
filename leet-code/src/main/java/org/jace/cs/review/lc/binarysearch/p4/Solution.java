package org.jace.cs.review.lc.binarysearch.p4;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];

        int counter = 0;
        int p1 = 0, p2 = 0;

        while(p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1] < nums2[p2]) {
                merged[counter++] = nums1[p1++];
            } else {
                merged[counter++] = nums2[p2++];
            }
        }

        while(p2 < nums2.length) {
            merged[counter++] = nums2[p2++];
        }
        while(p1 < nums1.length) {
            merged[counter++] = nums1[p1++];
        }

        return median(merged);
    }

    private double median(int[] nums) {
        int left = nums.length >> 1;
        int right = (nums.length - 1) >>  1;
        return (nums[left] + nums[right]) / 2.0;
    }

}