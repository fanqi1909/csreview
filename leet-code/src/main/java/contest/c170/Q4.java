package contest.c170;

import java.util.HashSet;
import java.util.Set;

public class Q4 {

    public int minInsertions(String s) {
        int len = s.length();
        Integer[][] dp = new Integer[len][len];

        return pal(0, len - 1, s.toCharArray(), dp);
    }

    private int pal(int i, int j, char[] s, Integer[][] dp) {
        if(dp[i][j] != null) {
            return dp[i][j];
        }

        if(i >= j) {
            dp[i][j] = 0;
            return dp[i][j];
        }

        int opt = Integer.MAX_VALUE;
        if(s[i] == s[j]) {
            opt = Math.min(opt, pal(i+1, j-1, s, dp));
        } else {
            opt = Math.min(pal(i+1, j, s, dp), pal(i, j-1, s, dp)) + 1;
        }
        dp[i][j] = opt;
        return dp[i][j];
    }

    public static void main(String[] args) {
        Q4 sol = new Q4();
        System.out.println(sol.minInsertions("zzazz"));

        System.out.println(sol.minInsertions("mbadm"));

        System.out.println(sol.minInsertions("leetcode"));

        System.out.println(sol.minInsertions("g"));

        System.out.println(sol.minInsertions("no"));
    }
}
