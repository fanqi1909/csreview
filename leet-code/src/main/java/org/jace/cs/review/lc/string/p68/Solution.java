package org.jace.cs.review.lc.string.p68;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> buffer = new ArrayList<>();
        List<String> result = new LinkedList<>();

        int currentWidth = 0;
        for (int i = 0; i < words.length; i++) {
            if (currentWidth == 0) {
                currentWidth += words[i].length();
            } else {
                currentWidth += words[i].length() + 1; // with at least one space
            }

            if (currentWidth <= maxWidth) {
                buffer.add(words[i]);
            } else {
                currentWidth = 0;
                result.add(justify(buffer, maxWidth));
                buffer.clear();
                i--;
            }
        }
        result.add(leftJustify(buffer, maxWidth));
        return result;
    }

    private String leftJustify(List<String> buffer, int maxWidth) {
        String word = String.join(" ", buffer);
        int remaining = maxWidth - word.length();
        StringBuilder builder = new StringBuilder();
        builder.append(word);
        for(int i = 0 ; i< remaining; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    private String justify(List<String> buffer, int maxWidth) {
        if(buffer.size() == 1) {
            return leftJustify(buffer, maxWidth);
        }

        int[] chars = new int[buffer.size() - 1 ];

        for (String word : buffer) {
            maxWidth -= word.length();
        }

        int pos = 0;
        while (maxWidth > 0) {
            chars[pos]++;
            pos = (pos + 1) % chars.length;
            maxWidth--;
        }

        StringBuilder result = new StringBuilder();
        result.append(buffer.get(0));
        for(int i = 0; i < chars.length; i++) {
            for(int j = 0; j < chars[i]; j++) {
                result.append(" ");
            }
            if(i + 1 < buffer.size()) {
                result.append(buffer.get(i+1));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] test = new String[]{"This", "is", "an", "example", "of", "text", "justification."};

        solution.fullJustify(test, 16).forEach(System.out::println);

        test = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};
        solution.fullJustify(test, 16).forEach(System.out::println);


        test = new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        solution.fullJustify(test, 20).forEach(System.out::println);
    }
}
