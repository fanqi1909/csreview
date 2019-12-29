package org.jace.cs.review.lc.number.p829;

public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int N) {
        int ans = 0;
        long sum = 0;
        for (int i = 1; i <= N && N >= sum; i++) {
            sum += i;
            if ((N >= sum) && (N - sum) % i == 0) {
                ans++;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        ConsecutiveNumbersSum cns = new ConsecutiveNumbersSum();
        System.out.println(cns.consecutiveNumbersSum(5));
        System.out.println(cns.consecutiveNumbersSum(9));
        System.out.println(cns.consecutiveNumbersSum(15));
        System.out.println(cns.consecutiveNumbersSum(125));
        System.out.println(cns.consecutiveNumbersSum(283));
        System.out.println(cns.consecutiveNumbersSum(451));
        System.out.println(cns.consecutiveNumbersSum(148592));
    }
}
