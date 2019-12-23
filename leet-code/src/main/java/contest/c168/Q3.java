package contest.c168;

import java.util.HashMap;
import java.util.Map;

public class Q3 {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> frequency = new HashMap<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i <= chars.length - minSize; i++) {
            String q = qualified(chars, i, i + minSize - 1, maxLetters);
            if(!q.isEmpty()) {
                frequency.put(q, frequency.getOrDefault(q, 0) + 1);
            }
        }

        int max = 0;
        for(Map.Entry<String, Integer> en : frequency.entrySet()) {
            max = Math.max(max, en.getValue());
        }
        return max;
    }

    private String qualified(char[] chars, int l, int r, int letters) {
        int[] map = new int[26];
        int unique = 0;
        for(int i = l; i <=r && unique <= letters; i++) {
            if(map[chars[i] -'a'] == 0) {
                map[chars[i] - 'a']++;
                unique++;
            }
        }
        if(unique > letters) {
            return "";
        } else {
            return String.valueOf(chars, l, r-l +1);
        }
    }

    public static void main(String[] args) {
        Q3 sol = new Q3();
        System.out.println(sol.maxFreq("aababcaab", 2, 3, 4));
        System.out.println(sol.maxFreq("aaaa", 1, 3, 3));
        System.out.println(sol.maxFreq("aabcabcab", 2, 2, 3));
        System.out.println(sol.maxFreq("abcde", 2, 3, 3));
    }
}
