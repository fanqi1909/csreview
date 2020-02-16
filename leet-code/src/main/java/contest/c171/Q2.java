package contest.c171;

public class Q2 {
    public int minFlips(int a, int b, int c) {
        int i = 0;
        int ans = 0;
        while(i < 32) {
            int mask = 1 << i;
            int aBit = a & mask;
            int bBit = b & mask;
            int cBit = c & mask;
            if((aBit | bBit) != cBit) {
                if(cBit == 1) {
                    ans += 1;
                } else {
                    // 0
                    if(aBit == 0 || bBit == 0) {
                        ans += 1;
                    } else {
                        ans +=2;
                    }
                }
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Q2 q2 = new Q2();

        System.out.println(q2.minFlips(2, 6, 5));
        System.out.println(q2.minFlips(4, 2, 7));
        System.out.println(q2.minFlips(1, 2, 3));
    }
}
