package org.jace.cs.review.lc.number.p670;

import java.util.*;

public class MaximumSwap {

    // for each digit, we need to find the last digit that is greater than that digit
    // since there are only 10 options for each digit, we can just enumerate.
    // Otherwise, using a tree-set would be a more generic solution
    public int maximumSwap(int num) {
        if (num < 10) return num;

        char[] digits = (num + "").toCharArray();
        int[] last = new int[10];

        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i; // only record the last occurance;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = tmp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        MaximumSwap msp = new MaximumSwap();
        System.out.println(msp.maximumSwap(2736));

        System.out.println(msp.maximumSwap(9973));

        System.out.println(msp.maximumSwap(9992349));
    }
}
