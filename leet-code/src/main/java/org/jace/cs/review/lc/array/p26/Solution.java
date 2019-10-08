package org.jace.cs.review.lc.array.p26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int next = 0; int probe = 1;
        while(probe < nums.length) {
            if(nums[probe] == nums[next]) {
                probe++;
            } else {
                nums[++next] = nums[probe];
                probe++;
            }
        }
        return next+1;
    }
}
