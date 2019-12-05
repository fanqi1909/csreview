package ps.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * PQ approach: use a priority queue to fill the allocation array in min-first order. This ensures that the allocation is
 * filled only once.
 *
 * Scan-based approach: for each bottom in the array, (a[i] is bottom if a[i] <= a[i+1] && a[i] <= a[i-1]), we can assign
 * 1 to the bottom. Then we can propagate such assignment to the neighboring peak of a[i], (a[j] is a peak if a[j] >= a[j+1] && a[j] > a[j-1])
 *
 * This can be efficiently done via a two pass-algorithm. In the first pass, we scan all the uphill. In the second pass, we scan
 * all the downhill. (When scanning downhill, we scan reversely, so that the downhill would be uphill)
 *
 */
public class Candy {

    class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int v, int i) {
            this.value = v;
            this.index = i;
        }

        @Override
        public int compareTo(Pair o) {
            return this.value - o.value;
        }
    }

    /**
     * Use priority queue to populate the assignment in minimum order
     *
     * @param ratings
     * @return
     */
    public int candyPQ(int[] ratings) {
        if (ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;
        int[] allocation = new int[ratings.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < ratings.length; i++) {
            pq.add(new Pair(ratings[i], i));
        }
        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            int index = top.index;

            if (index < ratings.length - 1) {
                allocation[index] = ratings[index] > ratings[index + 1] ? allocation[index + 1] + 1 : 1;
            }
            if (index > 0) {
                allocation[index] = ratings[index] > ratings[index - 1] ? Math.max(allocation[index - 1] + 1, allocation[index]) : Math.max(allocation[index], 1);
            }
        }

        System.out.println(Arrays.toString(allocation));
        int sum = 0;
        for (int all : allocation) {
            sum += all;
        }
        return sum;
    }

    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
        int[] allocation = new int[ratings.length];
        allocation[0] = 1;

        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                allocation[i] = allocation[i-1] + 1;
            } else {
                allocation[i] = Math.max(allocation[i], 1);
            }
        }

        for(int i = ratings.length - 2; i >=0; i--) {
            if(ratings[i] > ratings[i+1]) {
                allocation[i] = Math.max(allocation[i+1] + 1, allocation[i]);
            } else {
                allocation[i] = Math.max(allocation[i], 1);
            }
        }
//        System.out.println(Arrays.toString(allocation));
        int sum = 0;
        for(int all : allocation) {
            sum += all;
        }
        return sum;
    }

    public static void main(String[] arg) {
        Candy candy = new Candy();
        System.out.println(candy.candyPQ(new int[]{1, 0, 2}));
        System.out.println(candy.candy(new int[]{1, 0, 2}));
        System.out.println(candy.candyPQ(new int[]{1, 2, 2}));
        System.out.println(candy.candy(new int[]{1, 2, 2}));
        System.out.println(candy.candyPQ(new int[]{1, 2, 2, 1}));
        System.out.println(candy.candy(new int[]{1, 2, 2, 1}));
        System.out.println(candy.candyPQ(new int[]{1, 2, 3, 2, 1}));
        System.out.println(candy.candy(new int[]{1, 2, 3, 2, 1}));
    }
}
