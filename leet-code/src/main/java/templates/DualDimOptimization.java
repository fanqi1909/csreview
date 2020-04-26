package templates;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Select K element from N objects. Each object has two dimensions, d1, d2.
 * <p>
 * The object function is sum(d1...d1) * min(d2,.., d2)
 * <p>
 * The algorithm is to scan objects from the min dimension, and use priority queue to keep kicking out the
 * worst points in the other dimension
 */
public class DualDimOptimization {

    public long daulOpt(int[] dim1, int[] dim2, int k) {
        Pair<Integer, Integer>[] points = new Pair[dim1.length];

        for (int i = 0; i < points.length; i++) {
            points[i] = new Pair<>(dim1[i], dim2[i]);
        }

        //sort by the min dimension in reverse order
        Arrays.sort(points, Comparator.comparing(point -> -point.getValue()));

        //queue maintains on sum dimension

        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(k, Comparator.comparing(p -> p.getKey())); // this is a min-heap

        return findExactK(queue, points, k);
    }

    private long findMaximumK(PriorityQueue<Pair<Integer, Integer>> queue, Pair<Integer, Integer>[] points, int k) {
        long currentSum = 0;
        long currentMax = 0;
        for(Pair<Integer, Integer> point : points) {
            if(queue.size() == k) {
                currentSum -= queue.poll().getKey();
            }
            queue.add(point);
            currentSum += point.getKey();

            long newScore = point.getValue() * currentSum;
            if (newScore > currentMax) {
                currentMax = newScore;
            }
        }
        return currentMax;
    }


    private long findExactK(PriorityQueue<Pair<Integer, Integer>> queue, Pair<Integer, Integer>[] points, int k) {
        long currentSum = 0;
        long currentScore = 0;

        for (Pair<Integer, Integer> point : points) {
            if (queue.size() < k) {
                queue.add(point);
                currentSum += point.getKey();
                currentScore = point.getValue() * currentSum;
            } else {
                currentSum -= queue.poll().getKey(); // the worst points on SUM dimension goes
                queue.add(point);
                currentSum += point.getKey(); //the sum dimension
                long newScore = point.getValue() * currentSum;
                if (newScore > currentScore) {
                //    System.out.println(queue + "\t" + newScore);
                    currentScore = newScore;
                }
            }
        }
        return currentScore;
    }

    public static void main(String[] args) {
        DualDimOptimization sol = new DualDimOptimization();

        System.out.println(sol.daulOpt(new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 2));
        System.out.println(sol.daulOpt(new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 3));
        System.out.println(sol.daulOpt(new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 4));
        System.out.println(sol.daulOpt(new int[]{2, 8, 2}, new int[]{2, 7, 1}, 2));
        System.out.println(sol.daulOpt(new int[]{1, 4, 1, 9, 4, 4, 4}, new int[]{8, 2, 1, 7, 1, 8, 4}, 6));

    }
}
