package ps.google.trees.graphs.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * A bit complex. But largely it contains two steps
 * 1. Create a graph from the word list. This takes O(N^2)
 * 2. BFS in the graph to find the shortest path.
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        String[] words = wordList.toArray(new String[0]);
        List<Integer>[] graph = new List[words.length];
        int target = -1;
        for (int i = 0; i < words.length; i++) {
            if (graph[i] == null) {
                graph[i] = new LinkedList<>();
            }
            String word = words[i];
            for (int j = 0; j < wordList.size(); j++) {
                if (i != j) {
                    if (dist(words[i], words[j]) == 1) {
                        graph[i].add(j);
                    }
                }
            }
            if(word.equalsIgnoreCase(endWord)) {
                target = i;
            }
            System.out.println(word + "\t" + graph[i].stream().map(j->words[j]).collect(Collectors.toList()));
        }
        if(target < 0) {
            return 0;
        }


        int[] parent = new int[words.length];
        Arrays.fill(parent, -2);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {
            if (dist(words[i], beginWord) == 1) {
                queue.add(i);
                parent[i] = -1;
            }
        }

        System.out.println(queue);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if(current == target) {
                break;
            }
            for (int wordIndex : graph[current]) {
                if (parent[wordIndex] == -2) {
                    parent[wordIndex] = current;
                    queue.add(wordIndex);
                }
            }
        }

        int hop = 0;
        System.out.println(Arrays.toString(parent));
        if(parent[target] == -2) {
            return 0;
        }

        while(parent[target] != -1 && parent[target] != -2) {
            target = parent[target];
            hop++;
        }

        return hop + 2;
    }

    private int dist(String word, String word1) {
        int diff = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word1.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }


    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));

        System.out.println(solution.ladderLength("hit", "hog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));

        System.out.println(solution.ladderLength("hot", "dog", Arrays.asList("hot", "dog")));
    }
}
