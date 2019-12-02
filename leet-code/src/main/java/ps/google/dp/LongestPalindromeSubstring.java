package ps.google.dp;

import org.jace.cs.review.lc.dp.Util;

import java.util.Arrays;

public class LongestPalindromeSubstring {

    /*
     *
     * DP method is a typical case of Range DP.
     *     F[i,j] be the a indicator function of if s[i:j] is a palindrome
     *     A recursive form of F[i:j] can be written as:
     *     F[i,j] = F[i+1, j-1] + 2 if s[i] = s[j];
     *              1, if i == j
     *              0 if s[i] != s[j]
     *
     * Then the longest palindrome substring would be
     *   \forall 0<=i<=j<s.length() max(F[i,j])
     *
     */
    public String longestPalindromeDP(String s) {

        if(s.length() == 0) return s;

        int[][] F = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            F[i][i] = 1;
        }

        int max = 1;
        String maxString = s.substring(0,1);
        for(int i = s.length() - 2; i >=0; i--) {
            for(int j = i + 1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(i > j-2) {
                        F[i][j] = 2;
                    } else {
                        F[i][j] = F[i+1][j-1] == 0 ? 0 : F[i + 1][j - 1] + 2;
                    }
                } else {
                    F[i][j] = 0;
                }
                if(max < F[i][j]) {
                    max = F[i][j];
                    maxString = s.substring(i, j + 1);
                }

            }
        }
        return maxString;
    }

    /**
     * A non-dp solution. Enumerate the maximum palindrome centered at each s[i].
     * To avoid the odd-even count, expand the string by inserting $ in-between each char.
     */
    public String longestPalindromeEnum(String s) {
        if(s.isEmpty()) return s;
        StringBuilder enriched = new StringBuilder();
        for (char c : s.toCharArray()) {
            enriched.append(c);
            enriched.append('$');
        }
        enriched.deleteCharAt(enriched.length() - 1);

        char[] temp = enriched.toString().toCharArray();

        int max = 0;
        String maxString = "";
        for (int i = 0; i < temp.length; i++) {
            int len = 0;
            while (i - len >= 0 && i + len <= temp.length - 1 && temp[i + len] == temp[i - len]) {
                len++;
            }
            StringBuilder builder = new StringBuilder();
            for (int k = i - len + 1; k <= i + len - 1; k++) {
                if (temp[k] != '$') {
                    builder.append(temp[k]);
                }
            }
            if(max < builder.length()) {
                max = builder.length();
                maxString = builder.toString();
            }
        }
        return maxString;
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();

        System.out.println(lps.longestPalindromeDP("babad") + "\t" + lps.longestPalindromeEnum("babad"));
//
        System.out.println(lps.longestPalindromeDP("cbbd") + "\t" + lps.longestPalindromeEnum("cbbd"));
        System.out.println(lps.longestPalindromeDP("") + "\t" + lps.longestPalindromeEnum(""));
        System.out.println(lps.longestPalindromeDP("abb") + "\t" + lps.longestPalindromeEnum("abb"));
        System.out.println(lps.longestPalindromeDP("abvkchdgdbcnabncbdgiqoghsgglaposushg") + "\t" + lps.longestPalindromeEnum("abvkchdgdbcnabncbdgiqoghsgglaposushg"));
    }
}
