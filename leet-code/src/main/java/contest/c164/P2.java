package contest.c164;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P2 {

    public int countServers(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0 ;j < grid[i].length; j++) {
                rows[i] += grid[i][j];
            }
        }

        for(int j = 0; j < grid[0].length; j++) {
            for(int i = 0 ; i< grid.length;i++) {
                cols[j] += grid[i][j];
            }
        }

//        System.out.println(Arrays.toString(rows) + "\t" + Arrays.toString(cols));


        int unique = 0;
        int total = 0 ;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    total++;
                    if(rows[i] == 1 && cols[j] == 1) {
                        unique++;
                    }
                }
            }
        }
        return total - unique;
    }



    public static void main(String[] args) {
        P2 solution = new P2();

        System.out.println(solution.countServers(new int[][]{
                new int[]{1, 0},
                new int[]{0, 1}
        }));

       System.out.println(solution.countServers(new int[][]{
                new int[]{1, 1, 0, 0},
                new int[]{0, 0, 1, 0},
                new int[]{0, 0, 1, 0},
                new int[]{0, 0, 0, 1}
        }));

        System.out.println(solution.countServers(new int[][]{
                new int[]{1, 1, 0, 0},
                new int[]{0, 0, 0, 0},
                new int[]{0, 1, 1, 0},
                new int[]{0, 0, 0, 1}
        }));


        System.out.println(solution.countServers(new int[][]{
                new int[]{1, 1, 0, 0},
                new int[]{0, 0, 0, 0},
                new int[]{0, 1, 1, 0},
                new int[]{0, 0, 0, 1},
                new int[]{0, 0, 0, 1}
        }));

        System.out.println(solution.countServers(new int[][]{
                new int[]{1, 1, 0, 0, 0},
                new int[]{0, 0, 0, 0, 1},
                new int[]{0, 1, 1, 0, 0},
                new int[]{0, 0, 0, 1, 0}
        }));
    }
}
