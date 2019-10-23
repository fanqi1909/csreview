package org.jace.cs.review.lc.dp.p410;

import org.jace.cs.review.lc.dp.Util;

/**
 * A DP based solution.
 *
 * dp[i][j] means split the sub array [j,...,length-1] into i pieces.
 * so recursively:
 *    split sub array [j,...length-1] means there are multiple ways:
 *      1. a[j], a[j+1, ..., length-1]
 *      2. a[j, j+1],  a[j+2, ..., length-1]
 *      3. a[j, j+2],  a[j+3, ...., length -1]
 *      ...
 *    Then we just needs to find the minimal among all these combinations
 * formally:
 *   dp[i][j] = min_( j<= s <= length - i) (max(sum(a[j]...a[s]), dp[i-1][s+1])
 * This result in the first solution (see Trick 1)
 *
 * To further optimize:
 *  notice that dp[i] is always decreasing, and  sum() is always increasing, so when we meet the condition (sum > dp), when can
 *  stop searching.
 *
 */
public class Solution {
    public int splitArray(int[] nums, int m) {
        long[][] dp = new long[m][nums.length + 1];

        for (int j = nums.length - 1; j >= 0; j--) {
            dp[0][j] = nums[j] + dp[0][j + 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = nums.length - i; j >= 0; j--) {
                dp[i][j] = Integer.MAX_VALUE;
                long sum = 0;
                for (int s = j; s <= nums.length - i; s++) {
                    sum += nums[s];
                    if(sum < dp[i-1][s+1]) {
                        if(dp[i-1][s+1] < dp[i][j]) {
                            dp[i][j] = dp[i-1][s+1];
                        }
                    } else { //TRICK 2
                        if(dp[i][j] > sum) {
                            dp[i][j] = sum;
                        }
                        break;
                    }
                    // below lines are the TRICK 1
//                    int temp = Math.max(sum, dp[i - 1][s + 1]);
//                    if (temp < dp[i][j]) {
//                        dp[i][j] = temp;
//                    }
                }
            }
//
//            System.out.println(i);
//            Util.print2DArray(dp);
        }
        return (int)dp[m - 1][0];
    }
}
