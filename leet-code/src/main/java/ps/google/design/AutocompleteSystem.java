package ps.google.design;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Use a Trie to store all the sentences and its occurance.
 * The TrieNode is enhanced with a counter "hit" to store frequency of words. Whenever a '#' is encountered, the hit is
 * incremented. Since each word is queried with all prefixes, the complexity would be O(m^2) where m is the node. However,
 * this implementation can be easily scale as server side does not need to maintain any client state. (client can cache buffer
 * at client side, and pass the whole prefix to server).
 *
 * A further optimization is to maintain a TrieNode along with buffer, so we do not need to revisit all prefixes again.
 *  This would reduce the query complexity to linear. This may be more difficult for maintain thread safety as we expose TrieNode
 *  as per query.
 *
 */
public class AutocompleteSystem {

    class TrieNode {
        TrieNode[] children;
        boolean isLeaf;
        int hit;

        public TrieNode() {
            children = new TrieNode[27]; //0-26 for a-z, 27 for ' ';
            isLeaf = false;
            hit = 0;
        }
    }

    TrieNode root;

    private void insert(String sentence, int times) {
        TrieNode next = root;
        for(char c : sentence.toCharArray()) {
            int index = c == ' '? 26 : c-'a';
            if(next.children[index] == null) {
                next.children[index] = new TrieNode();
            }
            next = next.children[index];
        }
        next.isLeaf = true;
        next.hit += times;
    }

    class SearchResult implements Comparable<SearchResult>{
        String term;
        int hit;
        public SearchResult(String term, int hit) {
            this.term = term;
            this.hit = hit;
        }

        @Override
        public int compareTo(SearchResult o) {
            if(hit != o.hit) {
                return o.hit - hit; //greater hit comes first
            } else {
                return term.compareTo(o.term); //smaller term comes second
            }
        }
    }

    private List<SearchResult> findPrefix(String prefix) {
        return findPrefixFrom(root, prefix);
    }

    private List<SearchResult> findPrefixFrom(TrieNode node, String prefix) {
        for(char c : prefix.toCharArray()) {
            int index = c == ' ' ? 26 : c - 'a';
            if(node.children[index] == null) {
                return Collections.emptyList(); // does not exist;
            } else {
                node = node.children[index];
            }
        }
        List<SearchResult> ans = new LinkedList<>();
        getAllChildren(node, prefix, ans);
        return ans;
    }

    private void getAllChildren(TrieNode probe, String prefix, List<SearchResult> ans) {
        if(probe != null) {
            if(probe.isLeaf) {
                ans.add(new SearchResult(prefix, probe.hit));
            }
            for(int i = 0; i < probe.children.length; i++) {
                TrieNode child = probe.children[i];
                if(child != null) {
                    char c = i == 26 ? ' ' : (char) (i + 'a');
                    getAllChildren(child, prefix + c, ans);
                }
            }
        }
    }


    //    private TrieNode probe;
    private StringBuilder buffer;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        for(int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
        buffer = new StringBuilder();
    }

    private void reset() {
        if(buffer.length() != 0) {
            insert(buffer.toString(), 1);
            buffer = new StringBuilder();
        }
    }

    public List<String> input(char c) {
        if(c == '#') {
            reset();
            return Collections.emptyList();
        } else {
            buffer.append(c);
        }
        List<SearchResult> allMatch = findPrefix(buffer.toString());
        PriorityQueue<SearchResult> queue = new PriorityQueue<>(allMatch);
        List<String> ans = new LinkedList<>();
        while(ans.size() < 3 && !queue.isEmpty()) {
            ans.add(queue.poll().term);
        }
        return ans;
    }

    public static void main(String[] args) {
        AutocompleteSystem acs = new AutocompleteSystem(
                new String[]{"i love you", "island", "ironman", "i love leetcode"},
                new int[]{5, 3, 2, 2}
        );

        System.out.println(acs.input('i'));
        System.out.println(acs.input(' '));
        System.out.println(acs.input('a'));
        System.out.println(acs.input('#'));

        System.out.println(acs.input('i'));
        System.out.println(acs.input(' '));
        System.out.println(acs.input('a'));
        System.out.println(acs.input('#'));

        System.out.println(acs.input('i'));
        System.out.println(acs.input(' '));
        System.out.println(acs.input('a'));
        System.out.println(acs.input('#'));

    }
}
