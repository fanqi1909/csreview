package org.jace.cs.review.lc.search.p336;

import javafx.util.Pair;

import java.util.*;

public class PalindromePairs {

    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        List<Integer> positions;
        int index;

        public TrieNode() {
            children = new TrieNode['z' - 'A' + 1];
            isWord = false;
            index = -1;
            positions = new ArrayList<>(); //positions contains word indexes whose prefixes are palindrome
        }
    }

    public List<List<Integer>> palindromePairsTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            insertRev(words[i], i, root);
        }
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            findFor(words[i], i, ans, root);
        }
        return ans;
    }

    private void findFor(String word, int i, List<List<Integer>> ans, TrieNode root) {
        TrieNode next = root;
        for (int j = 0; j < word.length(); j++) {
            if (next.index != i && next.index >= 0) {
                if (isPal(word, j, word.length() - 1)) {
                    ans.add(Arrays.asList(i, next.index));
                }
            }
            if (next.children[word.charAt(j) - 'A'] == null) {
                return;// no matching
            }
            next = next.children[word.charAt(j) - 'A'];
        }
        for (int pos : next.positions) {
            if (pos != i) {
                ans.add(Arrays.asList(i, pos));
            }
        }
    }

    private boolean isPal(String word, int left, int right) {
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    /**
     * This is the trick used in Trie.
     *
     * We insert word reversely to the Trie, meanwhile, for each node, we maintain the position list, whose children are palindromes.
     *
     * For example, we have a word[1] "sssll", word[2] "aasll", we wil create a trie
     * l -> ()
     * l -> ()
     * s -> (1,2)
     * s -> (1),  a -> (2)
     * s -> (1),  a -> (2)
     *
     * when we matching against "lls", we will traverse to
     *      l -> ()
     *      l -> ()
     *      s -> (1,2)  --- matching till here
     *      s -> (1),  a -> (2)
     *      s -> (1),  a -> (2)
     * Then we now that our "lls" can form a palindrome with "xxxsll". The xxx needs to be palindrome in order to make
     * the whole string as palindrome.
     * This xxx are actually the position list of "s", which is "1,2", i.e., xxx can be "ss" or "aa".
     */
    private void insertRev(String word, int i, TrieNode root) {
        TrieNode next = root;
        for (int j = word.length() - 1; j >= 0; j--) {
            if (isPal(word, 0, j)) {
                next.positions.add(i);
            }
            if (next.children[word.charAt(j) - 'A'] == null) {
                next.children[word.charAt(j) - 'A'] = new TrieNode();
            }
            next = next.children[word.charAt(j) - 'A'];
        }
        next.isWord = true;
        next.index = i;
        next.positions.add(i); // empty string considered as valid palindrome
    }


    // brute force way to concatenate two words
    // a better way is to create a Trie for all words in reverse order
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new LinkedList<>();

        Map<String, Integer> odds = new HashMap<>();
        for (String word : words) {
            odds.put(word, getOdd(word));
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int numOfOnes = odds.get(words[i]) ^ odds.get(words[j]);
                if (numOfOnes == 0 || countOne(numOfOnes) == 1) {
                    if (checkPalindrome(words[i], words[j])) {
                        ans.add(Arrays.asList(i, j));
                    }
                    if (checkPalindrome(words[j], words[i])) {
                        ans.add(Arrays.asList(j, i));
                    }
                }
            }
        }
        return ans;
    }

    private int countOne(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    private Integer getOdd(String word) {
        int set = 0;
        for (char c : word.toCharArray()) {
            set ^= 1 << (c - 'A');
        }
        return set;
    }

    private boolean checkPalindrome(String word, String word1) {
        String con = word + word1;
        int l = 0;
        int r = con.length() - 1;
        while (l < r) {
            if (con.charAt(l) == con.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePairs pp = new PalindromePairs();

        System.out.println(pp.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
        System.out.println(pp.palindromePairsTrie(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));

        System.out.println(pp.palindromePairs(new String[]{"bat", "tab", "cat"}));
        System.out.println(pp.palindromePairsTrie(new String[]{"bat", "tab", "cat"}));

        System.out.println(pp.palindromePairs(new String[]{"aba", ""}));
        System.out.println(pp.palindromePairsTrie(new String[]{"aba", ""}));

        System.out.println(pp.palindromePairs(new String[]{"a", "abc", "aba", ""}));
        System.out.println(pp.palindromePairsTrie(new String[]{"a", "abc", "aba", ""}));
    }
}
