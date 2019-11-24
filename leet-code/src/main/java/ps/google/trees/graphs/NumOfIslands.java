package ps.google.trees.graphs;

import org.jace.cs.review.lc.dp.Util;

public class NumOfIslands {

    public int numIslands(char[][] grid) {

        int current = 1;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    traverse(i, j, grid, ++current);
                }
            }
        }
      //  Util.print2DArray(grid);

        return current - 1;
    }

    private void traverse(int i, int j, char[][] grid, int number) {

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return;
        }

        if(grid[i][j] == '1') {
            grid[i][j] = (char) (number + '0');
            traverse(i + 1, j, grid, number);
            traverse(i - 1, j, grid, number);
            traverse(i, j + 1, grid, number);
            traverse(i, j - 1, grid, number);
        }
    }

    public static void main(String[] args) {
        NumOfIslands solution = new NumOfIslands();

        System.out.println(solution.numIslands(new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'},
        }));


        System.out.println(solution.numIslands(new char[][]{
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '1'},
        }));
    }
}
