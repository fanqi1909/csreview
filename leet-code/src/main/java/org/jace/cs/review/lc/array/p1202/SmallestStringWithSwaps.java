package org.jace.cs.review.lc.array.p1202;

import java.util.*;

public class SmallestStringWithSwaps {

    int[] parent;
    int[] rank; // the height of the parent tree

    public int find(int i) { // path compression
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int x, int y) { // union with rank
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx;
                rank[rootx] += 1;
            }
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i; //self set
        }
        Arrays.fill(rank, 0);
        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }

        Map<Integer, List<Integer>> components = new HashMap<>();

        for (int i = 0; i < n; i++) {
            components.computeIfAbsent(find(parent[i]), k -> new ArrayList<>()).add(i);
        }

        char[] schar = s.toCharArray();

        for (Integer key : components.keySet()) {
            organize(schar, components.get(key));
        }

        return new String(schar);
    }

    private void organize(char[] schar, List<Integer> integers) {
        List<Character> mappedChars = new ArrayList<>();
        for (int index : integers) {
            mappedChars.add(schar[index]);
        }
        Collections.sort(integers);
        Collections.sort(mappedChars);
        for (int i = 0; i < integers.size(); i++) {
            schar[integers.get(i)] = mappedChars.get(i);
        }
    }

    public static void main(String[] args) {
        SmallestStringWithSwaps small = new SmallestStringWithSwaps();

        System.out.println(small.smallestStringWithSwaps("dcab", Arrays.asList(
                Arrays.asList(0, 3),
                Arrays.asList(1, 2)
        )));

        System.out.println(small.smallestStringWithSwaps("dcab", Arrays.asList(
                Arrays.asList(0, 3),
                Arrays.asList(1, 2),
                Arrays.asList(0, 2)
        )));

        System.out.println(small.smallestStringWithSwaps("cba", Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2)
        )));
    }
}
