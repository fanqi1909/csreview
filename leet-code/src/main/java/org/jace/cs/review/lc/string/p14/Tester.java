package org.jace.cs.review.lc.string.p14;

public class Tester {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.longestCommonPrefix(new String[]{
                "flower", "flow", "flight"
        }) + " == fl");

        System.out.println(solution.longestCommonPrefix(new String[]{
                "dog", "racecar", "car"
        }) + " == ");
    }
}
