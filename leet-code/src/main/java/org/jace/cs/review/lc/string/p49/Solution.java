package org.jace.cs.review.lc.string.p49;

import java.util.*;

/**
 * Use frequency array to build signature of each word.
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dict = new HashMap<>();

        for(String word : strs) {
            char[] freq = new char[26];
            for(int i = 0, len = word.length(); i < len; i++) {
                freq[word.charAt(i) - 'a']++;
            }
            String signature = new String(freq);

            dict.putIfAbsent(signature, new ArrayList<>());
            dict.get(signature).add(word);
        }

        return new ArrayList<>(dict.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] test = new String[]{
                "eat", "tea", "tan", "ate", "nat", "bat"
        };

        System.out.println(solution.groupAnagrams(test));

        test = new String[]{};

        System.out.println(solution.groupAnagrams(test));

        test = new String[]{"bob", "boo"};
        System.out.println(solution.groupAnagrams(test));
    }
}
