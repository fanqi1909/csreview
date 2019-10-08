package org.jace.cs.review.lc.binarysearch.p29;

public class Tester {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(10, 3) + " === " + 10/3);
        System.out.println(solution.divide(7, -3) + " === " + (-2));
        System.out.println(solution.divide(-10, -3) + " === " + (10/3));
        System.out.println(solution.divide(-10, 3) + " === " + (-10/3));
        System.out.println(solution.divide(Integer.MIN_VALUE, -1) + " === " + 2147483647);
        System.out.println(solution.divide(Integer.MAX_VALUE, -1) + " === " + (-2147483647));
        System.out.println(solution.divide(Integer.MIN_VALUE, 2) + " === " + (-1073741824));
    }
}
