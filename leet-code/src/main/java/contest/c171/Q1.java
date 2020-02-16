package contest.c171;

import java.util.Arrays;

public class Q1 {

    public int[] getNoZeroIntegers(int n) {
        for(int i = 1; i < n; i++) {
            if(!nonz(i) && !nonz(n-i)) {
                return new int[]{i, n-i};
            }
        }
        return new int[0];
    }

    private boolean nonz(int i) {
        return String.valueOf(i).contains("0");
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        System.out.println(Arrays.toString(q1.getNoZeroIntegers(1010)));
    }
}

