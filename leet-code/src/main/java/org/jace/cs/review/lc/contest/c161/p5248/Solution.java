package org.jace.cs.review.lc.contest.c161.p5248;

import java.util.ArrayList;

public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        if(nums.length < k) {
            return 0;
        }
        ArrayList<Integer> odds = new ArrayList<>();
        //padding with -1 and nums.length to simplify the loop
        odds.add(-1);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 1) {
                odds.add(i);
            }
        }
        odds.add(nums.length);

        int numOfSubArrays = 0;
        for(int i = 1; i < odds.size() - k; i++) {
            int j = i + k - 1;
            int before = odds.get(i)  - odds.get(i-1);
            int after = odds.get(j + 1) - odds.get(j);
            numOfSubArrays += before * (after) ;
        }
        return numOfSubArrays;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSubarrays(new int[]{1,1,2,1,1}, 3));
        System.out.println(solution.numberOfSubarrays(new int[]{1,1,2,1,1}, 1));
        System.out.println(solution.numberOfSubarrays(new int[]{2,4,6}, 1));
        System.out.println(solution.numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));
    }
}
