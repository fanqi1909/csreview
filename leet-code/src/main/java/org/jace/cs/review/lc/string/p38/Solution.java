package org.jace.cs.review.lc.string.p38;

public class Solution {

    public String countAndSay(int n) {
        String[] answer = new String[n];
        answer[0] = "1";
        for (int i = 1; i < answer.length; i++) {
            String prev = answer[i - 1];
            StringBuilder result = new StringBuilder();

            int pointer = 0;
            while (pointer < prev.length()) {
                char num = prev.charAt(pointer);
                int p2 = pointer + 1;
                while (p2 < prev.length() && num == prev.charAt(p2)) {
                    p2++;
                }
                result.append(p2 - pointer);
                result.append(num);
                pointer = p2;

            }

            answer[i] = result.toString();
        }
        return answer[n-1];
    }
}
