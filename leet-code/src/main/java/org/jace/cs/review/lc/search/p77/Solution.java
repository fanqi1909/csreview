package org.jace.cs.review.lc.search.p77;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        if(k > n) return Collections.emptyList();
        List<List<Integer>> result = new LinkedList<>();
        dfs(1, n, k, new ArrayList<>(), result);
        return result;
    }

    public void dfs(int current, int n, int k, List<Integer> comb, List<List<Integer>> result) {
        if(k == 0) {
            result.add(new ArrayList<>(comb));
        } else if(current <= n) {
            comb.add(current);
            dfs(current + 1, n, k - 1, comb, result);
            comb.remove(comb.size() - 1);
            dfs(current + 1, n, k, comb, result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.combine(5, 1).forEach(System.out::println);
        System.out.println("------");
        solution.combine(5, 2).forEach(System.out::println);
        System.out.println("------");
        solution.combine(5, 3).forEach(System.out::println);
        System.out.println("------");
        solution.combine(5, 4).forEach(System.out::println);
        System.out.println("------");
        solution.combine(5, 5).forEach(System.out::println);
        System.out.println("------");
        solution.combine(5, 0).forEach(System.out::println);
    }
}
