package org.jace.cs.review.lc.number.p264;

import java.util.*;

public class Solution {
    long[] uglyNumbers;

    public Solution() {
        uglyNumbers = getUglyNumbers2();
    }

    private long[] getUglyNumbers2() {
        uglyNumbers = new long[1690];

        uglyNumbers[0] = 1;

        int next2 = 0;
        int next3 = 0;
        int next5 = 0;

        for (int i = 1; i < uglyNumbers.length; i++) {
            long cand2 = uglyNumbers[next2] * 2;
            long cand5 = uglyNumbers[next5] * 5;
            long cand3 = uglyNumbers[next3] * 3;

            long min = min(cand2, cand3, cand5);

            if (min == cand2) next2++;
            if (min == cand5) next5++;
            if (min == cand3) next3++; //avoid duplicates

            uglyNumbers[i] = min;
        }
        return uglyNumbers;
    }

    private long min(long l, long l1, long l2) {
        return Math.min(Math.min(l, l1), l2);
    }

    //PQ based
    private long[] getUglyNumbers() {
        List<Long> uglies = new ArrayList<>();
        Set<Long> seen = new HashSet<>();

        uglies.add(1L);
        seen.add(1L);

        PriorityQueue<Long> pq = new PriorityQueue<>();

        pq.add(2L);
        pq.add(3L);
        pq.add(5L);

        int[] multiplier = new int[]{2, 3, 5};
        while (uglies.size() <= 1690) {
            long next = pq.poll();
            uglies.add(next);

            for (int i : multiplier) {
                long candidate = next * i;
                if (!seen.contains(candidate)) {
                    pq.add(candidate);
                    seen.add(candidate);
                }
            }
        }

        long[] result = new long[uglies.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = uglies.get(i);
        }
        return result;
    }

    public int nthUglyNumber(int n) {
        return (int) uglyNumbers[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(12 + "===" + solution.nthUglyNumber(10));
        System.out.println(80 + "===" + solution.nthUglyNumber(30));
        System.out.println(2123366400 + "===" + solution.nthUglyNumber(1690));
    }
}
