package ps.google.recursion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordSquare {

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new LinkedList<>();
        if (words.length < 1) {
            return ans;
        }
        int len = words[0].length();

        dfs(words, new LinkedList<>(), len, ans);
        return ans;
    }

    private void dfs(String[] words, List<String> current, int len, List<List<String>> answer) {
        if (current.size() == len) {
            answer.add(new LinkedList<>(current));
            return;
        }

        int currentSize = current.size();
        StringBuilder prefixBuffer = new StringBuilder();
        for (String w : current) {
            prefixBuffer.append(w.charAt(currentSize));
        }
        String prefix = prefixBuffer.toString();
        for (String word : words) {
            if (word.startsWith(prefix)) {
                current.add(word);
                dfs(words, current, len, answer);
                //revert
                current.remove(currentSize);
            }
        }
    }


    public static void main(String[] args) {
        WordSquare ws = new WordSquare();
        ws.wordSquares(new String[]{"ball", "area", "lead", "lady", "wall"}).forEach(
                ans -> {
                    ans.forEach(System.out::println);
                    System.out.println("----------");
                }
        );

        ws.wordSquares(new String[]{"abat", "baba", "atan", "atal"}).forEach(
                ans -> {
                    ans.forEach(System.out::println);
                    System.out.println("----------");
                }
        );
    }
}
