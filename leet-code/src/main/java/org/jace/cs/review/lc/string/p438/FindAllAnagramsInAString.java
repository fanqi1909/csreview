package org.jace.cs.review.lc.string.p438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[26];
        for(char c : p.toCharArray()) {
            map[c - 'a']++;
        }
        int[] runningMap = new int[26];
        int i = 0;
        int j = i + p.length() - 1;

        char[] chars = s.toCharArray();
        for(int k = i; k <= j && k < chars.length; k++) {
            runningMap[chars[k]- 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        if(Arrays.equals(runningMap, map)) {
            ans.add(0);
        }
        while(j < chars.length - 1) {
            runningMap[chars[++j] - 'a']++;
            runningMap[chars[i++] - 'a']--;
            if(Arrays.equals(runningMap, map)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString faa = new FindAllAnagramsInAString();

        System.out.println(faa.findAnagrams("cbaebabacd", "abc"));
        System.out.println(faa.findAnagrams("abab", "ab"));
        System.out.println(faa.findAnagrams("abab", ""));
        System.out.println(faa.findAnagrams("", "a"));
    }
}
