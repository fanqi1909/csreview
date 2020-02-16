package contest.c171;

import javafx.util.Pair;
import org.jace.cs.review.lc.dp.Util;

import java.util.HashMap;
import java.util.Map;

public class Q4 {
//    static char[][] keyboard = new char[][]{
//            new char[]{'A', 'B', 'C', 'D', 'E', 'F'},
//            new char[]{'G', 'H', 'I', 'J', 'K', 'L'},
//            new char[]{'M', 'N', 'O', 'P', 'Q', 'R'},
//            new char[]{'S', 'T', 'U', 'V', 'W', 'X'},
//            new char[]{'Y', 'Z'}
//    };

    public int minimumDistance(String word) {
        int[][] dp = new int[word.length()][26];

        for (int i = 1; i < word.length(); i++) {
            for (int x = 0; x < 26; x++) {
                //CASE 1: move the finger that locates at word[i], so the other still rest at char 'x'
                int min = dp[i - 1][x] + diff(word.charAt(i), word.charAt(i - 1));

                //CASE 2: the word to be typed happens to be 'x'
                //this line turns the state to "dp[i][word.charAt(i-1)]"; so do not need to be considered.
                if(x == word.charAt(i) - 'A') {
                  //  min = Math.min(min, dp[i-1][x]);
                }

                //CASE 3: when last typed word is 'x', then we check for all possible locations of s, and find the minimum
                if (x == word.charAt(i - 1) - 'A') {
                    for (int s = 0; s < 26; s++) {
                        if(s != x) {
                            min = Math.min(min, dp[i - 1][s] + diff((char)(s + 'A'), word.charAt(i)));
                        }
                    }
                }
                dp[i][x] = min;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            ans = Math.min(ans, dp[word.length() - 1][i]);
        }
        return ans;
    }

    private int diff(char cx, char cy) {
        return Math.abs((cx-'A') /6 - (cy-'A')/6) + Math.abs((cx-'A') % 6 - (cy-'A')%6);
    }


    public static void main(String[] args) {
        Q4 q4 = new Q4();

        System.out.println(q4.minimumDistance("CAKE") + " === 3");
        System.out.println(q4.minimumDistance("HAPPY") + " === 6");
        System.out.println(q4.minimumDistance("NEW") + " === 3");
        System.out.println(q4.minimumDistance("YEAR") + " === 7");
        System.out.println(q4.minimumDistance("YPLTJVLSUTEWJMXNUCATGWKFHHUOMWVSNBMWSNYVWBFOCIWFOQPRTYABPKJOBZZNGRUCXEAMVNKAGAWYAVQTDGDTUGJIWFDPMUCAIOZDIEUQULDEIABBGVIRKLSBXWTU") + " === 267");
    }
}
