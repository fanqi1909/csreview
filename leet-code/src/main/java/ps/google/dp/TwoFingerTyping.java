package ps.google.dp;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class TwoFingerTyping {
    static char[][] keyboard = new char[][]{
            new char[]{'A', 'B', 'C', 'D', 'E', 'F'},
            new char[]{'G', 'H', 'I', 'J', 'K', 'L'},
            new char[]{'M', 'N', 'O', 'P', 'Q', 'R'},
            new char[]{'S', 'T', 'U', 'V', 'W', 'X'},
            new char[]{'Y', 'Z'}
    };

    public int minMove(String word) {
        Map<Character, Pair<Integer, Integer>> index = new HashMap<>();
        for (int i = 0; i < keyboard.length; i++) {
            for (int j = 0; j < keyboard[i].length; j++) {
                index.put(keyboard[i][j], new Pair<>(i, j));
            }
        }

        int[][] dp = new int[word.length()][26];

        for (int i = 1; i < word.length(); i++) {
            for (int x = 0; x < 26; x++) {
                //CASE 1: move the figure that locates at word[i], so the other still rest at char 'x'
                int min = dp[i - 1][x] + diff(word.charAt(i), word.charAt(i - 1), index);

                //CASE 2: the word to be typed happens to be 'x'
                if(x == word.charAt(i) - 'A') {
                    min = Math.min(min, dp[i-1][x]);
                }

                //CASE 3: when last typed word is 'x', then we check for all possible locations of s, and find the minimum
                if (x == word.charAt(i - 1) - 'A') {
                    for (int s = 0; s < 26; s++) {
                        min = Math.min(min, dp[i - 1][s] + diff((char)(s + 'A'), word.charAt(i), index));
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

    private int diff(char cx, char cy, Map<Character, Pair<Integer, Integer>> index) {
        Pair<Integer, Integer> posx = index.get(cx);
        Pair<Integer, Integer> posy = index.get(cy);
        return Math.abs(posx.getKey() - posy.getKey()) + Math.abs(posx.getValue() - posy.getValue());
    }


    public static void main(String[] args) {
        TwoFingerTyping tft = new TwoFingerTyping();

        System.out.println(tft.minMove("CAKE") + " === 3");
        System.out.println(tft.minMove("ABZ") + " === 1");
        System.out.println(tft.minMove("ABXZ") + " === 5");
        System.out.println(tft.minMove("ASBTCU") + " === 4");
        System.out.println(tft.minMove("ASGTCU") + " === 6");
    }
}
