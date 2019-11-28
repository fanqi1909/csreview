package templates;

import javafx.util.Pair;

import java.util.*;

public class EulerCircle {

    public List<String> eulerCircle(Graph graph) {

        //starting from one vertex, and perform dfs
        String start = graph.vertexes.iterator().next();
        List<String> result = dfs(graph, start, new HashSet<>());
        return result;
    }

    /**
     * DFS returns the greedily explored path until it stuck.
     *
     * Suppose a first node "u" is traversing to node "v", and "u" "v" are in the same circle.
     * i.e., "v" is the start for the current dfs.
     *
     * when LINE 1 returns, there are two cases which form a valid Euler Circle:
     *  1. LINE 1 return a path pointing back to "u".
     *  2. LINE 1 return a path pointing back to "v".
     *
     * If Line 1 return a path pointing to anything else, there won't be an euler path for all nodes in the graph.
     *
     * Also, among all paths that returned by LINE 1, there would only be 1 path pointing to the origin "u".
     * That path needs to be stay in the first of the result.
     *
     * Another notice is that the result pointing to "u" would always be the first to be returned by DFS.
     * Therefore we can greedily place all stucked path in the top of the result. This are implemented in LINE 2 and LINE 3.
     *
     */
    private List<String> dfs(Graph graph, String start, HashSet<String> seenEdges) {
        Set<Pair<String, String>> outEdges = graph.outList.get(start);
        List<String> results = new LinkedList<>();
        for (Pair<String, String> edge : outEdges) {
            String signature = start + "->" + edge.getValue();
            if (!seenEdges.contains(signature)) {
                seenEdges.add(signature);
                List<String> stuck = dfs(graph,  edge.getKey(), seenEdges); //LINE 1, first result stucked at its parent, second result onwards stuck at "start"
                results.addAll(0, stuck);  //LINE 2
                results.add(0, signature + "->" + edge.getKey()); // LINE 3
            }
        }
        return results;
    }

    public static void main(String[] args) {
        List<String[]> edgeList = Arrays.asList(
                new String[]{"A", "A", "0"},
                new String[]{"A", "B", "1"},
                new String[]{"B", "C", "0"},
                new String[]{"B", "D", "1"},
                new String[]{"C", "A", "0"},
                new String[]{"C", "B", "1"},
                new String[]{"D", "D", "1"},
                new String[]{"D", "C", "0"}
        );

        Graph graph = new Graph(edgeList);
        EulerCircle eulerCircle = new EulerCircle();

        System.out.println(eulerCircle.eulerCircle(graph));

        List<String[]> edgeList2 = Arrays.asList(
                new String[]{"A", "B", "1"},
                new String[]{"B", "C", "2"},
                new String[]{"C", "A", "3"},
                new String[]{"B", "D", "4"},
                new String[]{"D", "E", "5"},
                new String[]{"E", "B", "6"}

        );

        Graph graph2 = new Graph(edgeList2);
        System.out.println(eulerCircle.eulerCircle(graph2));


        List<String[]> edgeList3 = Arrays.asList(
                new String[]{"A", "B", "1"},
                new String[]{"B", "D", "2"},
                new String[]{"D", "E", "3"},
                new String[]{"E", "A", "4"},
                new String[]{"A", "C", "5"},
                new String[]{"C", "D", "6"},
                new String[]{"D", "F", "7"},
                new String[]{"F", "A", "8"}

        );

        Graph graph3 = new Graph(edgeList3);
        System.out.println(eulerCircle.eulerCircle(graph3));

    }

}

class Graph {

    Map<String, Set<Pair<String, String>>> outList;
    Map<String, Set<Pair<String, String>>> inList;
    Set<String> vertexes;

    public Graph(List<String[]> edgeList) {
        outList = new HashMap<>();
        inList = new HashMap<>();
        vertexes = new HashSet<>();

        for (String[] edge : edgeList) {
            String src = edge[0];
            String target = edge[1];
            String label = edge[2];
            vertexes.add(src);
            vertexes.add(target);
            if (!outList.containsKey(src)) {
                outList.put(src, new HashSet<>());
            }
            if (!inList.containsKey(target)) {
                inList.put(target, new HashSet<>());
            }

            outList.get(src).add(new Pair<>(target, label));
            inList.get(target).add(new Pair<>(src, label));
        }
    }
}
