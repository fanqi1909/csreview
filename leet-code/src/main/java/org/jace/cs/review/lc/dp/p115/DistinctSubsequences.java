package org.jace.cs.review.lc.dp.p115;

import org.jace.cs.review.lc.dp.Util;

import java.util.Arrays;

public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n == 0 && m == 0) return 1;
        if (n == 0 || m == 0) return 0;


        int[][] dp2 = new int[2][n];
        int index = 0;
//      original dp
//        int[][] dp = new int[m][n];
//        dp[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
//        for (int i = 1; i < n; i++) {
//            dp[0][i] = dp[0][i - 1] + (s.charAt(i) == t.charAt(0) ? 1 : 0);
//        }
//        for(int i = 1; i < m; i++) {
//            for(int j = i; j < n; j++) {
//                if(t.charAt(i) == s.charAt(j)) {
//                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
//                } else {
//                    dp[i][j] = dp[i][j-1];
//                }
//            }
//        }


        //rolling array
        dp2[index][0] =  s.charAt(0) == t.charAt(0) ? 1 : 0;
        for (int i = 1; i < n; i++) {
            dp2[index][i] = dp2[index][i - 1] + (s.charAt(i) == t.charAt(0) ? 1 : 0);
        }
        index = 1 - index;
        for(int i = 1; i < m; i++) {
//            Arrays.fill(dp2[index], 0); to reset the next row
            dp2[index][i-1] = 0;
            for(int j = i; j < n; j++) {
                if(t.charAt(i) == s.charAt(j)) {
                    dp2[index][j] = dp2[1-index][j-1] + dp2[index][j-1];
                } else {
                    dp2[index][j] = dp2[index][j-1];
                }
            }
            index = 1 - index;
        }
        return dp2[(m-1) % 2][n-1];
    }

    public static void main(String[] args) {
        DistinctSubsequences dis = new DistinctSubsequences();
        System.out.println(dis.numDistinct("rabbbit", "rabbit"));
        System.out.println(dis.numDistinct("babgbag", "bag"));
        System.out.println(dis.numDistinct("babgbag", ""));
    }
}
