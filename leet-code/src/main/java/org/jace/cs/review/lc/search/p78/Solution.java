package org.jace.cs.review.lc.search.p78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(0, nums, new ArrayList<>(), result);
        return  result;
    }

    private void dfs(int position, int[] nums, ArrayList<Integer> comb, List<List<Integer>> result) {
        if(position >= nums.length) {
            result.add(new ArrayList<>(comb));
        } else {
            dfs(position + 1, nums, comb, result);
            comb.add(nums[position]);
            dfs(position + 1, nums, comb, result);
            comb.remove(comb.size() - 1);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.subsets(new int[]{1, 2, 3}).forEach(System.out::println);
        System.out.println("-----------------");

        solution.subsets(new int[]{1, 2}).forEach(System.out::println);
        System.out.println("-----------------");

        solution.subsets(new int[]{}).forEach(System.out::println);
        System.out.println("-----------------");

        solution.subsets(new int[]{1, 2, 3, 4}).forEach(System.out::println);
        System.out.println("-----------------");
    }
}
