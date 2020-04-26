package contest.c173;

import java.util.Arrays;

public class Q2 {

    int[] parent;
    int[] rank; // the height of the parent tree

    public int find(int i) { // path compression
        if (parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
    }

    public boolean union(int x, int y) { // union with rank
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
            return true;
        } else {
            return false;
        }
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < parent.length ;i++ ){
            parent[i] = i; //self set
        }
        Arrays.fill(rank, 0);

        for(int i = 0; i < n; i ++) {
            if(leftChild[i] != -1) {
                if(!union(i, leftChild[i])) {
                    return false;
                }
            }
            if(rightChild[i] != -1) {
                if(!union(i, rightChild[i])) {
                    return false;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(parent[i] == i) {
                count++;
            }
            if(count > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q2 q2 = new Q2();

        System.out.println(q2.validateBinaryTreeNodes(6, new int[]{1,-1,-1,4,-1,-1}, new int[]{2,-1,-1,5,-1,-1}));
    }

}
