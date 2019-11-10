package org.jace.cs.review.lc.number.p66;

import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        boolean allNine = true;
        for(int digit: digits) {
            if(digit != 9) {
                allNine = false;
                break;
            }
        }

        if(allNine) {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        } else {
            int[] result = new int[digits.length];
            int carry = 1;
            for(int i = digits.length - 1; i >=0; i--) {
                result[i] = digits[i] + carry;
                carry = result[i] / 10;
                result[i] = result[i] % 10;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] test;
        test = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(solution.plusOne(test)));

        test = new int[]{4, 3, 2, 1};
        System.out.println(Arrays.toString(solution.plusOne(test)));

        test = new int[]{9,9,9,9};
        System.out.println(Arrays.toString(solution.plusOne(test)));

        test = new int[]{3,9,9,9};
        System.out.println(Arrays.toString(solution.plusOne(test)));
    }
}
