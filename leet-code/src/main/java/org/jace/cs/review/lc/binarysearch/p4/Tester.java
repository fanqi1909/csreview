package org.jace.cs.review.lc.binarysearch.p4;

public class Tester {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.findMedianSortedArrays(new int[]{1,3}, new int[]{2}) + "= 2.0");

        System.out.println(solution.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}) + " = 2.5");

        System.out.println(solution.findMedianSortedArrays(new int[]{0,0}, new int[]{0,0}) + " = 0.0");

        System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[]{0,0}) + " = 0.0");

        System.out.println(solution.findMedianSortedArrays(new int[]{1,2}, new int[]{-1,3}) + " = 1.5");

        System.out.println(solution.findMedianSortedArrays(new int[]{2,2,2}, new int[]{2,2,2,2}) + " = 2.0");

        System.out.println(solution.findMedianSortedArrays(new int[]{1}, new int[]{2,3,4}) + " = 2.5");
    }
}
