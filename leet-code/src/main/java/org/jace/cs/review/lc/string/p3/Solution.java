package org.jace.cs.review.lc.string.p3;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//maintain last distinct substring using linkedlist and hashset
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> distinct = new HashSet<>();
        LinkedList<Character> substring = new LinkedList<>();
        int maxSubString = 0;
        for(int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            while(distinct.contains(letter)) {
                Character key = ((LinkedList<Character>) substring).removeFirst();
                distinct.remove(key);
            }
            distinct.add(letter);
            substring.add(letter);
            if(substring.size() > maxSubString) {
                maxSubString = substring.size();
               // System.out.println("cuurrent max: " + substring);
            }
        }
        return maxSubString;
    }
}