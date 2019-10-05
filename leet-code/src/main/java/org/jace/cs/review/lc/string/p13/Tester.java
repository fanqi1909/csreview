package org.jace.cs.review.lc.string.p13;

public class Tester {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.romanToInt("III") + " == " + 3);
        System.out.println(solution.romanToInt("IV") + " == " + 4);
        System.out.println(solution.romanToInt("IX") + " == " + 9);
        System.out.println(solution.romanToInt("LVIII") + " == " + 58);
        System.out.println(solution.romanToInt("MCMXCIV") + " == " + 1994);

    }
}
