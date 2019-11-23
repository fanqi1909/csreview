package contest.c161.p5250;

/**
 * Given an array nums of positive integers. Your task is to select some subset of nums, multiply each element by an integer and add all these numbers. The array is said to be good if you can obtain a sum of 1 from the array by any possible subset and multiplicand.
 *
 * Return True if the array is good otherwise return False.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [12,5,7,23]
 * Output: true
 * Explanation: Pick numbers 5 and 7.
 * 5*3 + 7*(-2) = 1
 * Example 2:
 *
 * Input: nums = [29,6,10]
 * Output: true
 * Explanation: Pick numbers 29, 6 and 10.
 * 29*1 + 6*(-3) + 10*(-1) = 1
 * Example 3:
 *
 * Input: nums = [3,6]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 *  ---------------
 *
 *  This needs to use remainder theorem..
 *  if x, y are co-prime, then exist integer a,b such that ax+by = 1.
 *
 *  Another observation is:
 *
 *  if x, y are co-prime, then x, y, a0, a1, ..., an are all co-prime
 *
 *  So the problem turns to be find the greater common divisor of int[] nums, and test if it is equal to 1.
 *  .. If you know, you know; If you don't know, you won't know.
 */
class Solution {
    public boolean isGoodArray(int[] nums) {
        int gcdForAll = nums[0];
        for(int i = 1; i < nums.length; i++) {
            gcdForAll = gcd(nums[i], gcdForAll);
        }
        return gcdForAll == 1;
    }

    public int gcd(int a, int b) {
        while(b > 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isGoodArray(new int[] {12, 5, 7, 23}));
        System.out.println(solution.isGoodArray(new int[] {29, 6, 10}));
        System.out.println(solution.isGoodArray(new int[] {3, 6}));
        System.out.println(solution.isGoodArray(new int[] {6, 10, 15}));
    }
}