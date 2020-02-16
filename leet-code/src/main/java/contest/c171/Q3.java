package contest.c171;
import javafx.util.Pair;


import java.util.*;

public class Q3 {
    int[] parent;
    int[] rank; // the height of the parent tree

    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i; //self set
        }
        Arrays.fill(rank, 0);
        int[] edges = new int[n];
        for(int[] edge :connections) {
            union(edge[0], edge[1]);
            edges[edge[0]]++;
            edges[edge[1]]++;
        }

        Map<Integer, Pair<Integer, Integer>> cluster = new HashMap<>();

        for(int i = 0; i < parent.length; i++) {
            int key = find(i);
            Pair<Integer, Integer> c = cluster.getOrDefault(key, new Pair<>(0, 0));
            Pair<Integer, Integer> np = new Pair<>(c.getKey() + 1, c.getValue() + edges[i]);
            cluster.put(key, np);
        }

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
                (o1, o2) -> o2.getValue() - o1.getValue()
        );

        for(int key : cluster.keySet()) {
            Pair<Integer, Integer> o = cluster.get(key);
            pq.add(new Pair<>(key,o.getValue()/2 - o.getKey() + 1));
        }

        int ans = 0;
        while(pq.size() > 1) {
            Pair<Integer, Integer> c1 = pq.poll();
            Pair<Integer, Integer> c2 = pq.poll();
            //check if can merge
            if(c1.getValue() > 0 || c2.getValue() > 0) {
                Pair<Integer, Integer> np = new Pair<>(c1.getKey(), c1.getValue() + c2.getValue() - 1);
                pq.add(np);
                ans++;
            } else {
                pq.add(c1);
                pq.add(c2);
                break;
            }
        }

        if(pq.size() > 1) {
            ans = -1; // impossible
        }

        return ans;
    }

    public int find(int i) { // path compression
        if (parent[i] != i) parent[i] = find(parent[i]);
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

    public static void main(String[] args) {
        Q3 q3 = new Q3();

        System.out.println(q3.makeConnected(4, new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{1, 2}
        }));

        System.out.println(q3.makeConnected(6, new int[][]{
                new int[]{0, 1},
            new int[]{0, 2},
            new int[]{0, 3},
            new int[]{1,2},
            new int[]{1,3}
        }));

        System.out.println(q3.makeConnected(6, new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{0, 3},
                new int[]{1,2}
        }));

        System.out.println(q3.makeConnected(5, new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{3, 4},
                new int[]{2, 3}
        }));
    }
}

