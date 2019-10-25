package org.jace.cs.review.lc.string.p166;

public class Tester {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.printf("%d, %d, %s == %s\n", 1, 2, "0.5", solution.fractionToDecimal(1, 2));
        System.out.printf("%d, %d, %s == %s\n", 1, 2, "2", solution.fractionToDecimal(2, 1));
        System.out.printf("%d, %d, %s == %s\n", 2, 3, "0.(6)", solution.fractionToDecimal(2, 3));
        System.out.printf("%d, %d, %s == %s\n", 23, 7, "3.(285714)", solution.fractionToDecimal(23, 7));
        System.out.printf("%d, %d, %s == %s\n", 119, 19, "6.(263157894736842105)", solution.fractionToDecimal(119, 19));
        System.out.printf("%d, %d, %s == %s\n", 213, 90, "2.3(6)", solution.fractionToDecimal(213, 90));
        System.out.printf("%d, %d, %s == %s\n", -50, 8, "-6.25", solution.fractionToDecimal(-50, 8));
        System.out.printf("%d, %d, %s == %s\n", -2, 3, "-0.(6)", solution.fractionToDecimal(-2, 3));
        System.out.printf("%d, %d, %s == %s\n", -22, -2, "11", solution.fractionToDecimal(-22, -2));
        System.out.printf("%d, %d, %s == %s\n", 0, -5, "0", solution.fractionToDecimal(0, -5));
        System.out.printf("%d, %d, %s == %s\n", -1, -2147483648, "0.0000000004656612873077392578125", solution.fractionToDecimal(-1, -2147483648));
    }
}
