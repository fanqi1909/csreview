package org.jace.cs.review.lc.number.p50;

public class Solution {
    public double myPow(double x, int n) {
        if(n < 0) {
            long exp = (long)n;
            return pow(1/x, -exp);
        } else {
            return pow(x, n);
        }
    }

    private double pow(double v, long n) {
        if(n == 0) {
            return 1.0;
        } else if(n == 1) {
            return v;
        } else {
            double half = pow(v, n/2);
            double square = half * half;
            if((n & 1) == 1) {
                return square * v;
            } else {
                return square;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.myPow(2.00000, 10));
        System.out.println(solution.myPow(2.1, 3));
        System.out.println(solution.myPow(0.00001, 2147483647));

    }
}
