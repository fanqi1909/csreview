package org.jace.cs.review.lc.string.p459;

public class RepeatedSubstringPattern {

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
            if (input.charAt(k) == input.charAt(i)) {
                next[i] = k + 1;
            }
        }
        return next;
    }

    public boolean repeatedSubstringPattern(String s) {
        int[] next = getNextArray(s);
        int len = s.length();
        int last = next[len - 1];
        return last != 0 && len % (len - last) == 0;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern rsp = new RepeatedSubstringPattern();
        System.out.println(rsp.repeatedSubstringPattern("abab"));
        System.out.println(rsp.repeatedSubstringPattern("aba"));
        System.out.println(rsp.repeatedSubstringPattern("abcabcabcabc"));
    }
}
