package org.jace.cs.review.lc.string.p43;

import java.math.BigInteger;

public class Solution {
    public String multiply(String num1, String num2) {

        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 1) {
            return singleMultiply(num2, num1.charAt(0) - '0');
        } else if (len2 == 1) {
            return singleMultiply(num1, num2.charAt(0) - '0');
        }

        //split num1 and num2;
        int mid1 = len1 / 2;
        int mid2 = len2 / 2;

        String A1 = num1.substring(0, mid1);
        String A2 = num1.substring(mid1);

        String B1 = num2.substring(0, mid2);
        String B2 = num2.substring(mid2);


        String part1 = multiply(A1, B1) + zeros(A2.length() + B2.length());
        String part2 = multiply(A1, B2) + zeros(A2.length());
        String part3 = multiply(A2, B1) + zeros(B2.length());
        String part4 = multiply(A2, B2);

        String result = sumString(part1, part2, part3, part4);
//        System.out.println(num1 + " * " + num2 + " = " + result);
        return result;
    }

    private String sumString(String part1, String part2, String part3, String part4) {
        StringBuilder finalResult = new StringBuilder();
        int len = max(part1.length(), part2.length(), part3.length(), part4.length());
        part1 = prepad(part1, len);
        part2 = prepad(part2, len);
        part3 = prepad(part3, len);
        part4 = prepad(part4, len);

        int carry = 0;
        for (int i = len; i >= 0; i--) {
            int temp = (part1.charAt(i) - '0') + (part2.charAt(i) - '0') + (part3.charAt(i) - '0') + (part4.charAt(i) - '0') + carry;
            if (temp >= 10) {
                carry = temp / 10;
                temp = temp % 10;
            } else {
                carry = 0;
            }
            finalResult.append(temp);
        }
        if (carry > 0) {
            finalResult.append(carry);
        }

        while (finalResult.length() > 1 && finalResult.charAt(finalResult.length() - 1) == '0') {
            finalResult.deleteCharAt(finalResult.length() - 1);
        }

        return finalResult.reverse().toString();
    }


    private String prepad(String part, int num) {
        StringBuilder pad = new StringBuilder(part);
        while (pad.length() <= num) {
            pad.insert(0, "0");
        }
        return pad.toString();
    }

    private int max(int... a) {
        int m = a[0];
        for (int num : a) {
            if (m < num) {
                m = num;
            }
        }
        return m;
    }

    private String zeros(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            stringBuilder.append("0");
            num--;
        }
        return stringBuilder.toString();
    }

    private String singleMultiply(String num2, int mult) {
        //int[] result = new int[num2.length() + 1]; //for overflow
        StringBuilder finalResult = new StringBuilder();
        int carry = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int result = mult * (num2.charAt(i) - '0') + carry;
            if (result >= 10) {
                carry = result / 10;
                result = result % 10;
            } else {
                carry = 0;
            }
            finalResult.append(result);
//            finalResult.insert(0, result);
        }
        if (carry > 0) {
//            finalResult.insert(0, carry);
            finalResult.append(carry);
        }

        while (finalResult.length() > 1 && finalResult.charAt(finalResult.length() - 1) == '0') {
            finalResult.deleteCharAt(finalResult.length() - 1);
        }
        return finalResult.reverse().toString();

//        System.out.println(num2 + " * " + mult + " = " + finalResult);
//        return finalResult.length() == 0 ? "0" : finalResult.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] num1s = new String[]{
                "0",
                "1468273",
                "212335",
                "1231385919283",
                "123138"
        };

        String[] num2s = new String[]{
                "378",
                "78",
                "31231241251251",
                "376178962123"
        };
        for (String num1 : num1s) {
            for (String num2 : num2s) {
                BigInteger b1 = new BigInteger(num1);
                BigInteger b2 = new BigInteger(num2);
                System.out.println(num1 + " * " + num2 + " = " + b1.multiply(b2).toString() + " === " + solution.multiply(num1, num2) + "\t" +
                        b1.multiply(b2).toString().equals(solution.multiply(num1, num2)));
            }
        }
    }
}
