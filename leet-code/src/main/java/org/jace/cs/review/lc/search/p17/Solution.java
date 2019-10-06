package org.jace.cs.review.lc.search.p17;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    private static String[] mapping  = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return Collections.emptyList();
        }
        int num = digits.charAt(0) - '0';
        String options = mapping[num-2];

        if(digits.length() == 1) {
            return Arrays.asList(options.split(""));
        }

        List<String> laterCombinations = letterCombinations(digits.substring(1));
        List<String> results = new LinkedList<>();
        char head;
        for(int i = 0, len = options.length(); i < len; i++) {
            head = options.charAt(i);
            for(String suffix : laterCombinations) {
                results.add(head + suffix);
            }
        }
        return results;
    }
}
