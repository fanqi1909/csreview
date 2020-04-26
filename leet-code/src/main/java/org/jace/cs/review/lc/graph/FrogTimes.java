package org.jace.cs.review.lc.graph;

import javafx.util.Pair;

import java.util.*;

public class FrogTimes {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (edges.length == 0) {
            return 1.0;
        }
        double[][] dp = new double[n][t + 1];
        dp[0][0] = 1.0;

        Set<Integer>[] neighbors = new Set[n];

        for (int i = 0; i < edges.length; i++) {
            if (neighbors[edges[i][1] - 1] == null) {
                neighbors[edges[i][1] - 1] = new HashSet<>();
            }
            if (neighbors[edges[i][0] - 1] == null) {
                neighbors[edges[i][0] - 1] = new HashSet<>();
            }
            neighbors[edges[i][1] - 1].add(edges[i][0] - 1);
            neighbors[edges[i][0] - 1].add(edges[i][1] - 1);

        }
        Queue<Pair<Integer, Integer>> current = new LinkedList<>();

        current.add(new Pair<>(0, 0));
        while (!current.isEmpty()) {
            Pair<Integer, Integer> topPair = current.poll();
            if (topPair.getValue() >= t) {
                continue;
            }
            int top = topPair.getKey();
            int time = topPair.getValue();
            double totalProb = dp[top][time];
            //find all unvisited child
            Set<Integer> unvisited = neighbors[top];//= new HashSet<>();
            if (unvisited.size() == 0) {
                Arrays.fill(dp[top], time, t + 1,  totalProb );
            } else {
                double equalShare = totalProb / unvisited.size();
                for (int next : unvisited) {
                    dp[next][time + 1] = equalShare;
                    neighbors[next].remove(top);
                    current.add(new Pair<>(next, time + 1));
                }
            }
        }
        return dp[target - 1][t];
    }

    public static void main(String[] args) {
        FrogTimes q = new FrogTimes();
        System.out.println(q.frogPosition(7, new int[][]{
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{1, 7},
                new int[]{2, 4},
                new int[]{2, 6},
                new int[]{3, 5},
        }, 2, 4));

//        n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7

        System.out.println(q.frogPosition(7, new int[][]{
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{1, 7},
                new int[]{2, 4},
                new int[]{2, 6},
                new int[]{3, 5},
        }, 1, 7));

//        n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 20, target = 6

        System.out.println(q.frogPosition(7, new int[][]{
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{1, 7},
                new int[]{2, 4},
                new int[]{2, 6},
                new int[]{3, 5},
        }, 20, 6));

        System.out.println(q.frogPosition(3, new int[][]{
                new int[]{2, 1},
                new int[]{3, 2}
        }, 1, 2));


    }
}