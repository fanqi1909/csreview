package contest.c172;

import java.util.LinkedList;
import java.util.List;

public class Q2 {
    public List<String> printVertically(String s) {
        int maxLen = 0;
        String[] words = s.split(" ", -1);
        for(String word : words) {
            maxLen = Math.max(maxLen, word.length());
        }
        List<String> ans = new LinkedList<>();

        int i = 0;
        while(i < maxLen) {
            StringBuilder buffer = new StringBuilder();
            for(String word : words) {
                if(i < word.length()) {
                    buffer.append(word.charAt(i));
                } else {
                    buffer.append(" ");
                }
            }
            i++;
            while(buffer.charAt(buffer.length() - 1) == ' ') {
                buffer.deleteCharAt(buffer.length() - 1);
            }
            ans.add(buffer.toString());
        }
        return ans;
    }

    public static  void main(String[] args) {
        Q2 q = new Q2();
        System.out.println(q.printVertically("HOW ARE YOU"));
        System.out.println(q.printVertically("TO BE OR NOT TO BE"));
        System.out.println(q.printVertically("CONTEST IS COMING"));

    }
}

