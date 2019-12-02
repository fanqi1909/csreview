package ps.google.dp;

import org.jace.cs.review.lc.dp.Util;

import java.util.HashSet;
import java.util.Set;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        Set<Integer> coinTypes = new HashSet<>();
        for (int coin : coins) {
            coinTypes.add(coin);
        }
        int[] distinct = new int[coinTypes.size()];
        int next = 0;
        for (int coin : coinTypes) {
            distinct[next++] = coin;
        }

        int[][] dp = new int[distinct.length][amount + 1];

        for (int i = 0; i < distinct.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {

                int opt1 = -1;
                if (j >= distinct[i] && dp[i][j - distinct[i]] != -1) {
                    opt1 = 1 + dp[i][j - distinct[i]];
                }
                int opt2 = i > 0 ? dp[i - 1][j] : -1;

                if (opt1 == -1 && opt2 == -1) {
                    dp[i][j] = -1;
                } else if (opt1 == -1) {
                    dp[i][j] = opt2;
                } else if(opt2 == -1) {
                    dp[i][j] = opt1;
                } else {
                    dp[i][j] = Math.min(opt1, opt2);
                }
            }
        }
//        Util.print2DArray(dp);

        return dp[distinct.length - 1][amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();

        System.out.println(cc.coinChange(new int[]{1, 2, 5 , 2}, 11));
        System.out.println(cc.coinChange(new int[]{2}, 3));
        System.out.println(cc.coinChange(new int[]{1,3}, 3));
    }
}
