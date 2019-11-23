package contest.c162.p1254;

public class Solution {

    public int closedIsland(int[][] grid) {
        if (grid.length <= 1) return 0;

        int count = 2;
        for(int i = 1; i < grid.length - 1; i++) {
            for(int j = 1; j < grid[i].length -1; j++) {
                if(grid[i][j] == 0) {
                   if(markNeighbor(i,j, grid, count)) {
                       count++;
                   }
                }
            }
        }

//        Util.print2DArray(grid);

        return count - 2;
    }

    public boolean markNeighbor(int row, int col, int[][] grid, int mark) {
        if (grid[row][col] == 1) {
            return true;
        } else if (row == 0 || col == 0 || row == grid.length - 1 || col == grid[row].length - 1) {
            return false;
        } else if (grid[row][col] == mark) {
            return true;
        }  else {
            grid[row][col] = mark;
            boolean markUp = markNeighbor(row - 1, col, grid, mark);
            boolean markLeft = markUp && markNeighbor(row, col - 1, grid, mark);
            boolean markRight = markLeft &&  markNeighbor(row, col + 1, grid, mark);
            boolean markDown = markRight && markNeighbor(row + 1, col, grid, mark);
            if(markDown) {
                return true;
            } else {
                grid[row][col] = -1;
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] test = new int[][]{
                 new int[]{0,0,1,0,0},
                new int[]{0,1,0,1,0},
                new int[] {0,1,1,1,0}
        };
        System.out.println(solution.closedIsland(test));

        test = new int[][]{
                new int[]{1,1,1,1,1,1,1,0},
                new int[]{1,0,0,0,0,1,1,0},
                new int[]{1,0,1,0,1,1,1,0},
                new int[]{1,0,0,0,0,1,0,1},
                new int[]{1,1,1,1,1,1,1,0}
        };
        System.out.println(solution.closedIsland(test));

        test = new int[][]{
                new int[]{0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                new int[]{1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                new int[]{1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                new int[]{0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
                new int[]{0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                new int[]{0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                new int[]{1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                new int[]{1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                new int[]{1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
                new int[]{1, 1, 1, 0, 1, 1, 0, 1, 1, 0}
        };
        System.out.println(solution.closedIsland(test));
    }
}
