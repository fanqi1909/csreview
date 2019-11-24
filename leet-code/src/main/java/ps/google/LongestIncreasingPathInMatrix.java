package ps.google;

/**
 *  Use DFS to traverse the matrix. Use Cache[i][j] to store the Longest Path that starting from matrix[i][j]. This
 *  is because once Matrix[i][j] is computed, its value would not be changed.
 */
public class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int[][] cache = new int[matrix.length][matrix[0].length];

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dfs(i, j, matrix, cache);
                max = Math.max(max, cache[i][j]);
            }
        }

        return max;
    }

    private int dfs(int i, int j, int[][] matrix, int[][] visited) {
        if (visited[i][j] != 0) {
            return visited[i][j];
        }
        visited[i][j] = 1; //minimum is 1
        if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            visited[i][j] = Math.max(visited[i][j], dfs(i - 1, j, matrix, visited) + 1);
        }
        if (i < matrix.length - 1 && matrix[i + 1][j] > matrix[i][j]) {
            visited[i][j] = Math.max(visited[i][j], dfs(i + 1, j, matrix, visited) + 1);
        }
        if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            visited[i][j] = Math.max(visited[i][j], dfs(i, j - 1, matrix, visited) + 1);
        }
        if (j < matrix[i].length - 1 && matrix[i][j + 1] > matrix[i][j]) {
            visited[i][j] = Math.max(visited[i][j], dfs(i, j + 1, matrix, visited) + 1);
        }
        return visited[i][j];
    }

    public static void main(String[] args) {
        LongestIncreasingPathInMatrix solution = new LongestIncreasingPathInMatrix();

        System.out.println(solution.longestIncreasingPath(new int[][]{
                new int[]{9, 9, 4},
                new int[]{6, 6, 8},
                new int[]{2, 1, 1}
        }));


        System.out.println(solution.longestIncreasingPath(new int[][]{
                new int[]{3, 4, 5},
                new int[]{3, 2, 6},
                new int[]{2, 2, 1}
        }));


        System.out.println(solution.longestIncreasingPath(new int[][]{
                new int[]{7, 7, 5},
                new int[]{2, 4, 6},
                new int[]{8, 2, 0}
        }));

        System.out.println(solution.longestIncreasingPath(new int[][]{
                new int[]{7, 8, 9},
                new int[]{9, 7, 6},
                new int[]{7, 2, 3}
        }));

        System.out.println(solution.longestIncreasingPath(new int[][]{
                new int[]{1, 2}
        }));

        System.out.println(solution.longestIncreasingPath(new int[][]{
                new int[]{0, 1, 5, 5}
        }));
        System.out.println(solution.longestIncreasingPath(new int[][]{
                new int[]{0},
                new int[]{1},
                new int[]{5},
                new int[]{5},
        }));

        System.out.println(solution.longestIncreasingPath(new int[][]{
                new int[]{1, 4, 7, 9},
                new int[]{0, 3, 8, 5},
                new int[]{3, 6, 0, 6},
                new int[]{1, 4, 5, 6},
        }));
    }
}
