package org.jace.cs.review.lc.string.p12;

public class Tester {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.intToRoman(3) + "== III");
        System.out.println(solution.intToRoman(4) + "== IV");
        System.out.println(solution.intToRoman(9) + "== IX");
        System.out.println(solution.intToRoman(58) + "== LVIII");
        System.out.println(solution.intToRoman(1994) + "== MCMXCIV");
        System.out.println(solution.intToRoman(3751) + "== MMMDCCLI");

    }
}
