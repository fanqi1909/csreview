package org.jace.cs.review.lc.binarysearch.p327;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class CountOfRangeSum {

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length == 0) return 0;

        long[] prefixSum = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        TreeMap<Long, Integer> map = new TreeMap<>(); //occurrence of this value in the prefix map. This allows duplicate values to be handled.
        map.put(prefixSum[0], 1);

        int ans = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            long left = prefixSum[i] - upper;
            long right = prefixSum[i] - lower;
            Map<Long, Integer> m = map.subMap(left, true, right, true);
            for (int count : m.values()) {
                ans += count;
            }
            if (map.containsKey(prefixSum[i])) {
                map.put(prefixSum[i], map.get(prefixSum[i]) + 1);
            } else {
                map.put(prefixSum[i], 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountOfRangeSum cos = new CountOfRangeSum();
//
        System.out.println(cos.countRangeSum(new int[]{-2, 5, -1}, -2, 2));

        System.out.println(cos.countRangeSum(new int[]{0}, 0, 0));

        System.out.println(cos.countRangeSum(new int[]{0, 0}, 0, 0));

        System.out.println(cos.countRangeSum(new int[]{2147483647, -2147483648, -1, 0}, -1, 0));
    }
}
