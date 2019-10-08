package org.jace.cs.review.lc.array.p26;

public class Tester {

    private static void test(int[] array, Solution solution) {
        int pos = solution.removeDuplicates(array);
        for(int i = 0; i < pos; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        test(new int[]{1,1,2}, solution);
        test(new int[]{0,0,1,1,1,2,2,3,3,4}, solution);
        test(new int[]{}, solution);
    }
}
