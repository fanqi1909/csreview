package org.jace.cs.review.lc.search.p30;

import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }

        Map<String, Integer> wordMap = createWordMap(words);
        int wordLength = words[0].length();

        for (int i=0; i<= s.length() - wordLength; i++) {
            Map<String, Integer> occurrenceMap = new HashMap<>(wordMap);
            if (containsAllWords(occurrenceMap, s, i, wordLength)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean containsAllWords(Map<String, Integer> occurrenceMap, String s, int startIndex, int wordLength) {
        while (startIndex + wordLength <= s.length() ) {
            String word = s.substring(startIndex, startIndex + wordLength);
            if (occurrenceMap.containsKey(word)) {
                int freq = occurrenceMap.get(word);
                if (freq > 1) {
                    occurrenceMap.put(word, freq-1);
                } else {
                    occurrenceMap.remove(word);
                }
            } else {
                return false;
            }
            if (occurrenceMap.isEmpty()) {
                return true;
            }

            startIndex += wordLength;
        }
        return false;
    }

    private Map<String, Integer> createWordMap(String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word: words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        return wordMap;
    }
}
