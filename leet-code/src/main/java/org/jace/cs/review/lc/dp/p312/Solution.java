package org.jace.cs.review.lc.dp.p312;

public class Solution {

    /**
     * Let dp[i][j] be the optimal solution for array nums(i...j) for all (i < j).
     * If the last balloon to be burst in the range of [i,j] is k, then the score of this strategy is:
     *      dp[i][k-1] + dp[k+1][j] + nums[i-1] * nums[k] * nums[j+1]
     * Note that nums[i-1] and nums[j+1] is out of range [i,j]. When k is the last balloon to be burst, the nums[i-1]
     * and nums[j+1] would be its neighbor.
     *
     * Thus, the optimal solution of dp[i][j] would be:
     *      max(dp[i][k-1] + dp[k+1][j] + nums[i-1]*nums[k]*nums[j+1])  for all k in [i,j];
     *
     * Since the dp[i][j] is depending on dp[i][k-1], dp[k+1][j], we need to fill-up the table from the bottom right corner.
     *
     * i.e.:
     * 0	0	0	0
     * 0	0	0	0
     * 0	0	0	0
     * 0	0	0	40
     * ----------------
     * 0	0	0	0
     * 0	0	0	0
     * 0	0	40	0
     * 0	0	0	40
     * ----------------
     * 0	0	0	0
     * 0	0	0	0
     * 0	0	40	48
     * 0	0	0	40
     * ----------------
     * 0	0	0	0
     * 0	15	0	0
     * 0	0	40	48
     * 0	0	0	40
     * ----------------
     * 0	0	0	0
     * 0	15	135	159
     * 0	0	40	48
     * 0	0	0	40
     * ----------------
     * 3	0	0	0
     * 0	15	135	159
     * 0	0	40	48
     * 0	0	0	40
     * ----------------
     * 3	30	159	0
     * 0	15	135	159
     * 0	0	40	48
     * 0	0	0	40
     * ----------------
     * 3	30	159	167
     * 0	15	135	159
     * 0	0	40	48
     * 0	0	0	40
     * ----------------
     *
     */
    public int maxCoins(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int[][] dp = new int[nums.length][nums.length];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i; j < dp[i].length; j++) {
                //compute dp[i][j]
                int left = (i >= 1 ? nums[i - 1] : 1);
                int right = (j <= dp[i].length - 2) ? nums[j + 1] : 1;
                int max = -1;
                for (int x = i; x <= j; x++) {
                    int candidate = nums[x] * left * right;
                    if (x - 1 >= 0) {
                        candidate += dp[i][x - 1];
                    }
                    if (x + 1 < dp[i].length) {
                        candidate += dp[x + 1][j];
                    }
                    if (candidate > max) {
                        max = candidate;
                    }
                }
                dp[i][j] = max;
                print2DArray(dp);
            }
        }
        return dp[0][nums.length - 1];
    }

    void print2DArray(int[][] dp) {
        System.out.println("----------------");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("----------------");
    }
}

