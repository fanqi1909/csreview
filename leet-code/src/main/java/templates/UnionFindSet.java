package templates;

import java.util.Arrays;

public class UnionFindSet {
    static class UnionFind {
        int[] parent;
        int[] rank; // the height of the parent tree

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < parent.length ;i++ ){
                parent[i] = i; //self set
            }
            Arrays.fill(rank, 0);
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
    }
    public static void main(String[] args) {
        int ans = 5;
        while(ans > 0) {
            System.out.println(Integer.toBinaryString(-ans & ans));
            ans = ans & ( ~ (-ans & ans));
        }
    }
}
