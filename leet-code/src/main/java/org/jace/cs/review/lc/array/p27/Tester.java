package org.jace.cs.review.lc.array.p27;

public class Tester {

    private static void test(int[] array, int val, Solution solution) {
        int pos = solution.removeElement(array, val);
        for(int i = 0; i < pos; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        test(new int[]{3,2,2,3}, 3, solution);
        test(new int[]{0,1,2,2,3,0,4,2}, 2, solution);
        test(new int[]{}, 1, solution);
        test(new int[]{1}, 1, solution);
        test(new int[]{1,1,1,1,1}, 1, solution);
        test(new int[]{1,1,1,1,2,1}, 1, solution);
    }
}
