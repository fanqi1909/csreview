package org.jace.cs.review.lc.search.p18;

import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> out = new ArrayList<>();
        if(nums.length < 4) {
            return out;
        }
        Arrays.sort(nums); // so the cache is stored incrementally
//        System.out.println(Arrays.toString(nums));
        // store resut here to check duplicates
        Set<List<Integer>> cachedQuadruplets = new HashSet<>();

        for(int i = 0; i < nums.length - 3 ; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            for(int j = i + 1; j < nums.length - 2; j++) {
                int l = j + 1;
                int r = nums.length-1;
                int twoSum = nums[i] + nums[j];
                while(l < r) {

                    int fourSum = twoSum + nums[l] + nums[r];
//                    System.out.println(i+ "\t" + j+ "\t" + l + "\t" + r + "\t" + fourSum + "\t" + target);
                    if(fourSum == target) {
                        //found;
                        List<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(nums[i]);
                        quadruplet.add(nums[j]);
                        quadruplet.add(nums[l]);
                        quadruplet.add(nums[r]);
                        if(!cachedQuadruplets.contains(quadruplet)) {
                            out.add(quadruplet);
                            cachedQuadruplets.add(quadruplet);
                        }
                        l++;
                        r--;
                    } else if(fourSum < target){
                        l++;
                    } else {
                        r--;
                    }
                }

            }
        }
        return out;
    }
}
