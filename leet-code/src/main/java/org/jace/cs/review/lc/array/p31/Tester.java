package org.jace.cs.review.lc.array.p31;

public class Tester {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.nextPermutation(new int[]{1,2,3});
        solution.nextPermutation(new int[]{3,2,1});
        solution.nextPermutation(new int[]{1,1,5});
        solution.nextPermutation(new int[]{1,3,2});
        solution.nextPermutation(new int[]{1,5,1});
    }
}
