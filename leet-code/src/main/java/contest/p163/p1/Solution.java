package contest.p163.p1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<Integer> fullList = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                fullList.add(grid[i][j]);
            }
        }
        if (fullList.isEmpty()) {
            return Collections.emptyList();
        }
        shift(fullList, k);
        return split(fullList, grid[0].length);
    }

    private List<List<Integer>> split(List<Integer> fullList, int length) {
        List<List<Integer>> result = new LinkedList<>();
        while (!fullList.isEmpty()) {
            List<Integer> current = new LinkedList<>();
            while (current.size() < length) {
                current.add(fullList.remove(0));
            }
            result.add(current);
        }
        return result;
    }

    private void shift(List<Integer> fullList, int k) {
        int size = fullList.size();
        while (k > 0 && k % size != 0) {
            fullList.add(0,fullList.remove(size - 1));
            k--;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shiftGrid(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        }, 1));

        System.out.println(solution.shiftGrid(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        }, 2));

        System.out.println(solution.shiftGrid(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        }, 3));

        System.out.println(solution.shiftGrid(new int[][]{
        }, 1));
    }
}
