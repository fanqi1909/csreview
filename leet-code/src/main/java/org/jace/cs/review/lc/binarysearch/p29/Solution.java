package org.jace.cs.review.lc.binarysearch.p29;

public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        int sign1 = divisor > 0 ? 1 : -1;
        int sign2 = dividend > 0 ? 1 : -1;
        int sign = sign1 * sign2 > 0 ? 1 : -1;

        long div = Math.abs((long) divisor);
        long did =  Math.abs((long) dividend);
        if(div == 1) {
            return (int) (did * sign2 * sign1);
        }


        long lower = 0;
        long upper = Integer.MAX_VALUE;

        while(upper > lower) {
            long mid = (lower + upper) / 2;

            long result = div * mid;
            if(result == did) {
                if(mid * sign > Integer.MAX_VALUE || mid * sign < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                return (int) mid * sign;
            } else if(result > did) {
                upper = mid - 1;
            } else {
                lower = mid + 1;
            }
        }
        if(lower * sign > Integer.MAX_VALUE || lower * sign < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (lower * div > did) {
            return ((int) lower -1) * sign;
        } else {
            return (int) lower * sign;
        }
    }
}