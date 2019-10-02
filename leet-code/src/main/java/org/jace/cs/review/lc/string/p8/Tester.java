package org.jace.cs.review.lc.string.p8;

public class Tester {

    public static void main(String [] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("no numbers inside"));
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("    -42"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-9128372332"));
        System.out.println(solution.myAtoi("+1"));
        System.out.println(solution.myAtoi("2000000000000000000000000"));
        System.out.println(solution.myAtoi("  0000000000012345678"));
    }
}
