package org.jace.cs.review.lc.binarysearch.p35;

public class Tester {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("[1,3,5,6], 5 , 2 ===  " + solution.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println("[1,3,5,6], 2 , 1 ===  " + solution.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println("[1,3,5,6], 7 , 4 ===  " + solution.searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println("[1,3,5,6], 0 , 0 ===  " + solution.searchInsert(new int[]{1,3,5,6}, 0));
    }
}
