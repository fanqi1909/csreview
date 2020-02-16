package org.jace.cs.review.lc.graph.p1048;

import java.util.*;

public class LongestStringChain {

    public int longestStrChain(String[] words) {

        Map<Integer, Set<Integer>> levelWords = new HashMap<>();
        int[][] dict = new int[words.length][26];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            dict[i] = charmap(word);
            levelWords.computeIfAbsent(word.length(), k -> new HashSet<>()).add(i);
        }

        Integer[] dp = new Integer[words.length];

        int ans = 0;
        for(int i = 0; i < dp.length; i++) {
            ans = Math.max(ans, dfs(i, dp, levelWords, dict, words));
        }

        System.out.println(Arrays.toString(dp));

        return ans;
    }

    private int dfs(int pos, Integer[] dp, Map<Integer, Set<Integer>> levelWords, int[][] dict, String[] words) {
        if(dp[pos] != null) {
            return dp[pos];
        }
        if(pos >= words.length) {
            return 0;
        }
        else {
            //check what value it can go
            String word = words[pos];
            int level = word.length();
            if(levelWords.containsKey(level + 1)) {
                Set<Integer> levelList = levelWords.get(level + 1);
                int opt = 1;
                for(int wIndex : levelList) {
                    if(diff(pos, wIndex, dict)) {
                        opt = Math.max(opt, dfs(wIndex, dp, levelWords, dict, words) + 1);
                    }
                }
                dp[pos] = opt;
            } else {
                dp[pos] = 1; //last level
            }
            return dp[pos];
        }
    }

    private boolean diff(int pos, int wIndex, int[][] dict) {
        int[] map1 = dict[pos];
        int[] map2 = dict[wIndex];
        for(int i = 0; i < 26; i++) {
            if(map1[i] > map2[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] charmap(String word) {
        int[] ans = new int[26];
        for(char c : word.toCharArray()) {
            ans[c - 'a']++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestStringChain lsc = new LongestStringChain();
        System.out.println(lsc.longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
        System.out.println(lsc.longestStrChain(new String[]{"sgtnz","sgtz","sgz","ikrcyoglz","ajelpkpx","ajelpkpxm","srqgtnz","srqgotnz","srgtnz","ijkrcyoglz"}));
        System.out.println(lsc.longestStrChain(new String[]{"cefkp","efkp","pkacefkep","pkacefkp","pacefkp","acefkp"}));

    }
}
