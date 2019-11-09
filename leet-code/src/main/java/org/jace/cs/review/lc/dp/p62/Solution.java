package org.jace.cs.review.lc.dp.p62;

public class Solution {

    public int uniquePaths(int m, int n) {
        return combination(m - 1 + n - 1, Math.min(m - 1, n - 1), new Integer[m - 1 + n][Math.min(m - 1, n - 1) + 1]);
    }

    private int combination(int a, int b, Integer[][] map) {
        if (b == 0 || a == b) {
            map[a][b] = 1;
        } else if (b == 1) {
            map[a][b] = a;
        } else if (map[a][b] == null) {
            int comb = combination(a - 1, b - 1, map) + combination(a - 1, b, map);
            map[a][b] = comb;
        }
        return map[a][b];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(3 + "====>" + (3 == solution.uniquePaths(3, 2)));
        System.out.println(28 + "====>" + (28 == solution.uniquePaths(7, 3)));
    }
}
