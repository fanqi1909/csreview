package org.jace.cs.review.lc.search.p90;

import java.util.*;

public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        //Set<List<Integer>> result  = new HashSet<>();
        List<List<Integer>> result = new LinkedList<>();

        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<>(), result, false);

        return result;
    }

    private void dfs2(int position, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = position; i < nums.length; i++) {
            if (i > position && nums[i] == nums[i - 1])
                continue;
            current.add(nums[i]);
            dfs2(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }

    private void dfs(int position, int[] nums, List<Integer> current, List<List<Integer>> result, boolean used) {
        if (position >= nums.length) {
            result.add(new ArrayList<>(current));
        } else {
            current.add(nums[position]);
            dfs(position + 1, nums,  current, result, true);
            current.remove(current.size() - 1);
            if(!(position > 0 && nums[position] == nums[position - 1] && used)) {
                //can avoid choosing nums[position] only when the
                //it is duplicated with nums[position -1], and the previous is not used.
                dfs(position + 1, nums, current, result, false);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("------");
        solution.subsetsWithDup(new int[]{1, 2, 3}).forEach(System.out::println);
        System.out.println("------");
        solution.subsetsWithDup(new int[]{1, 2, 2}).forEach(System.out::println);
        System.out.println("------");
        solution.subsetsWithDup(new int[]{4, 4, 4, 1, 5}).forEach(System.out::println);
    }
}
