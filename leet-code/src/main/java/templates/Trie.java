package templates;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Trie is the prefix tree that can consolidate a list of words,  to facilitate fast prefix search
 */
public class Trie {

    class TrieNode {
        TrieNode[] children = new TrieNode[128];
        boolean isLeaf;
    }

    private TrieNode root;

    public Trie(String[] words) {
        this.root = new TrieNode();
        for (String word : words) {
            TrieNode iter = this.root;
            for (char letter : word.toCharArray()) {
                if (iter.children[letter] == null) {
                    TrieNode newNode = new TrieNode();
                    iter.children[letter] = newNode;
                }
                iter = iter.children[letter];
            }
            iter.isLeaf = true; //find the appropriate children, mark it as leaf
        }
    }

    public List<String> getWordsWithPrefix(String prefix) {
        TrieNode node = this.root;
        for (Character letter : prefix.toCharArray()) {
            if (node.children[letter] != null) {
                node = node.children[letter];
            } else {
                // return an empty list.
                return new ArrayList<>();
            }
        }
        return allDescendant(node).stream().map(s -> prefix + s.reverse().toString()).collect(Collectors.toList());
    }

    private List<StringBuilder> allDescendant(TrieNode node) {
        if(node == null) {
            return Collections.emptyList();
        }

        List<StringBuilder> results = new ArrayList<>();
        if(node.isLeaf) {
            results.add(new StringBuilder());
        }
        for(int i = 0; i < node.children.length; i++) {
            TrieNode child = node.children[i];
            List<StringBuilder> childStrings = allDescendant(child);
            for(StringBuilder cString : childStrings) {
                results.add( cString.append((char) i));
            }
        }
        return results;
    }

    public boolean containsWord(String word) {
        TrieNode node = this.root;
        for(Character letter : word.toCharArray()) {
            if (node.children[letter] != null) {
                node = node.children[letter];
            } else {
                return false;
            }
        }
        return node.isLeaf;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"word", "ball", "banana", "world", "leet", "let", "leed","leader"};
        Trie trie = new Trie(words);
//        System.out.println(trie);
        System.out.println(trie.getWordsWithPrefix("word"));
        System.out.println(trie.getWordsWithPrefix("ba"));
        System.out.println(trie.getWordsWithPrefix("lee"));
        System.out.println(trie.getWordsWithPrefix("le"));

        System.out.println(trie.containsWord("le"));
        System.out.println(trie.containsWord("leet"));
        System.out.println(trie.containsWord("let"));

    }
}
