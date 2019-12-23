package org.jace.cs.review.lc.search.p128;


import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> footprints = new HashSet<>();
        for(int num : nums) {
            footprints.add(num);
        }

        int max = 0;
        for(int num : nums) {
            int current = 0;
            int ptr = num;
            //search for lower boundary
            while(footprints.contains(ptr)) {
                footprints.remove(ptr);
                current++;
                ptr--;
            }
            //search for higher boundary
            ptr = num+1;
            while(footprints.contains(ptr)) {
                footprints.remove(ptr);
                current++;
                ptr++;
            }
            max = Math.max(max, current);
        }

        return max;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lsc = new LongestConsecutiveSequence();
        System.out.println(lsc.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
