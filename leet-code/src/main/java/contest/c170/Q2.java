package contest.c170;

import org.jace.cs.review.lc.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q2 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i - 1];
        }
//        System.out.println(Arrays.toString(prefix));

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = prefix[queries[i][0]] ^ prefix[queries[i][1] + 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        Q2 sol = new Q2();
        System.out.println(Arrays.toString(sol.xorQueries(new int[]{1, 3, 4, 8},
                new int[][]{new int[]{0, 1},
                        new int[]{1, 2},
                        new int[]{0, 3},
                        new int[]{3, 3}})));

        System.out.println(Arrays.toString(sol.xorQueries(new int[]{4, 8, 2, 10},
                new int[][]{new int[]{2, 3},
                        new int[]{1, 3},
                        new int[]{0, 0},
                        new int[]{0, 3}})));
    }
}
