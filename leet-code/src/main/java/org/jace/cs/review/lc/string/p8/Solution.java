package org.jace.cs.review.lc.string.p8;

/**
 * question: https://leetcode.com/problems/string-to-integer-atoi/
 * algorithm: do trimming on the head and tail of the string to extract the number part. Filter values that greater than Long.Max to handle integer overflows.
 */
public class Solution {
    private final static char SPACE = ' ';

    public int myAtoi(String str) {
        int numberStart = 0;
        int sign = 1;

        while(numberStart < str.length() && str.charAt(numberStart) == SPACE) {
            numberStart++;
        }

        if(numberStart == str.length()) {
            return 0;
        }

        if(str.charAt(numberStart) == '-') {
            sign = -1;
            numberStart++;
        } else if(str.charAt(numberStart) == '+') {
            numberStart++;
        }

        while(numberStart < str.length() && str.charAt(numberStart) == '0') {
            numberStart++; // omit consecutive 0s
        }

        int numberEnd = numberStart;

        while(numberEnd < str.length() && str.charAt(numberEnd) >= '0' && str.charAt(numberEnd) <= '9') {
            numberEnd++;
        }

        if(numberEnd == numberStart) {
            return 0; // no digits
        }

        String number = str.substring(numberStart, numberEnd);

        if(number.length() > 11) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        long value = Long.parseLong(number);

        if(value > Integer.MAX_VALUE) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return (int) value * sign;
    }
}
