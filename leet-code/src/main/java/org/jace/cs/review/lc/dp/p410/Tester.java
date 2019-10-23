package org.jace.cs.review.lc.dp.p410;

import java.util.Arrays;

public class Tester {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] test;

        test = new int[]{7, 2, 5, 10, 8};
        System.out.printf("array=[%s], m=[%d], %d === %d\n", Arrays.toString(test), 3, 14, solution.splitArray(test, 3));
        System.out.printf("array=[%s], m=[%d], %d === %d\n", Arrays.toString(test), 2, 18, solution.splitArray(test, 2));

        test = new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        System.out.printf("array=[%s], m=[%d], %d === %d\n", Arrays.toString(test), 20, 11, solution.splitArray(test, 20));
        System.out.printf("array=[%s], m=[%d], %d === %d\n", Arrays.toString(test), 15, 11, solution.splitArray(test, 15));
        System.out.printf("array=[%s], m=[%d], %d === %d\n", Arrays.toString(test), 25, 11, solution.splitArray(test, 25));

        test = new int[]{1, 2147483647};
        System.out.printf("array=[%s], m=[%d], %d === %d\n", Arrays.toString(test), 2, 2147483647, solution.splitArray(test, 2));
    }


}
