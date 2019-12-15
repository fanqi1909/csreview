package contest.c167;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q2 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new LinkedList<>();

        for(int i = 1; i <= 9; i++) {
            startWith(i, low, high, ans);
        }
        Collections.sort(ans);
        return ans;
    }

    private void startWith(int i, int low, int high, List<Integer> ans) {
        int sum = i;
        while(sum < low && i < 9) {
            sum = sum * 10 + (++i);
        }
        //sum is greater or equal to low now
        while(low <= sum && sum <= high && i <= 9) {
            ans.add(sum);
            sum = sum * 10 + (++i);
        }
    }

    public static void main(String[] args) {
        Q2 sol = new Q2();
        System.out.println(sol.sequentialDigits(100, 300));
        System.out.println(sol.sequentialDigits(1000, 13000));
        System.out.println(sol.sequentialDigits(10, 1000000000));
    }
}
