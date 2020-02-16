package contest.c172;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q4 {

    public int minTaps(int n, int[] ranges) {
        Interval[] intvs = new Interval[ranges.length];
        for(int i = 0; i < ranges.length; i++) {
            intvs[i] = new Interval(i- ranges[i], i+ranges[i]);
        }

        Arrays.sort(intvs, (a,b) ->{
            if(a.left != b.left) {
                return a.left - b.left;
            } else {
                return a.right - b.right;
            }
        });
        List<Interval> ans = new LinkedList<>();
//        System.out.println(Arrays.toString(intvs));


        int lb = 0;
        int maxv = 0;
        int beg = 0;
        int count = 0;
        int k;
        boolean flag = false;
        while (lb < n) {
            maxv = 0;
            for(k = beg; k < intvs.length && intvs[k].left <= lb; k++) {
                maxv = Math.max(maxv, intvs[k].right);
            }
            if(maxv > lb) {
                ans.add(intvs[k - 1]);
                count++;
                lb = maxv;
                beg = k;
            } else {
                flag = true;
                break;
            }
        }

        System.out.println(ans);

        if(flag) {
            return -1;
        } else {
            return count;
        }
    }

    class Interval {
        public int left;
        public int right;
        public Interval(int l, int r) {
            this.left = l;
            this.right = r;
        }

        @Override
        public String toString() {
            return String.format("[%d,%d]", left, right);
        }
    }



    public static void main(String[] args) {
        Q4 q = new Q4();
        System.out.println(q.minTaps(5, new int[]{3,4,1,1,0,0}));
        System.out.println(q.minTaps(3, new int[]{0,0,0,0}));
        System.out.println(q.minTaps(7, new int[]{1,2,1,0,2,1,0,1}));
        System.out.println(q.minTaps(8, new int[]{4,0,0,0,0,0,0,0,4}));
        System.out.println(q.minTaps(8, new int[]{4,0,0,0,4,0,0,0,4}));
    }
}
