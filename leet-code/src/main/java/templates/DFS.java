package templates;

import java.util.*;

public class DFS {
    int GREY = 1;
    int WHITE = 0;
    int BLACK = 2;

    public void topoIterative(int numOfVertex, Set<Integer>[] adjList) {
        int[] color = new int[numOfVertex];

        Deque<Integer> stack = new LinkedList<>();

        stack.push(0);
        color[0] = GREY;

        List<Integer> result = new LinkedList<>();
        while (!stack.isEmpty()) {
            int current = stack.pop();

            boolean processed = true;
            for (Integer neighbor : adjList[current]) {
                if (color[neighbor] != BLACK) {
                    processed = false;
                    break;
                }
            }
            //delay the check for result to make sure all child dependencies are met
            if (processed) {
                color[current] = BLACK;
                result.add(current);
            } else {
                stack.push(current);
            }

            for (Integer neighbor : adjList[current]) {
                if (color[neighbor] == WHITE) {
                    stack.push(neighbor);
                    color[neighbor] = GREY;
                } else if (color[neighbor] == GREY) {
                    //circle detected
                } else {
                    //neighbor has been visited
                }
            }
        }
        //result keeps reverse topological order
        Collections.reverse(result);

        System.out.println(result);
    }

    public void dfsIterative(int numOfVertex, Set<Integer>[] adjList) {
        int[] color = new int[numOfVertex];

        Deque<Integer> stack = new LinkedList<>();

        stack.push(0);
        color[0] = GREY;

        List<Integer> result = new LinkedList<>();
        while (!stack.isEmpty()) {
            int current = stack.pop();

            for (Integer neighbor : adjList[current]) {
                if (color[neighbor] == WHITE) {
                    stack.push(neighbor);
                    color[neighbor] = GREY;
                } else if (color[neighbor] == GREY) {
                    //circle detected
                } else {
                    //neighbor has been visited
                }
            }
            color[current] = BLACK;
            result.add(current);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        DFS solution = new DFS();

        Set<Integer>[] graph = new Set[5];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new HashSet<>();
        }

        graph[0].add(1);
        graph[0].add(2);
        graph[1].add(2);
        graph[2].add(3);
        graph[2].add(4);
        graph[3].add(4);

        solution.dfsIterative(5,
                graph);

        solution.topoIterative(5,
                graph);
    }
}
