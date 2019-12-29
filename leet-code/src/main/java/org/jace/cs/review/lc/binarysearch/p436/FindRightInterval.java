package org.jace.cs.review.lc.binarysearch.p436;

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int[] ans = new int[intervals.length];

        int[][] left = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            left[i][0] = intervals[i][0];
            left[i][1] = i;
        }

        Arrays.sort(left, Comparator.comparingInt(a -> a[0]));

        for(int i = 0; i < intervals.length; i++) {
            int right = intervals[i][1];
            //find the index;
            ans[i] = index(left, right);
        }

        return ans;
    }

    private int index(int[][] data, int target) {
        int l = 0;
        int r = data.length;
        while(l < r) {
            int mid = (l + r) >>> 1;
            if(data[mid][0] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        if(l == data.length) {
            return -1;
        } else {
            return data[l][1];
        }
    }

    public static void main(String[] args) {
        FindRightInterval fri = new FindRightInterval();
        System.out.println(Arrays.toString(fri.findRightInterval(new int[][]{
                new int[]{1,2}
        })));

        System.out.println(Arrays.toString(fri.findRightInterval(new int[][]{
                new int[]{3,4},
                new int[]{2,3},
                new int[]{1,2}
        })));

        System.out.println(Arrays.toString(fri.findRightInterval(new int[][]{
                new int[]{1,4},
                new int[]{2,3},
                new int[]{3,4}
        })));
    }
}
