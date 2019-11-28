package ps.google.trees.graphs.euler.circle;

import java.util.HashSet;
import java.util.Set;

/**
 * This is problem can be modeled as finding Euler Circle in a directed graph.
 * <p>
 * Let s1, ..., s_(k^(n-1)) be the size(n-1) prefixes of all possible password sequences, e.g.
 * for n = 3, k = 2, we have
 * 00, 01, 10, 11
 * <p>
 * s_i connects to s_j if the (n-2) suffix of s_i is the (n-2) prefix of s_j. e.g., for n = 3, k =2, we have
 * 00 -> 1 -> 01,  00 -> 0 -> 00,
 * 01 -> 0 > 10,   01 -> 1 -> 11,
 * 10 -> 0 -> 00,  10 ->1 -> 01,
 * 11 -> 0 -> 10, 11 -> 1 -> 11.
 * This forms a graph with 4 (k^(n-1)) vertexes and 8 (k^n) edges.
 * <p>
 * Each possible password can be uniquely mapped to each edge, and vice versa.
 * For example, password 010 can be mapped to the edge 01 -> 0 -> 10.
 * And edge 01->1 ->11 represents password 011
 * <p>
 * So the problem is to find a circle that traverse all edges in the graph. This is Euler Circle.
 * <p>
 * The existence of such circle is based on :
 * 1. All v in the graph are connected
 * 2. Indegree(v) = Outdegree(v) for all v
 */
public class CrackingSafe {


    public String crackSafe(int n, int k) {
        if (n == 1 && k == 1) return "0";
        Set<String> seen = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; ++i) {
            sb.append("0");
        }
        String start = sb.toString();

        String ans =  dfs(start, k, seen).append(start).toString();
        System.out.println(ans + "\n" + "------");
        String ans2 =  dfs2(start, k, new HashSet<>()).append(start).toString();
        System.out.println(ans2 + "\n" + "------");

        return ans;
    }

    public StringBuilder dfs(String node, int degree, Set<String> seen) {
        //every node has x outgoing edges;
        StringBuilder ans = new StringBuilder();
        for (int x = 0; x < degree; ++x) {
            String nextEdge = node + x;
            if (!seen.contains(nextEdge)) {
                seen.add(nextEdge);
                String nextNode = nextEdge.substring(1);
                System.out.println(node + "\t" + nextEdge + "\t" + x + "\t" + nextNode);
                ans.append(dfs(nextNode, degree, seen));
                ans.append(x);
            }
        }
        return ans;
    }

    public StringBuilder dfs2(String node, int degree, Set<String> seen) {
        //every node has x outgoing edges;
        StringBuilder ans = new StringBuilder();
        for (int x = degree - 1; x >= 0; x--) {
            String nextEdge = node + x;
            if (!seen.contains(nextEdge)) {
                seen.add(nextEdge);
                String nextNode = nextEdge.substring(1);
                StringBuilder result = dfs2(nextNode, degree, seen);
                System.out.println(node + "\t" + nextEdge + "\t" + x + "\t" + nextNode + "\t" + result.toString());
                ans.append(result);
                ans.append(x);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        CrackingSafe cs = new CrackingSafe();
        System.out.println(cs.crackSafe(3, 2));
    }
}
