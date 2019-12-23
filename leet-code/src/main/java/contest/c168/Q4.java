package contest.c168;

import java.util.LinkedList;
import java.util.Queue;

public class Q4 {

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int sum = 0;
        int n = status.length;
        boolean[] visited = new boolean[n];
        int[] availableKeys = new int[n];
        Queue<Integer> pendingChild = new LinkedList<>();
        for (int box : initialBoxes) {
            pendingChild.add(box);
        }

        boolean changed = true;
        while (!pendingChild.isEmpty() && changed) {
            int size = pendingChild.size();
            changed = false;
            while (size-- > 0) {
                int current = pendingChild.poll();
                if (status[current] == 1 || availableKeys[current] > 0) {
                    changed = true;
                    if (!visited[current]) {
                        sum += candies[current];
                        visited[current] = true;
                    }
                    //update the current status;
                    for (int key : keys[current]) {
                        availableKeys[key]++;
                    }
                    for (int next : containedBoxes[current]) {
                        pendingChild.add(next);
                    }
                } else {
                    //cannot open current box;
                    pendingChild.add(current);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Q4 sol = new Q4();

        System.out.println(sol.maxCandies(
                new int[]{1, 0, 1, 0},
                new int[]{7, 5, 4, 100},
                new int[][]{
                        new int[0],
                        new int[0],
                        new int[]{1},
                        new int[0]
                },
                new int[][]{
                        new int[]{1, 2},
                        new int[]{3},
                        new int[0],
                        new int[0]
                },
                new int[]{0}
        ));

        System.out.println(sol.maxCandies(
                new int[]{1, 0, 0, 0, 0, 0},
                new int[]{1, 1, 1, 1, 1, 1},
                new int[][]{
                        new int[]{1, 2, 3, 4, 5},
                        new int[0],
                        new int[]{},
                        new int[0],
                        new int[0],
                        new int[0],
                },
                new int[][]{
                        new int[]{1, 2, 3, 4, 5},
                        new int[]{},
                        new int[0],
                        new int[0],
                        new int[0],
                        new int[0],
                },
                new int[]{0}
        ));

        System.out.println(sol.maxCandies(
                new int[]{1, 1, 1},
                new int[]{100, 1, 100},
                new int[][]{
                        new int[]{},
                        new int[]{0, 2},
                        new int[]{}
                },
                new int[][]{
                        new int[]{},
                        new int[]{},
                        new int[0],
                },
                new int[]{1}
        ));

        System.out.println(sol.maxCandies(
                new int[]{1},
                new int[]{100},
                new int[][]{
                        new int[]{}
                },
                new int[][]{
                        new int[]{}
                },
                new int[]{}
        ));

        System.out.println(sol.maxCandies(
                new int[]{1, 1, 1},
                new int[]{2, 3, 2},
                new int[][]{
                        new int[]{},
                        new int[]{},
                        new int[]{}
                },
                new int[][]{
                        new int[]{},
                        new int[]{},
                        new int[0],
                },
                new int[]{2, 1, 0}
        ));
    }
}
