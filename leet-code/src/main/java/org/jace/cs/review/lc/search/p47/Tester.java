package org.jace.cs.review.lc.search.p47;

import java.util.Arrays;

public class Tester {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] test;

        test = new int[]{1,2,3};
        System.out.println(Arrays.toString(test) + "\n---------");
        solution.permuteUnique(test).forEach(System.out::println);
        System.out.println("*********\n");

        test = new int[]{1,1,2};
        System.out.println(Arrays.toString(test) + "\n---------");
        solution.permuteUnique(test).forEach(System.out::println);
        System.out.println("*********\n");

        test = new int[]{1,1,2,3};
        System.out.println(Arrays.toString(test) + "\n---------");
        solution.permuteUnique(test).forEach(System.out::println);
        System.out.println("*********\n");

        test = new int[]{1,1,2,3,3};
        System.out.println(Arrays.toString(test) + "\n---------");
        solution.permuteUnique(test).forEach(System.out::println);
        System.out.println("*********\n");
    }
}
