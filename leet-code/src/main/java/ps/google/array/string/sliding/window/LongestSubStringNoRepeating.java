package ps.google.array.string.sliding.window;

import java.util.Arrays;

public class LongestSubStringNoRepeating {

    /**
     * Two pointer (actually three pointers) for sliding window.
     * Right is keep extending to break the condition when condition meet (map[current] < left)
     * Left is extending to meet the condition (when condition does not meet)
     *
     * Max is recorded when new left is generated, or right breaks
     * To print out the substring, we can use s.substring(left, right) when max is updated.
     *
     * @param s
     * @return
     */

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int left = 0;
        int right = 1;
        int[] map = new int[128];
        Arrays.fill(map, -1);
        map[s.charAt(0)] = 0;
        int max = 1;
        while (right < s.length()) {
            char current = s.charAt(right);
            if(map[current] >= left) {
                max = Math.max(max, right - left);
                left = map[current] + 1; //fast move left to the next valid position
            }
            map[current] = right;
            right++;
        }
        max = Math.max(max, right - left);
        return max;
    }

    public static void main(String[] args) {
        LongestSubStringNoRepeating solution = new LongestSubStringNoRepeating();
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
        System.out.println(solution.lengthOfLongestSubstring("abba"));
        System.out.println(solution.lengthOfLongestSubstring("au"));
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}
