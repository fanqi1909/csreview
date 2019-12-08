package contest.c166;

import org.jace.cs.review.lc.dp.Util;

import java.util.*;

public class P4 {

    public int minFlips(int[][] mat) {
        boolean[] visited = new boolean[512];
        int[] distance = new int[512];
        int len = mat.length;
        int wide = mat[0].length;

        Arrays.fill(distance, -1);
        int s = sign(mat);

        Queue<Integer> queue = new LinkedList<>();

        queue.add(s);
        distance[s] = 0;

        while (!queue.isEmpty()) {
            int source = queue.poll();
            if (source == 0) {
                break;
            }
            for (int next : generateNext(source, len, wide)) {
                if (!visited[next]) {
                    distance[next] = distance[source] + 1;
                    queue.add(next);
                }
            }
            visited[source] = true;
        }

        return distance[0];
    }

    private List<Integer> generateNext(int source, int len, int wide) {
        List<Integer> ans = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wide; j++) {
                int[][] mat = unsign(source, len, wide);
                ans.add(set(mat, i, j));
            }
        }
        return ans;
    }

    private Integer set(int[][] mat, int i, int j) {
        mat[i][j] = 1 - mat[i][j];

        if(i > 0) {
            mat[i-1][j] = 1 - mat[i-1][j];
        }
        if(i < mat.length - 1) {
            mat[i+1][j] = 1 - mat[i+1][j];
        }
        if(j > 0) {
            mat[i][j-1] = 1 - mat[i][j-1];
        }
        if(j < mat[0].length - 1) {
            mat[i][j+1] = 1 - mat[i][j+1];
        }
        return sign(mat);
    }

    private int[][] unsign(int source, int len, int wide) {
        int[][] mat = new int[len][wide];
        int nextBit = 1 << (len * wide - 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wide; j++) {
                mat[i][j] = (source & nextBit) == 0 ? 0 : 1;
                nextBit = nextBit >> 1;
            }
        }
        return mat;
    }


    private int sign(int[][] mat) {
        int sign = 0;
        int nextBit = 1 << (mat.length * mat[0].length - 1);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    sign = sign | nextBit;
                }
                nextBit = nextBit >> 1;
            }
        }
        return sign;
    }

    public static void main(String[] args) {
        P4 solution = new P4();

        System.out.println(
                solution.minFlips(new int[][]{
                        new int[]{0, 0},
                        new int[]{0, 1},
                })
        );

        System.out.println(
                solution.minFlips(new int[][]{
                        new int[]{0}
                })
        );

        System.out.println(
                solution.minFlips(new int[][]{
                        new int[]{1, 1, 1},
                        new int[]{1, 0, 1},
                        new int[]{0, 0, 0},
                })
        );


        System.out.println(
                solution.minFlips(new int[][]{
                        new int[]{1, 0, 0},
                        new int[]{1, 0, 0}
                })
        );
    }
}
