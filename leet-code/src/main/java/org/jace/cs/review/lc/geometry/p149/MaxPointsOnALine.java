package org.jace.cs.review.lc.geometry.p149;

import java.util.*;

/**
 * Find all point pairs, and count based on the line feature: slope + segment.
 */
public class MaxPointsOnALine {

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Point) {
                Point another = (Point) o;
                return x == another.x && y == another.y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return x * 57 + y * 139;
        }

        @Override
        public String toString() {
            return String.format("[%d,%d]", x, y);
        }
    }

    public int maxPoints(int[][] points) {
        if (points.length == 0) return 0;
        if (points.length == 1) return 1;

        Map<Point, Integer> pointCount = new HashMap<>();
        for(int[] point : points) {
            Point p = new Point(point[0], point[1]);
            pointCount.put(p, pointCount.getOrDefault(p, 0) + 1);
        }

        List<Point> distinct = new ArrayList<>(pointCount.keySet());

        Map<String, Set<Point>> lineCount = new HashMap<>();

        int len = distinct.size();

        if(len == 1) {
            return pointCount.get(distinct.get(0));
        }

        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                String signature = lineSignature(distinct.get(i), distinct.get(j));
                Set<Point> linePoints = lineCount.getOrDefault(signature, new HashSet<>());
                linePoints.add(distinct.get(i));
                linePoints.add(distinct.get(j));
                lineCount.put(signature, linePoints);
            }
        }

        int max = 0;

        for(Map.Entry<String, Set<Point>> signs : lineCount.entrySet()) {
            int totalCount = 0;
            for(Point p : signs.getValue()) {
                totalCount += pointCount.get(p);
            }
            max = Math.max(max, totalCount);
        }
        return max;
    }

    private String lineSignature(Point point, Point point1) {
        String result;
        if (point.x == point1.x) {
            result = String.format("inf,%d", point.x);
        } else if (point.y == point1.y) {
            result = String.format("0,%d", point.y);
        } else {
            int xDiff = point.x - point1.x;
            int yDiff = point.y - point1.y;

            int bu = point.y * xDiff - point.x * yDiff;

            int gcdt = gcd(xDiff, yDiff);
            int gcdi = gcd(bu, xDiff);
            result = String.format("[%d,%d],[%d,%d]", xDiff / gcdt, yDiff / gcdt, bu / gcdi, xDiff / gcdi);
        }
        return result;
    }

    private int gcd(int a, int b) {
        return (a % b == 0) ? b : gcd(b, a % b);
    }

    public static void main(String[] args) {
        MaxPointsOnALine solution = new MaxPointsOnALine();

        System.out.println(solution.maxPoints(new int[][]{
                new int[]{0, 0},
                new int[]{1, 1},
                new int[]{0, 0}
        }));

        System.out.println(solution.maxPoints(new int[][]{
                new int[]{0, 0},
                new int[]{0, 0}
        }));

        System.out.println(solution.maxPoints(new int[][]{
                new int[]{1, 1},
                new int[]{2, 2},
                new int[]{3, 3}
        }));

        System.out.println(solution.maxPoints(new int[][]{
                new int[]{1, 1},
                new int[]{3, 2},
                new int[]{5, 3},
                new int[]{4, 1},
                new int[]{2, 3},
                new int[]{1, 4},
        }));
    }
}
