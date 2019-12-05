package ps.google.dp;

import java.util.LinkedHashMap;

public class SplitArrayLargestSum {

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
                    } else {
                        if(dp[i][j] > sum) {
                            dp[i][j] = sum;
                        }
                        break;
                    }
                }
            }
//            System.out.println(i);
//            Util.print2DArray(dp);
        }
        return (int)dp[m - 1][0];
    }

    public int splitArrayBS(int[] nums, int m) {
        long maxSum = 0;
        for(int num : nums) {
            maxSum += num;
        }

        long l = nums[0], r = maxSum;

        while(l < r) {
            long mid = (l + r) >>> 1;
            //check mid
            if(!checkmid(nums, mid, m)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return (int)l;
    }

    private boolean checkmid(int[] nums, long target, int m) {
        int currentSum = 0; int parts = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > target) {
                return false;
            }
            if (currentSum + nums[i] <= target) {
                currentSum += nums[i];
            } else {
                parts++;
                currentSum = 0;
                i--;
            }
        }
        return parts <= m - 1;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum sas = new SplitArrayLargestSum();

        System.out.println(sas.checkmid(new int[]{7,2,5,10,8}, 2, 2));
        System.out.println(sas.checkmid(new int[]{7,2,5,10,8}, 7, 2));
        System.out.println(sas.checkmid(new int[]{7,2,5,10,8}, 15, 2));
        System.out.println(sas.checkmid(new int[]{7,2,5,10,8}, 18, 2));
        System.out.println(sas.checkmid(new int[]{7,2,5,10,8}, 10, 5));

        System.out.println(sas.splitArrayBS(new int[]{7,2,5,10,8}, 2));
        System.out.println(sas.splitArrayBS(new int[]{1,2147483647}, 2));

    }
}
