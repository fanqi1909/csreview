package cn;

import java.util.*;

public class ConvexSet {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] points = new int[n][2];
        for(int i = 0; i < n; i++) {
            points[i][0] = scan.nextInt();
            points[i][1] = scan.nextInt();
        }

        List<int[]> convex = findConvex(points);
        for(int[] c : convex) {
            System.out.println(c[0] + " "  + c[1]);
        }
    }

    private static List<int[]> findConvex(int[][] points) {
        Arrays.sort(points, (p1, p2) -> {
            if(p1[0] == p2[0]) {
                return p2[1] - p1[1];
            } else {
                return p1[0] - p2[0];
            }
        });
        List<int[]> ans = new LinkedList<>();
        int maxY = Integer.MIN_VALUE;
        for(int i = points.length - 1; i >=0; i--) {
            if(points[i][1] >= maxY) {
                ans.add(0, points[i]);
                maxY = points[i][1];
            }
        }
        return ans;
    }
}
