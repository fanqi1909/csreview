package org.jace.cs.review.lc.array.p42;

import java.util.Arrays;
import java.util.Random;

public class Tester {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.printf("%s: 6 === %d\n", Arrays.toString(test), solution.trap(test));

        test = new int[]{};
        System.out.printf("%s: 0 === %d\n", Arrays.toString(test), solution.trap(test));


        Random random = new Random();
        test = new int[]{19, 1, 12, 14, 6, 10, 12, 19, 8, 16, 10, 18, 7, 5, 5, 0, 15, 10, 5, 3};
        System.out.printf("%s: 122 === %d\n", Arrays.toString(test), solution.trap(test));


        test = new int[]{34, 49, 30, 27, 48, 42, 36, 6, 25, 31, 17, 42, 6, 22, 25, 2, 23, 40, 30, 28, 47, 10, 23, 38, 34, 48, 1, 37, 44, 3, 49, 8, 14, 29, 26, 30, 19, 39, 25, 21, 36, 3, 31, 17, 2, 22, 16, 36, 8, 10};
        System.out.printf("%s: 868 === %d\n", Arrays.toString(test), solution.trap(test));

        test = new int[]{0};
        System.out.printf("%s: 0 === %d\n", Arrays.toString(test), solution.trap(test));
    }
}