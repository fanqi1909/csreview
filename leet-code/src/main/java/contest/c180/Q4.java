package contest.c180;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q4 {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = (int) (1e9 + 7);
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; ++i)
            engineers[i] = new int[]{efficiency[i], speed[i]};

        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        long res = Long.MIN_VALUE, totalSpeed = 0;

        for (int[] engineer : engineers) {
            if (pq.size() == k) totalSpeed -= pq.poll();  // layoff the one with min speed
            pq.add(engineer[1]);
            totalSpeed = (totalSpeed + engineer[1]);
            res = Math.max(res, (totalSpeed * engineer[0]));  // min efficiency is the efficiency of new engineer
        }

        return (int) (res % MOD);
    }

    public int maxPerformance2(int n, int[] speed, int[] efficiency, int k) {
        int MOD = (int) (1e9 + 7);
        Pair<Integer, Integer>[] points = new Pair[n];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Pair<>(speed[i], efficiency[i]);
        }

        Arrays.sort(points, Comparator.comparing(pair -> -pair.getValue()));

        //queue maintains the additive dimension
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(k, Comparator.comparing(pair -> pair.getKey())); // speed

        long currentSpeed = 0;
        long currentScore = 0;

        for (Pair<Integer, Integer> point : points) {
            if (queue.size() == k) {
                currentSpeed -= queue.poll().getKey();
            }
            queue.add(point);
            currentSpeed = currentSpeed + point.getKey();

            long newScore = point.getValue() * currentSpeed;

            if (newScore > currentScore) {
                currentScore = newScore;
            }
        }
        return (int) (currentScore % MOD);
    }

    static class Test {
        int a;
        int[] speed;
        int[] efficiency;
        int k;

        Test(int n, int[] s, int[] e, int k) {
            a = n;
            speed = s;
            efficiency = e;
            this.k = k;
        }
    }


    public static void main(String[] args) {
        Q4 sol = new Q4();
        Test[] tests = new Test[]{
                new Test(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 2),
                new Test(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 3),
                new Test(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 4),
                new Test(3, new int[]{2, 8, 2}, new int[]{2, 7, 1}, 2),
                new Test(7, new int[]{1, 4, 1, 9, 4, 4, 4}, new int[]{8, 2, 1, 7, 1, 8, 4}, 6)
        };

        for (final Test test : tests) {
            System.out.printf("%d == %d\n", sol.maxPerformance(test.a, test.speed, test.efficiency, test.k),
                    sol.maxPerformance2(test.a, test.speed, test.efficiency, test.k));
        }
    }
}
