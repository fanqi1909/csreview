package ps.google.trees.graphs.bfs;

import java.util.*;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Graph graph = new Graph(equations, values);

        double[] answer = new double[queries.size()];
        int next = 0;
        for (List<String> query : queries) {
            answer[next++] = graph.evaluate(query.get(0), query.get(1));
        }
        return answer;
    }

    class Graph {
        Set<String> vertexes;
        Map<String, Map<String, Double>> edges;

        public Graph(List<List<String>> equations, double[] values) {
            vertexes = new HashSet<>();
            edges = new HashMap<>();
            int i = 0;
            for(List<String> input : equations) {
                String source = input.get(0);
                String target = input.get(1);
                vertexes.add(source);
                vertexes.add(target);
                Map<String, Double> inEdges = edges.getOrDefault(source, new HashMap<>());
                inEdges.put(target, values[i]);
                edges.put(source, inEdges);
                if (values[i] != 0.0) {
                    Map<String, Double> outEdges = edges.getOrDefault(target, new HashMap<>());
                    outEdges.put(source, 1 / values[i]);
                    edges.put(target, outEdges);
                }
                i++;
            }
        }


        public double evaluate(String source, String target) {
            if (!vertexes.contains(source) || !vertexes.contains(target)) {
                return -1.0;
            }
            Map<String, String> parent = new HashMap<>();
            Set<String> visited = new HashSet<>();
            Deque<String> stack = new LinkedList<>();
            stack.push(source);
            while (!stack.isEmpty()) {
                String top = stack.pop();
                if (top.equals(target)) break;

                if (!visited.contains(top)) {
                    Map<String, Double> outEdges = edges.get(top);
                    for (String key : outEdges.keySet()) {
                        if (!visited.contains(key)) {
                            stack.push(key);
                            parent.put(key, top);
                        }
                    }
                    visited.add(top);
                }
            }

            String tmp = target;
            double ans = 1.0;
            while(!tmp.equals(source)) {
                if(parent.containsKey(tmp)) {
                    String p = parent.get(tmp);
                    ans = ans * edges.get(p).get(tmp);
                    tmp = p;
                } else {
                    return -1.0;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        EvaluateDivision solution = new EvaluateDivision();

        List<List<String>> equations = new LinkedList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        equations.add(Arrays.asList("bc", "cd"));

        double[] values = new double[]{1.5, 2.5, 5.0};

        List<List<String>> queries = new LinkedList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("c", "b"));
        queries.add(Arrays.asList("bc", "cd"));
        queries.add(Arrays.asList("cd", "bc"));

        System.out.println(Arrays.toString(solution.calcEquation(equations, values, queries)));


        equations = new LinkedList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("c", "d"));

        values = new double[]{1.0, 1.0};

        queries = new LinkedList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "d"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("d", "c"));
        System.out.println(Arrays.toString(solution.calcEquation(equations, values, queries)));
    }
}
