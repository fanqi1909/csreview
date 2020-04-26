package contest.c181;

import java.util.Arrays;

public class Q4 {

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

    public String longestPrefix(String s) {
        if(s == null || s.isEmpty()) {
            return "";
        }
        int[] next = getNextArray(s);

        if(next[next.length - 1] != 0) {
            return s.substring(0, next[next.length - 1]);
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        Q4 q4 = new Q4();
        System.out.println(q4.longestPrefix("level"));
        System.out.println(q4.longestPrefix("ababab"));
        System.out.println(q4.longestPrefix("leetcodeleet"));
        System.out.println(q4.longestPrefix("a"));
        System.out.println(q4.longestPrefix(""));
    }
}
