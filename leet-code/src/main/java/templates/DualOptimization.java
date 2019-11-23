package templates;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Select K element from N objects. Each object has two dimensions, d1, d2.
 * The objective function is in the form of  f(d1...) +/* g(d2...)
 * if f is min/max, we use heap to maintain current best K in d1
 * if g is sum/count, we use a single variable in d2
 */
public class DualOptimization {

    public double daulOpt(int[] dim1, int[] dim2, int k) {
        //sort by one dimension
        //scan another while keep the best k

        Point[] points = new Point[dim1.length];
        for(int i = 0 ; i < points.length; i++) {
            points[i] = new Point(dim1[i], dim2[i]);
        }

        //d1 or d2 does not matter
        Arrays.sort(points, Comparator.comparing(point -> point.d1));

        int best = 0;
        //queue maintains on another dimension
        PriorityQueue<Point> queue = new PriorityQueue<>(k, Comparator.comparing(point -> point.d2));

        int currentG = 0;
        int currentScore = 0;

        for(Point point : points) {
            if(queue.size() < k) {
                queue.add(point);
                //maintain function g
                currentG += point.d2;
                //evaluate
                currentScore = queue.peek().d1 * currentG;
            } else {
                Point worst = queue.poll();
                queue.add(point);
                currentG = currentG - worst.d2 + point.d2;
                int newScore = queue.peek().d1 * currentG;
                if(newScore < currentG){
                    currentG = newScore;
                }
            }
        }
        return currentScore;
    }

    class Point {
        int d1;
        int d2;

        public Point(int d1, int d2) {
            this.d1 = d1;
            this.d2 = d2;
        }

        @Override
        public String toString() {
            return String.format("[%d,%d]", d1, d2);
        }
    }
}
