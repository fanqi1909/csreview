package org.jace.cs.review.lc.sorting.p15;

public class Tester {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
//
        System.out.println(solution.threeSum(new int[]{}));
//
        System.out.println(solution.threeSum(new int[]{0,0}));

        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 0}));


    }
}
