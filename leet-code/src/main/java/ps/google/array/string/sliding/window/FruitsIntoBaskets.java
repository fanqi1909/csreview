package ps.google.array.string.sliding.window;

import java.util.HashMap;

public class FruitsIntoBaskets {
    public int totalFruit(int[] tree) {

        int p1 = 0;
        int p2 = p1 + 1;
        while(p2 < tree.length && tree[p2] == tree[p1]) {
            p2++;
        }
        int amount;
        if(p2 < tree.length) {
            amount = p2 - p1 + 1;
            p1 = p2 -1;
        } else {
            amount = p2 - p1;
            return amount;
        }

        int max = amount;
        for(int i = p2 + 1 ; i < tree.length; i++) {
            if(tree[i] == tree[p1]) {
                p1 = i;
                amount++;
            } else if (tree[i] == tree[p2]) {
                p2 = i;
                amount++;
            } else {
                //cannot pick, stop
                max = Math.max(amount, max);
                p1 = Math.min(p1,p2) + 1;
                p2 = i;
                i = p1;
                amount = 1;
            }
        }

        return Math.max(amount, max);
    }


    // use hashmap to record sliding windows
    public int totalFruit2(int[] tree) {
        int ans = 0, i = 0;
        Counter count = new Counter();
        for (int j = 0; j < tree.length; ++j) {
            count.add(tree[j], 1);
            while (count.size() >= 3) {
                count.add(tree[i], -1);
                if (count.get(tree[i]) == 0)
                    count.remove(tree[i]);
                i++;
            }

            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }

    class Counter extends HashMap<Integer, Integer> {
        public int get(int k) {
            return containsKey(k) ? super.get(k) : 0;
        }

        public void add(int k, int v) {
            put(k, get(k) + v);
        }
    }

    public static void main(String[] args) {
        FruitsIntoBaskets solution = new FruitsIntoBaskets();
        System.out.println(solution.totalFruit(new int[]{1,1,1}));
        System.out.println(solution.totalFruit(new int[]{1,2,1}));
        System.out.println(solution.totalFruit(new int[]{0,1,2,2}));
        System.out.println(solution.totalFruit(new int[]{1,2,3,2,2}));
        System.out.println(solution.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));

    }
}
