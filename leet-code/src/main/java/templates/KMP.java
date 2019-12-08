package templates;

import java.util.Arrays;

public class KMP {

    public int[] getNextArray(String input) {
        int m = input.length();
        int[] next = new int[m];

        next[0] = 0; // lps[0] is always 0
        for (int i = 1; i < m; i++) {
            //k is the length of the prefix to check with
            //next is the prefix function to move k to the previous prefixes
            int k = next[i - 1]; // the next char to compare if we wish to extend next[i-1];
            while (k > 0 && input.charAt(k) != input.charAt(i)) {
                k = next[k - 1];
            }
            if(input.charAt(k) == input.charAt(i)) {
                next[i] = k+ 1;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(Arrays.toString(kmp.getNextArray("ababababca")));

        System.out.println(Arrays.toString(kmp.getNextArray("abcababc")));
    }


}
