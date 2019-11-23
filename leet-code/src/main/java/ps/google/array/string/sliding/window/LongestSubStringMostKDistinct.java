package ps.google.array.string.sliding.window;

public class LongestSubStringMostKDistinct {
    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        int[] map = new int[128];
        int l = 0, r = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        int count = 0; //distinct number
        while (r < s.length()) {
            char c = s.charAt(r);
            if (map[c]++ == 0) count++;
            while (count > 2) {
                c = s.charAt(l);
                map[c]--;
                if (map[c] == 0) count--;
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int right = 0;
        int distinctCount = 0;
        int[] recorder = new int[128];

        int maxLen = 0;
        while (right < s.length()) {
            char next = s.charAt(right);
            recorder[next]++;
            if (recorder[next] == 1) {
                distinctCount++;
            }
            while (distinctCount > 2) {
                next = s.charAt(left);
                recorder[next]--;
                if (recorder[next] == 0) {
                    distinctCount--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1); //the actual range is [left, right];
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubStringMostKDistinct solution = new LongestSubStringMostKDistinct();
        System.out.println(solution.lengthOfLongestSubstringTwoDistinct(""));
        System.out.println(solution.lengthOfLongestSubstringTwoDistinct("a"));
        System.out.println(solution.lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(solution.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }
}
