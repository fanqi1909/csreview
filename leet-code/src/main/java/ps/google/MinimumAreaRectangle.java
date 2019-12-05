package ps.google;

import java.util.*;

/**
 * Enumerate all sides of the vertical lines, in decreasing order, update the min-area seen so far.
 */
public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<String, Integer> allRec = new HashMap<>();

        TreeMap<Integer, List<int[]>> clusters = new TreeMap<>();

        for(int i = 0; i < points.length; i++) {
            List<int[]> cluster = clusters.getOrDefault(points[i][0], new ArrayList<>());
            cluster.add(points[i]);
            clusters.put(points[i][0], cluster);
        }
        if(clusters.size() < 2) {
            return 0; // all points are in the same vertical line
        }

        int minArea = Integer.MAX_VALUE;
        for(int key : clusters.descendingKeySet()) {
            List<int[]> cluster = clusters.get(key);

            cluster.sort(Comparator.comparingInt(o -> o[1]));

            for(int i = 0, len = cluster.size(); i < len; i++) {
                int[] p1 = cluster.get(i);
                for(int j = i + 1; j < len; j++) {
                    int[] p2 = cluster.get(j);
                    String side = Math.min(p1[1], p2[1]) + "," + Math.max(p1[1], p2[1]);
                    int sideLen = Math.abs(p2[1] - p1[1]);
                    if(sideLen > minArea) {
                        break;// move to the next point
                    }
                    if(allRec.containsKey(side)) {
                        int lastX = allRec.get(side);
                        minArea = Math.min(minArea, (lastX - key) * sideLen);
                    }
                    allRec.put(side, key);
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

    public static void main(String[] args) {
        MinimumAreaRectangle mar = new MinimumAreaRectangle();

        System.out.println(mar.minAreaRect(new int[][]{
                new int[]{1,1},
                new int[]{1,3},
                new int[]{3,1},
                new int[]{3,3},
                new int[]{2,2}
        }));

        System.out.println(mar.minAreaRect(new int[][]{
                new int[]{1,1},
                new int[]{1,3},
                new int[]{3,1},
                new int[]{3,3},
                new int[]{4,1},
                new int[]{4,3}
        }));

        System.out.println(mar.minAreaRect(new int[][]{
                new int[]{3,2},
                new int[]{3,1},
                new int[]{4,4},
                new int[]{1,1},
                new int[]{4,3},
                new int[]{0,3},
                new int[]{0,2},
                new int[]{4,0}
        }));
    }
}
