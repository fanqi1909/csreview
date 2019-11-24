package contest.c164;

import java.util.ArrayList;
import java.util.Arrays;

public class P1 {

    public int minTimeToVisitAllPoints(int[][] points) {
        int count = 0;
        for(int i = 1; i < points.length; i++) {
            count += dis(points[i], points[i-1]);
        }
        return count;
    }

    private int dis(int[] px, int[] py) {

        int[] diff = new int[2];
        diff[0] = Math.abs(px[0]-py[0]);
        diff[1] = Math.abs(px[1]-py[1]);

        int dia = 0;
        int baseX = 0; int baseY = 0;
        while(baseX < diff[0] && baseY< diff[1]) {
            baseX++;
            baseY++;
            dia++;
        }
        int remain = 0;
        if(baseX == diff[0]) {
            remain = diff[1] - baseY;
        } else {
            remain = diff[0] - baseX;
        }
//        System.out.println(Arrays.toString(px) + "\t" + Arrays.toString(py) +"\t" + Arrays.toString(diff) + "\t" + (remain) + "\t" + dia);
        return remain + dia;
    }

    public static void main(String[] args) {
        P1 p1 = new P1();
        System.out.println(p1.minTimeToVisitAllPoints(new int[][]{
                new int[]{1,1},
                new int[]{3,4},
                new int[]{-1,0}
        }));

        System.out.println(p1.minTimeToVisitAllPoints(new int[][]{
                new int[]{3,2},
                new int[]{-2,2}
        }));
    }
}
