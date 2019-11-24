package contest.c164;

import org.jace.cs.review.lc.dp.Util;

public class P4 {

    public int numWays(int n, int i, int max, Long[][] value) {
        if (n < 0 || i < 0 || i > max) {
            return 0;
        }
        if (value[n][i] != null) {
            return value[n][i].intValue();
        } else {
            if (n == 0) {
                value[n][i] = 1L;
            } else {
                value[n][i] = (long) numWays(n - 1, i - 1, max, value) + numWays(n - 1, i, max, value) + numWays(n - 1, i + 1, max, value);
                if (value[n][i] > 1000000007) {
                    value[n][i] = value[n][i] - 1000000007;
                }
            }
            return value[n][i].intValue();
        }
    }

    public int numWays2(int steps, int arrLen) {
        long[] dp = new long[steps + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 0; i < steps; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] * 2;
            if (dp[i] >= 1000000007) {
                dp[i] = dp[i] - 1000000007;
            }
        }
        return (int) dp[steps];
    }

    //rolling arrays to save space
    public int numWays(int steps, int arrLen) {
        if (arrLen < 1) return 1;
        long[][] ways = new long[arrLen][2];

        ways[0][0] = 1;

        for (int i = 1; i <= steps; ++i) {
            for (int j = 0; j < arrLen; ++j) {
                int index = i % 2;
                int prev = 1 - index;
                // stay
                ways[j][index] = ways[j][prev];
                // move right.
                if (j > 0) {
                    ways[j][index] = (ways[j][index] + ways[j - 1][prev]);
                    if (ways[j][index] > 1000000007) {
                        ways[j][index] = ways[j][index] - 1000000007;
                    }
                }
                // move left
                if (j < arrLen - 1) {
                    ways[j][index] = (ways[j][index] + ways[j + 1][prev]);
                    if (ways[j][index] > 1000000007) {
                        ways[j][index] = ways[j][index] - 1000000007;
                    }
                }
                if (ways[j][index] == 0) {
                    break;
                }
            }
        }
        return (int) ways[0][steps % 2];
    }

    public static void main(String[] args) {
        P4 solution = new P4();
        System.out.println(solution.numWays(3, 4));

        System.out.println(solution.numWays(2, 4));

        System.out.println(solution.numWays(4, 2));

        System.out.println(solution.numWays(4, 5));

        System.out.println(solution.numWays(27, 7));

        System.out.println(solution.numWays(430, 148488));

        System.out.println(solution.numWays(438, 315977));

        System.out.println(solution.numWays(434, 291270));

        System.out.println(solution.numWays(500, 969997));
    }
}