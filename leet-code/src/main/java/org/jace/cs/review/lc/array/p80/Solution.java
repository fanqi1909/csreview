package org.jace.cs.review.lc.array.p80;

public class Solution {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;

        int count = 1;
        int p1 = 1;
        int p2 = 1;

        while (p2 < nums.length) {
            if (nums[p2] == nums[p2 - 1]) {
                count++;
                if (count <= 2) {
                    nums[p1++] = nums[p2++];
                } else {
                    p2++;
                }
            } else {
                count = 1;
                nums[p1++] = nums[p2++];
            }
        }
        return p1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = new int[]{1, 1, 1, 2, 2, 3};
        for (int i = 0, len = solution.removeDuplicates(test); i < len; i++) {
            System.out.print(test[i] + "\t");
        }
        System.out.println("\n-------------");

        test = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        for (int i = 0, len = solution.removeDuplicates(test); i < len; i++) {
            System.out.print(test[i] + "\t");
        }
        System.out.println();

        System.out.println("\n-------------");
        test = new int[]{0, 0,0,0};
        for (int i = 0, len = solution.removeDuplicates(test); i < len; i++) {
            System.out.print(test[i] + "\t");
        }
        System.out.println();

        System.out.println("\n-------------");
        test = new int[]{0};
        for (int i = 0, len = solution.removeDuplicates(test); i < len; i++) {
            System.out.print(test[i] + "\t");
        }
        System.out.println();

        System.out.println("\n-------------");
        test = new int[]{0,1,2,3,3,3,3,3,3,4,4,5};
        for (int i = 0, len = solution.removeDuplicates(test); i < len; i++) {
            System.out.print(test[i] + "\t");
        }
        System.out.println();
    }
}
