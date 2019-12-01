package contest.c165;

public class Q3 {

    public int countSquares(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        int sum = 0;

        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = matrix[i][0];
            sum += dp[i][0];
        }

        for(int i = 0; i < dp[0].length; i++) {
            dp[0][i] = matrix[0][i];
            sum += dp[0][i];
        }
        sum -= dp[0][0];

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                }
                sum += dp[i][j];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Q3 q = new Q3();
        System.out.println(q.countSquares(new int[][]{
                new int[]{0,1,1,1},
                new int[]{1,1,1,1},
                new int[]{0,1,1,1}
        }));

        System.out.println(q.countSquares(new int[][]{
                new int[]{1,0,1},
                new int[]{1,1,0},
                new int[]{1,1,0}
        }));

    }
}
