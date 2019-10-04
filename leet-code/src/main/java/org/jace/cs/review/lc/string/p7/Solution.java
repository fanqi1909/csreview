package org.jace.cs.review.lc.string.p7;

public class Solution {

    public int reverse(int x) {
        int sign = (x > 0) ? 1 : -1;
        long tmp = (long) x * sign;
        long reversed = 0;
        while (tmp != 0) {
            reversed += tmp % 10;
            tmp = tmp / 10;
            reversed = reversed * 10;
        }
        reversed = reversed/10;
        if (reversed > Integer.MAX_VALUE) {
            return 0;
        } else {
            return sign * (int) reversed;
        }
    }
}