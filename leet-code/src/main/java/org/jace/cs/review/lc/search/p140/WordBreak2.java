package org.jace.cs.review.lc.search.p140;

import java.util.*;

public class WordBreak2 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new LinkedList<>();
        if (s.length() == 0) return result;

        Set<String> dict = new HashSet<>(wordDict);
        int maxLen = 0;
        for(String word : wordDict) {
            dict.add(word);
            maxLen = Math.max(maxLen, word.length());
        }

        List<String>[] lookup = new List[s.length() + 1];
        lookup[s.length()] = new LinkedList<>();
        lookup[s.length()].add("");


        return wordBreak(0, s, dict, maxLen, lookup);
    }

    private List<String> wordBreak(int start, String text, Set<String> dict, int maxLen, List<String>[] lookup) {
        if (lookup[start] != null) {
            return lookup[start];
        }

        List<String> result = new LinkedList<>();
        for (int i = start + 1; i <= text.length() && i - start <= maxLen; i++) {
            String word = text.substring(start, i);
            if (dict.contains(word)) {
                List<String> remaining = wordBreak(i, text, dict, maxLen, lookup);
                for (String r : remaining) {
                    if(r.isEmpty()) {
                        result.add(word);
                    } else {
                        result.add(word + " " + r);
                    }
                }
            }
        }
        lookup[start] = result;
        return lookup[start];
    }

    public static void main(String[] args) {
        WordBreak2 wb = new WordBreak2();

        System.out.println(wb.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));

        System.out.println(wb.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));

        System.out.println(wb.wordBreak("catsandog", Arrays.asList("cat", "cats", "and", "sand", "dog")));

    }
}
