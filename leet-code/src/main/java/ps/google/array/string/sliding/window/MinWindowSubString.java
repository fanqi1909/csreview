package ps.google.array.string.sliding.window;


public class MinWindowSubString {
    /**
     * Use slide window to find the best string. Let window be [l, r];
     * Always maintain [l, r] such that, the valid range is [l, r - 1].
     * <p>
     * Extending r until the substring matches
     * Shrink l until the substring does not match
     */
    public String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() == 0) {
            return "";
        }
        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]++;

        int min = Integer.MAX_VALUE;

        int left = 0, right = 0;
        int[] map2 = new int[128];

        int minStart = 0;
        int minEnd = 0;
        while (right < s.length()) {
            map2[s.charAt(right)]++;
            right++; //extending right boundary

            while (matches(map, map2)) {
                //the current valid window is [left, right-1], notice the minus 1
                int length = right - left;
                if (length < min) {
                    min = length;
                    minStart = left;
                    minEnd = right; // minEnd is exclusive for calling substring
                }
                //shrink left boundary
                map2[s.charAt(left)]--;
                left++;
            }
        }
        return s.substring(minStart, minEnd);
    }

    private boolean matches(int[] map, int[] map2) {
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0 && map2[i] < map[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        MinWindowSubString solution = new MinWindowSubString();
        System.out.println(solution.minWindow("ADOBECODEBANC", "A"));
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABCG"));
        System.out.println(solution.minWindow("ADOBECODEBNCG", "ABCG"));
        System.out.println(solution.minWindow("DOBAECODEBNCG", "ABCG"));
    }
}