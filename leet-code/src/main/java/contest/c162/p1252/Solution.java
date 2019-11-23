package contest.c162.p1252;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] columns) {
        ArrayList<Integer> row1 = new ArrayList<>(columns.length);
        ArrayList<Integer> row2 = new ArrayList<>(columns.length);
        List<List<Integer>> result = new LinkedList<>();
        if (dfs(upper, lower, 0, columns, row1, row2)) {
            result.add(row1);
            result.add(row2);
        }
        return result;
    }


    public boolean dfs(int upper, int lower, int index, int[] columns, ArrayList<Integer> row1, ArrayList<Integer> row2) {
        if (upper < 0 || lower < 0) {
            return false;
        }
        if (index == columns.length) {
            return upper == 0 && lower == 0;
        } else {
            //fill column index;
            if (columns[index] == 2) {
                row1.add(1);
                row2.add(1);
                boolean valid =  dfs(upper - 1, lower - 1, index + 1, columns, row1, row2);
                if(!valid) {
                    row1.remove(row1.size() - 1);
                    row2.remove(row2.size() - 1);
                    return false;
                }
                return true;
            } else if (columns[index] == 0) {
                row1.add(0);
                row2.add(0);
                boolean valid =  dfs(upper, lower, index + 1, columns, row1, row2);
                if(!valid) {
                    row1.remove(row1.size() - 1);
                    row2.remove(row2.size() - 1);
                    return false;
                }
                return true;
            } else {
                //try 0 then 1
                row1.add(0);
                row2.add(1);
                boolean valid = dfs(upper, lower - 1, index + 1, columns, row1, row2);
                if (!valid) {
                    //try 1
                    row1.remove(row1.size() - 1);
                    row2.remove(row2.size() - 1);
                    row1.add(1);
                    row2.add(0);
//                    row1.set(index, 1);
//                    row2.set(index, 0);
                    valid = dfs(upper - 1, lower, index + 1, columns, row1, row2);
                    if (!valid) {
                        row1.remove(row1.size() - 1);
                        row2.remove(row2.size() - 1);
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] test = new int[]{1, 1, 1};

        solution.reconstructMatrix(2, 1, test).forEach(System.out::println);

        test = new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1};
        solution.reconstructMatrix(5, 5, test).forEach(System.out::println);

        test = new int[]{2, 1, 2, 0, 2, 0, 1, 2, 0, 1};
        System.out.println(solution.reconstructMatrix(10, 5, test));
    }
}
