package org.jace.cs.review.lc.interval.p85;

import java.util.*;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        Map<Interval, Integer> intervalMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            List<Interval> intervals = getInterval(matrix[i]);
            Map<Interval, Integer> newMap = new HashMap<>();
            for (Interval interval : intervals) {
                for (Interval mapped : intervalMap.keySet()) {
                    Interval intersected = interval.intersect(mapped);
                    if (intersected != null) {
                        int exist = -1;
                        if(newMap.containsKey(intersected)) {
                            exist = newMap.get(intersected);
                        }
                        newMap.put(intersected, Math.max(intervalMap.get(mapped) + 1, exist));
                    }
                }
                if (!newMap.containsKey(interval)) {
                    newMap.put(interval, 1);
                }
            }
            intervalMap = newMap;
            System.out.println(intervalMap);
            for(Interval interval : intervalMap.keySet()) {
                int area = interval.getLen() * intervalMap.get(interval);
                if(area > max) {
                    max = area;
                }
            }
        }
        return max;
    }


    class Interval {
        int l, r;

        public Interval(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public Interval intersect(Interval another) {
            int newL = Math.max(l, another.l);
            int newR = Math.min(r, another.r);
            if (newL <= newR) {
                return new Interval(newL, newR);
            } else {
                return null;
            }
        }

        public int getLen() {
            return r - l + 1;
        }

        @Override
        public boolean equals(Object another) {
            if (another instanceof Interval) {
                Interval anotherI = (Interval) another;
                return this.l == anotherI.l && this.r == anotherI.r;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return l * 37 + r;
        }

        @Override
        public String toString() {
            return String.format("[%d:%d]", l, r);
        }
    }

    private List<Interval> getInterval(char[] row) {
        List<Interval> intervals = new ArrayList<>();
        int j = 0;
        while (j < row.length) {
            while (j < row.length && row[j] != '1') {
                j++;
            }
            if (j < row.length) {
                int[] interval = new int[2];
                interval[0] = j;
                while (j < row.length && row[j] == '1') {
                    j++;
                }
                interval[1] = j - 1;
                intervals.add(new Interval(interval[0], interval[1]));
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] matrix = new char[][]{
                new char[]{'1', '0', '1', '0', '0'},
                new char[]{'1', '0', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'1', '0', '0', '1', '0'},
        };

        System.out.println(solution.maximalRectangle(matrix));


        matrix = new char[][]{
                new char[]{'1', '0', '1', '0', '0', '1'},
                new char[]{'1', '0', '1', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1', '0'},
                new char[]{'1', '0', '1', '1', '0', '1'},
                new char[]{'1', '0', '1', '1', '0', '1'},
                new char[]{'0', '1', '1', '1', '1', '1'},
                new char[]{'0', '1', '1', '1', '1', '1'},
        };

        System.out.println(solution.maximalRectangle(matrix));
    }
}
