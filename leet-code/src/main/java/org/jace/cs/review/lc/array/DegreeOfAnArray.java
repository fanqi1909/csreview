package org.jace.cs.review.lc.array;

import java.util.*;

/**
 * Find the occurances of each number, the left-most occurance and right-most occurance of those forms a candidate
 */
public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        int degree = 0;
        Map<Integer, List<Integer>> occurance = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> positions = occurance.computeIfAbsent(
                    nums[i], k -> new ArrayList<>());
            positions.add(i);
            degree = Math.max(degree, positions.size());
        }

        int minDistance = Integer.MAX_VALUE;

        for(List<Integer> position : occurance.values()) {
            if(position.size() == degree) {
                minDistance = Math.min(minDistance, position.get(degree - 1) - position.get(0) + 1);
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        DegreeOfAnArray daa = new DegreeOfAnArray();
        System.out.println(daa.findShortestSubArray(new int[]{1,2,2,3,1}));
    }
}
