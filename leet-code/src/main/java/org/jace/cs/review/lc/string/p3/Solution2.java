package org.jace.cs.review.lc.string.p3;


import java.util.*;

//maintain last distinct substring using linkedhashset
class Solution2 {
    public int lengthOfLongestSubstring(String s) {

        LinkedHashSet<Character> set = new LinkedHashSet<>();

        int maxSubString = 0;

        for(int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);

            while(set.contains(letter)) {
                set.remove(set.iterator().next());
            }
            set.add(letter);
            if(set.size() > maxSubString) {
                maxSubString = set.size();
               // System.out.println("cuurrent max: " + substring);
            }
        }
        return maxSubString;
    }
}