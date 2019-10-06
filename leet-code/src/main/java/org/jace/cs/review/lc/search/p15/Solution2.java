package org.jace.cs.review.lc.search.p15;


import java.util.*;

public class Solution2 {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> out = new ArrayList();

        if(num.length < 3) {
            return out;
        }

        Arrays.sort(num); // so the cache is stored incrementally

        // store intergers here to fast access
        Set<Integer> cache = new HashSet();

        // store resut here to check duplicates
        Set<List<Integer>> cacheTriplets = new HashSet();

        for(int i = 0; i < num.length; i++) {
            for(int j = i + 1; j < num.length; j++) {

                int v1 = num[i];
                int v2 = num[j];
                int sum = v1 + v2;

                // if there is a number that we can add and get summ equal zero
                if(cache.contains(-sum)) {

                    // create result triplet
                    List<Integer> triplet = new ArrayList();
                    triplet.add(v1);
                    triplet.add(v2);
                    triplet.add(-sum);

                    // check duplicates
                    if(!cacheTriplets.contains(triplet)) {
                        out.add(triplet);
                        cacheTriplets.add(triplet);
                    }
                }
            }
            cache.add(num[i]);
        }
        return out;
    }
}