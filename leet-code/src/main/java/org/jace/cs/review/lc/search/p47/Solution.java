package org.jace.cs.review.lc.search.p47;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return permuteUnique(nums, 0);
    }

    public List<List<Integer>> permuteUnique(int[] nums, int position) {
        if(position == nums.length) {
            List<Integer> list = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            result.add(list);
            return result;
        } else {
            List<List<Integer>> prevPerms = permuteUnique(nums, position + 1);
            //add nums[i] into all prevPerms
            List<List<Integer>> result = new ArrayList<>();
            prevPerms.forEach(
                    perm -> {
                        List<Integer> newPerm = new ArrayList<>(perm);
                        newPerm.add(0, nums[position]);
                        result.add(newPerm);

                        for(int i = 1;  i < newPerm.size() /*&& nums[position] != newPerm.get(i)*/; i++) {
                            if(nums[position] != newPerm.get(i)) {
                                result.add(swap(0, i, newPerm));
                            } else {
                                break;
                            }
                        }
                    }
            );
            return result;
        }
    }

    private List<Integer> swap(int a, int b, List<Integer> newPerm) {
        List<Integer> result = new ArrayList<>(newPerm);
        int tmp = result.get(a);
        result.set(a, result.get(b));
        result.set(b, tmp);
        return result;
    }
}
