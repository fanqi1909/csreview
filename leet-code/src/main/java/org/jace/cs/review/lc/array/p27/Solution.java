package org.jace.cs.review.lc.array.p27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) {
            return 0;
        }
        int p = 0; int next = nums.length - 1;
        while(p <= next) {
            if(nums[p] == val) {
                nums[p] = nums[next--];
            } else {
                p++;
            }
        }
        return p ;
    }
}
