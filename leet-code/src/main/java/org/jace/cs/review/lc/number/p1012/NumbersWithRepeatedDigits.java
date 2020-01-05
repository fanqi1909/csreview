package org.jace.cs.review.lc.number.p1012;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumbersWithRepeatedDigits {

    public int numDupDigitsAtMostN(int N) {
        // Transform N + 1 to arrayList

        char[] digits = String.valueOf(N + 1).toCharArray();

        // Count the number with digits < N
        int res = 0;

        for (int i = 1; i < digits.length; ++i) {
            res += 9 * A(9, i - 1);
        }

        // Count the number with same prefix
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            for (int j = i > 0 ? 0 : 1; j < digits[i] - '0'; j++) {
                if (!seen.contains(j)) {
                    res += A(9 - i, digits.length - i - 1);
                }
            }
            if (!seen.contains(digits[i] - '0')) {
                seen.add(digits[i] - '0');
            } else {
                break;
            }
        }
        return N - res;
    }

    public int A(int m, int n) {
        return n == 0 ? 1 : A(m, n - 1) * (m - n + 1);
    }

    public static void main(String[] args) {
        NumbersWithRepeatedDigits nwrd = new NumbersWithRepeatedDigits();
        System.out.println(nwrd.numDupDigitsAtMostN(10));
        System.out.println(nwrd.numDupDigitsAtMostN(20));
        System.out.println(nwrd.numDupDigitsAtMostN(21));
        System.out.println(nwrd.numDupDigitsAtMostN(22));
        System.out.println(nwrd.numDupDigitsAtMostN(100));
        System.out.println(nwrd.numDupDigitsAtMostN(112));
        System.out.println(nwrd.numDupDigitsAtMostN(1000));
    }
}
