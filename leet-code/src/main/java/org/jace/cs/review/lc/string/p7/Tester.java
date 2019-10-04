package org.jace.cs.review.lc.string.p7;

public class Tester {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123) + "==" + 321);
        System.out.println(solution.reverse(-123) + "==" + -321);
        System.out.println(solution.reverse(120) + "==" + 21);
        System.out.println(solution.reverse(0) + "==" + 0);
        System.out.println(solution.reverse(-2147483648) + "==" + 0);
    }
}
