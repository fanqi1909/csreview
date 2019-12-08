package org.jace.cs.review.lc.graph;

import java.util.*;

/**
 * Direct Tarjan's Algorithm.
 * When low[v] > disc[u], it would be a cut between SCC
 */
public class CriticalConnection {
    private int depth = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //disc[i] is the node's depth in a DFS tree
        int[] disc = new int[n];
        Arrays.fill(disc, -1);
        //low[i] is the node's all reachable node's smallest depth in a DFS tree
        int[] low = new int[n];
        //Create the graph;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> connection : connections) {
            int from = connection.get(0);
            int to = connection.get(1);
            graph[from].add(to);
            graph[to].add(from);
        }
        //Create the result;
        List<List<Integer>> ans = new ArrayList<>();
        //DFS for each node
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                tarjan(i, disc, low, graph, ans, i);
            }
        }
        return ans;
    }

    private void tarjan(int start, int[] disc, int[] low, List<Integer>[] graph, List<List<Integer>> result, int parent) {
        depth++;
        disc[start] = depth;
        low[start] = depth;
        List<Integer> children = graph[start];
        for (int v : children) {
            if (v == parent) {
                //to handle undirected graph
                continue;
            } else {
                if (disc[v] == -1) {
                    tarjan(v, disc, low, graph, result, start);
                    low[start] = Math.min(low[start], low[v]);
                    if (low[v] > disc[start]) {
                        result.add(Arrays.asList(start, v));
                    }
                } else {
                    low[start] = Math.min(low[start], low[v]);
                }
            }
        }
    }

    public static void main(String[] args) {
        CriticalConnection cc = new CriticalConnection();

        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(2, 0),
                Arrays.asList(1, 3)
        );


        System.out.println(cc.criticalConnections(4, edges));


        edges = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(1, 6),
                Arrays.asList(2, 1),
                Arrays.asList(2, 4),
                Arrays.asList(3, 5),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );

        System.out.println(cc.criticalConnections(7, edges));


        edges = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(0, 3),
                Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(3, 4),
                Arrays.asList(4, 5),
                Arrays.asList(4, 7),
                Arrays.asList(5, 6),
                Arrays.asList(6, 7)
        );
        System.out.println(cc.criticalConnections(8, edges));

    }
}
