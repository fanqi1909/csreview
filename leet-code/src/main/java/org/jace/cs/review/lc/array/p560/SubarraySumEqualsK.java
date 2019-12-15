package org.jace.cs.review.lc.array.p560;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        if(nums.length < 1) return 0;
       int[] prefixes = new int[nums.length + 1];
       prefixes[0] = 0;
       for(int i = 0; i < nums.length; i++) {
           prefixes[i + 1] += prefixes[i] + nums[i];
       }
       Map<Integer, Integer> previousNumber = new HashMap<>();
       int count = 0;
       for(int i = 0; i < prefixes.length; i++) {
           int target = prefixes[i] - k;
           if(previousNumber.containsKey(target)) {
              count += previousNumber.get(target);
           }
           previousNumber.put(prefixes[i], previousNumber.getOrDefault(prefixes[i], 0) + 1);
       }
       return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK ssk = new SubarraySumEqualsK();
        System.out.println(ssk.subarraySum(new int[]{1,1,1}, 2));

        System.out.println(ssk.subarraySum(new int[]{1,2,3,-3,-2,-1}, 0));
    }
}
