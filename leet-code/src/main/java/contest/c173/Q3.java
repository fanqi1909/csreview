package contest.c173;

import java.util.Arrays;

public class Q3 {
    public int[] closestDivisors(int num) {
        int maxBound = (int) Math.ceil(Math.sqrt(num + 2));

        int minDiff = num;
        int[] ans = new int[]{1, num+1};
        for (int i = 2; i <= maxBound; i++) {
            int another = findOther(i, num + 2, num + 1);
            if(another > 0 && minDiff > another - i) {
                minDiff = another - i;
                ans[0] = i;
                ans[1] = another;
            }
        }
        return ans;
    }

    private int findOther(int i, int i1, int i2) {
        if (i1 % i == 0) {
            return i1 / i;
        } else if (i2 % i == 0) {
            return i2 / i;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Q3 q3 = new Q3();
        System.out.println(Arrays.toString(q3.closestDivisors(2)));
    }
}
