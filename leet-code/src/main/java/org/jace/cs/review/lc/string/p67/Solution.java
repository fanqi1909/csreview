package org.jace.cs.review.lc.string.p67;

public class Solution {

    public String addBinary(String a, String b) {
        int maxLen = Math.max(a.length(), b.length());

        StringBuilder revA = new StringBuilder(a).reverse();
        StringBuilder revB = new StringBuilder(b).reverse();

        if (maxLen == a.length()) {
            while (revB.length() != maxLen) {
                revB.append("0");
            }
        } else {
            while (revA.length() != maxLen) {
                revA.append("0");
            }
        }

        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < maxLen; i++) {
            int sum = (revA.charAt(i) - '0')
                    + (revB.charAt(i) - '0') + carry;
            if (sum >= 2) {
                result.append(sum - 2);
                carry = 1;
            } else {
                result.append(sum);
                carry = 0;
            }
        }
        if (carry == 1) {
            result.append(carry);
        }

        return result.reverse().toString();

    }

    public String addBinary2(String b1, String b2) {
        int i = b1.length() - 1;
        int j = b2.length() - 1;
        int sum = 0;

        StringBuilder builder = new StringBuilder();

        while (i >= 0 || j >= 0 || sum == 1) {
            if (i >= 0) sum += b1.charAt(i) - '0';
            if (j >= 0) sum += b2.charAt(j) - '0';
            if (sum >= 2) {
                builder.append(sum - 2);
                sum = 1;
            } else {
                builder.append(sum);
                sum = 0;
            }
            i--;
            j--;
        }
        return builder.reverse().toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("100 === " + solution.addBinary("11", "1") + "\t" + solution.addBinary2("11", "1"));
        System.out.println("10101 === " + solution.addBinary("1010", "1011") + "\t" + solution.addBinary2("1010", "1011"));
    }
}
