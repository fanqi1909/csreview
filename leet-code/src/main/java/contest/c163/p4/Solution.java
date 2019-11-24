package contest.c163.p4;

public class Solution {

    public int minPushBox(char[][] grid) {

        int[] t = new int[2];
        int[] s = new int[2];
        int[] b = new int[2];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 'T') {
                    t[0] = r;
                    t[1] = c;
                } else if (grid[r][c] == 'B') {
                    b[0] = r;
                    b[1] = c;
                } else {
                    s[0] = r;
                    s[0] = c;
                }
            }
        }

        int[][][][] map = new int[grid.length][grid[0].length][grid.length][grid[0].length];

        return search(grid, t, s, b, map);

    }

    private int search(char[][] grid, int[] t, int[] s, int[] b, int[][][][] map) {
//        if (map[s[0]][s[1]][b[0]][b[1]] > 0) {
//            return map[s[0]][s[1]][b[0]][b[1]];
//        } else if (valid(grid, t, s, b)) {
//            map[s[0]][s[1]][b[0]][b[1]] = 1;
//            return 1;
//        } else {
//            //box state;
//            int next = -1;
//            if(moveUp(grid, t, s, b)) {
//                next = search(grid, t, s, b, map);
////                moveDown(grid, t, s, b);
////            }

//        }
        return 0;
    }

    private boolean valid(char[][] grid, int[] t, int[] s, int[] b) {
        //same row
        if(t[0] == b[0] && b[0]==s[0]) {
            if(t[1] == b[1] + 1 && b[1]== s[1] + 1) {
                return true;
            }
            if(t[1] == b[1] - 1 && b[1] == s[1] -1) {
                return true;
            }
            return false;
        }
        //same col
        if(t[1] == b[1] && b[1] == s[1]) {
            if(t[0] == b[0] +1 && b[0] == s[0] +1) {
                return true;
            }
            if(t[0] == b[0] - 1&& b[0] == s[0] -1) {
                return true;
            }
            return false;
        }
        return false;
    }

    private void moveUp(char[][] grid, int[] t, int[] s, int[] b) {
        int nextRow = s[0] - 1;
        if(grid[nextRow][s[1]] == '#') {
            return;
        } else if(grid[nextRow][s[1]] == 'B') {
        }
    }

    public static void main(String[] args) {

    }
}
