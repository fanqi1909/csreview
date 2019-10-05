package org.jace.cs.review.lc.string.p14;

import java.util.Arrays;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        StringBuilder prefix = new StringBuilder();
        String first = strs[0];
        for(int i = 0; i < first.length(); i++) {
            char letter = first.charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].length() <= i || strs[j].charAt(i) != letter) {
                    return prefix.toString();
                }
            }
            prefix.append(letter);
        }
        return prefix.toString();
    }
}
