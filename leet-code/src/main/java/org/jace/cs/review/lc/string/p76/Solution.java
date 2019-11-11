package org.jace.cs.review.lc.string.p76;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public String minWindow(String s, String t) {

        if (t.isEmpty()) return "";
        if (s.isEmpty()) return "";

        List<Integer>[] charPositions = new List[58];
        for(int i = 0; i < 58; i++) {
            charPositions[i] = new LinkedList<Integer>();
        }

        int[] frequency = new int[58];
        for (int i = 0, len = t.length(); i < len; i++) {
            frequency[t.charAt(i) - 'A']++;
        }

        PriorityQueue<Integer> mins = new PriorityQueue<>();
        PriorityQueue<Integer> maxs = new PriorityQueue<>(Comparator.reverseOrder());

        String minResult = "";

        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            if (frequency[c - 'A'] > 0) {
                charPositions[c - 'A'].add(i);
                mins.add(i);
                maxs.add(i);
                if (charPositions[c - 'A'].size() > frequency[c - 'A']) {
                    int last = charPositions[c - 'A'].remove(0);
                    mins.remove(last);
                    maxs.remove(last);
                }
                //compare
                if (matches(frequency, charPositions)) {
                    String temp = s.substring(mins.peek(), maxs.peek() + 1);
                    if (minResult.isEmpty() || temp.length() < minResult.length()) {
                        minResult = temp;
                    }
                }
            }
        }
        return minResult;

    }

    private boolean matches(int[] frequency, List<Integer>[] charPositions) {
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] != 0
                    && frequency[i] != charPositions[i].size()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "COB"));
    }
}
