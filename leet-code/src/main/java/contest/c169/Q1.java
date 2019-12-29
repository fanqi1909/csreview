package contest.c169;

import java.util.Arrays;

public class Q1 {
    public int[] sumZero(int n) {
        int[] ans = new int[n];

        for(int i = 0; i < n/2; i++) {
            ans[i] = i + 1;
            ans[n-i -1] = -ans[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        Q1 sol = new Q1();
        System.out.println(Arrays.toString(sol.sumZero(5)));
        System.out.println(Arrays.toString(sol.sumZero(3)));
        System.out.println(Arrays.toString(sol.sumZero(1)));
        System.out.println(Arrays.toString(sol.sumZero(2)));
        System.out.println(Arrays.toString(sol.sumZero(4)));
    }
}
