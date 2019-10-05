package org.jace.cs.review.lc.sorting.p15;


import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new LinkedList<>();
        if(nums.length < 3) {
            return  results;
        }
        Set<String> recorded = new HashSet<>();
        Set<Integer> examined = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(examined.contains(nums[i])) {
                continue;
            }
            List<List<Integer>> candidates = twoSum(nums, -nums[i], i);
            candidates.forEach(
                    candidate -> {
                        String signature =  candidate.stream().map(String::valueOf).collect(Collectors.joining(","));
                        if(!recorded.contains(signature)){
                            results.add(candidate);
                            recorded.add(signature);
                        }
                    }
            );
            examined.add(nums[i]);
        }
        return results;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int pos) {
        int start = 0; int end = nums.length-1;
        List<List<Integer>> results = new LinkedList<>();
        while(start < end) {
            //skip
            if(start == pos) {
                start++;
            }
            if(end == pos) {
                end--;
            }
            if(start == end) {
                break;
            }
            int sum = nums[start] + nums[end];
            if(sum == target) {
                //found;
                List<Integer> tuple = new ArrayList<>();

                if(pos < start) {
                    tuple.add(nums[pos]);
                    tuple.add(nums[start]);
                    tuple.add(nums[end]);
                } else if (pos < end) {
                    tuple.add(nums[start]);
                    tuple.add(nums[pos]);
                    tuple.add(nums[end]);
                } else {
                    tuple.add(nums[start]);
                    tuple.add(nums[end]);
                    tuple.add(nums[pos]);
                }

//                System.out.println(start + "\t" + end + "\t" + pos);
                results.add(tuple);
                start++;
                end--;
            } else if( sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return results;
    }
}