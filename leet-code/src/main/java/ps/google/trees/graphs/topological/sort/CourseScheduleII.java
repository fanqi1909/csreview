package ps.google.trees.graphs.topological.sort;

import java.util.*;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer>[] inGraph = new Set[numCourses];
        Set<Integer>[] outGraph = new Set[numCourses];
        for (int[] pre : prerequisites) {
            if (inGraph[pre[0]] == null) {
                inGraph[pre[0]] = new HashSet<>();
            }
            inGraph[pre[0]].add(pre[1]);

            if (outGraph[pre[1]] == null) {
                outGraph[pre[1]] = new HashSet<>();
            }
            outGraph[pre[1]].add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inGraph.length; i++) {
            if (inGraph[i] == null || inGraph[i].isEmpty()) {
                queue.add(i);
            }
        }

        int next = 0;
        int[] ans = new int[numCourses];

        while (!queue.isEmpty()) {
            int current = queue.poll();
            Set<Integer> outDegree = outGraph[current];
            if(outDegree != null) {
                for (Integer neighbor : outDegree) {
                    inGraph[neighbor].remove(current);
                    if (inGraph[neighbor].size() == 0) {
                        queue.add(neighbor);
                    }
                }
            }
            ans[next++] = current;
        }
        if (next != numCourses) {
            return new int[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        CourseScheduleII solution = new CourseScheduleII();
        System.out.println(Arrays.toString(solution.findOrder(4, new int[][]{
                new int[]{1, 0},
                new int[]{2, 0},
                new int[]{3, 1},
                new int[]{3, 2}}
        )));

        System.out.println(Arrays.toString(solution.findOrder(2, new int[][]{
                new int[]{1, 0}
                }
        )));

        System.out.println(Arrays.toString(solution.findOrder(5, new int[][]{
                        new int[]{1, 0},
                        new int[]{2, 0},
                new int[]{2, 1},
                new int[]{2, 3},
                new int[]{4, 2},
                new int[]{4, 3},
                new int[]{4, 1},
                }
        )));
    }
}
