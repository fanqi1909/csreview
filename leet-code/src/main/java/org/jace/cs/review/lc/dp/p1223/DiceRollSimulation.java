package org.jace.cs.review.lc.dp.p1223;

/**
 * A naive DP solution
 * <p>
 * dp[i][j][k] means rolls i times, ending with consecutive k js
 * dp[10][3][4] means the number of 10-rolls ending with 3333
 * <p>
 * so k <= rollMax(i)
 * <p>
 * base case:
 * dp[1][*][1] = 1
 * <p>
 * transition 1:
 * dp[i][j][1] = sum(dp[i - 1][p][*]) (j != p) means the previous i rolls should not end with j
 * <p>
 * transition 2:
 * dp[i][j][k] = dp[i-1][j][k-1] ( k < rollmax[j])
 *
 *
 * A state-compression dp can run in O(n) time.
 */
public class DiceRollSimulation {
    int mod = (int) (1e9 + 7);

    public int dieSimulator(int n, int[] rollMax) {
        int[][][] dp = new int[n + 1][6][16];
        for (int i = 0; i < 6; i++) {
            dp[1][i][1] = 1; //run starts with 1, k starts with 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                //transition 1
                for (int p = 0; p < 6; p++) {
                    for (int k = 1; k <= rollMax[p]; k++) {
                        if (j != p) {
                            dp[i][j][1] = (dp[i][j][1] + dp[i - 1][p][k]);
                            if (dp[i][j][1] > mod) {
                                dp[i][j][1] -= mod;
                            }
                        }
                    }
                }
                for (int k = 1; k < rollMax[j]; k++) {
                    dp[i][j][k + 1] = dp[i - 1][j][k];
                }
            }
        }

        int totalSum = 0;

        for (int i = 0; i < 6; i++) {
            for (int k = 1; k <= rollMax[i]; k++) {
                totalSum = (totalSum + dp[n][i][k]);
                if (totalSum > mod) {
                    totalSum -= mod;
                }
            }
        }
        return totalSum;
    }


    public static void main(String[] args) {
        DiceRollSimulation drs = new DiceRollSimulation();
        System.out.println(drs.dieSimulator(2, new int[]{1, 1, 2, 2, 2, 3}));
        System.out.println(drs.dieSimulator(2, new int[]{1, 1, 1, 1, 1, 1}));
        System.out.println(drs.dieSimulator(4, new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(drs.dieSimulator(20, new int[]{8, 5, 10, 8, 7, 2}));
    }
}
