package ps.google.array.string.heap;

import org.jace.cs.review.lc.dp.Util;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        if(K <=0) return new int[0][];
        PriorityQueue<int[]> queue = new PriorityQueue<>(K, Comparator.comparingDouble(a -> -Math.sqrt(((long) a[0]) * ((long) a[0]) + ((long) a[1]) * ((long) a[1]))));
        for(int[] point : points) {
            queue.add(point);
            if(queue.size() > K) {
                queue.poll();
            }
        }
        int[][] ans = new int[queue.size()][];
        int next = 0;
        while(!queue.isEmpty()) {
            ans[next++] = queue.poll();
        }
        return ans;
    }

    public static void main(String[] args) {

        KClosestPointsToOrigin solution = new KClosestPointsToOrigin();

        Util.print2DArray(solution.kClosest(new int[][]{
                new int[]{3, 3},
                new int[]{5, -1},
                new int[]{-2, 2}
        }, 1));

        Util.print2DArray(solution.kClosest(new int[][]{
                new int[]{3, 3},
                new int[]{5, -1},
                new int[]{-2, 2}
        }, 2));

        Util.print2DArray(solution.kClosest(new int[][]{
                new int[]{1, 3},
                new int[]{-2, 2}
        }, 1));

    }
}
