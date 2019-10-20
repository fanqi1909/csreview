package org.jace.cs.review.lc.array.p41;

import java.util.Arrays;

public class Tester {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] testArray;
//
        testArray = new int[]{1,2,0};
        System.out.printf("%s, 3 === %d\n", Arrays.toString(testArray), solution.firstMissingPositive(testArray));

        testArray = new int[]{-1,-2,-3, 0};
        System.out.printf("%s, 1 === %d\n", Arrays.toString(testArray), solution.firstMissingPositive(testArray));

        testArray = new int[]{1,-2,-3, 0};
        System.out.printf("%s, 2 === %d\n", Arrays.toString(testArray), solution.firstMissingPositive(testArray));

        testArray = new int[]{3, 4, -1, 1};
        System.out.printf("%s, 2 === %d\n", Arrays.toString(testArray), solution.firstMissingPositive(testArray));

        testArray = new int[]{7, 8, 9, 11, 12};
        System.out.printf("%s, 1 === %d\n", Arrays.toString(testArray), solution.firstMissingPositive(testArray));

        testArray = new int[]{-1, 2, -3, 1, -4, -5, 3, 4, 5, 7, 8, -10, -11};
        System.out.printf("%s, 6 === %d\n", Arrays.toString(testArray), solution.firstMissingPositive(testArray));

        testArray = new int[]{2, 1};
        System.out.printf("%s, 3 === %d\n", Arrays.toString(testArray), solution.firstMissingPositive(testArray));

        testArray = new int[]{0, 2, 2, 1, 1};
        System.out.printf("%s, 3 === %d\n", Arrays.toString(testArray), solution.firstMissingPositive(testArray));

        testArray = new int[]{4, 1, 2, 3};
        System.out.printf("%s, 5 === %d\n", Arrays.toString(testArray), solution.firstMissingPositive(testArray));

        testArray = new int[]{2, 2};
        System.out.printf("%s, 1 === %d\n", Arrays.toString(testArray), solution.firstMissingPositive(testArray));
    }
}
