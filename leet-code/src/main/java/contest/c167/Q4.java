package contest.c167;

public class Q4 {

    public int shortestPath(int[][] grid, int k) {
        Integer[][][] lookup = new Integer[grid.length][grid[0].length][k + 1];
        for (int i = 0; i <= k; i++) {
            lookup[0][0][i] = 0;
        }
        if (grid[0][0] == 1) { // the source is obstacle
            lookup[0][0][0] = Integer.MAX_VALUE;
        }

        int ans = findShortest(grid.length - 1, grid[0].length - 1, grid, k, lookup);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int findShortest(int r, int c, int[][] grid, int k, Integer[][][] lookup) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || k < 0) return Integer.MAX_VALUE;

        if (lookup[r][c][k] != null) {
            return lookup[r][c][k];
        }

        if (grid[r][c] == 1) {
            lookup[r][c][k] = Integer.MAX_VALUE;
            int up = findShortest(r - 1, c, grid, k - 1, lookup);
            int down = findShortest(r + 1, c, grid, k - 1, lookup);
            int left = findShortest(r, c - 1, grid, k - 1, lookup);
            int right = findShortest(r, c + 1, grid, k - 1, lookup);
            lookup[r][c][k] = Math.min(up, Math.min(down, Math.min(left, right)));
            if (lookup[r][c][k] != Integer.MAX_VALUE) {
                lookup[r][c][k]++;
            }
            return lookup[r][c][k];
        } else {
            lookup[r][c][k] = Integer.MAX_VALUE;
            int up = findShortest(r - 1, c, grid, k, lookup);
            int down = findShortest(r + 1, c, grid, k, lookup);
            int left = findShortest(r, c - 1, grid, k, lookup);
            int right = findShortest(r, c + 1, grid, k, lookup);
            lookup[r][c][k] = Math.min(up, Math.min(down, Math.min(left, right)));
            if (lookup[r][c][k] != Integer.MAX_VALUE) {
                lookup[r][c][k]++;
            }
            return lookup[r][c][k];
        }
    }

    public static void main(String[] args) {
        Q4 solution = new Q4();
        int[][] map = new int[][]{
                new int[]{0,0,0},
                new int[]{1,1,0},
                new int[]{0,0,0},
                new int[]{0,1,1},
                new int[]{0,0,0},
        };
        System.out.println(solution.shortestPath(map, 1));
        System.out.println(solution.shortestPath(map, 0));

        map = new int[][]{
                new int[]{0,1,1},
                new int[]{1,1,1},
                new int[]{1,0,0},
        };
        System.out.println(solution.shortestPath(map, 1));
    }
}
