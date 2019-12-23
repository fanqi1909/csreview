package ps.google.trees.graphs.bfs;

import java.util.*;

public class StoneRemoval {
    private int[] parent;
    private int[] rank; // the height of the parent tree

    public int find(int i) { // path compression
        if (parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
    }

    public void union(int x, int y) { // union with rank
        int rootx = find(x);
        int rooty = find(y);
        // rank compression
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

    public int removeStones(int[][] stones) {

        int n = stones.length;
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i; //self set
        }
        Arrays.fill(rank, 0);

        Map<Integer, Integer> pointsX = new HashMap<>();
        Map<Integer, Integer> pointsY = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            pointsX.putIfAbsent(stones[i][0], i);
            pointsY.putIfAbsent(stones[i][1], i);
            union(i, pointsX.get(stones[i][0]));
            union(i, pointsY.get(stones[i][1]));
        }

        Map<Integer, List<Integer>> groups = new HashMap<>();
        for(int i = 0; i < parent.length; i++) {
            groups.computeIfAbsent(find(i), k -> new LinkedList<>()).add(i);
        }

        int count = 0;
        for(List<Integer> group : groups.values()) {
            count += group.size() - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        StoneRemoval sr = new StoneRemoval();
        System.out.println(sr.removeStones(new int[][]{
                new int[]{0,0},
                new int[]{0,1},
                new int[]{1,0},
                new int[]{1,2},
                new int[]{2,1},
                new int[]{2,2}
        }));

        System.out.println(sr.removeStones(new int[][]{
                new int[]{0,0},
                new int[]{0,2},
                new int[]{1,1},
                new int[]{2,0},
                new int[]{2,2}
        }));


        System.out.println(sr.removeStones(new int[][]{
                new int[]{0,0}
        }));

        System.out.println(sr.removeStones(new int[][]{
                new int[]{1,0},
                new int[]{0,1}
        }));
    }

}
