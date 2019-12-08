package templates;

import java.util.Arrays;

public class BinaryIndexedTree {

    /**
     * Fenwich tree
     *
     *  ft is 1 indexed. ft[0] does not refer to anything
     *  ft[i] is responsible for the range [i - lsb(i) + 1, i]
     *
     *  query(pos): i = pos+1; while(i >0) i -= lsb(i)
     *
     *  update(pos): while(i < ft.length) i += lsb(i);
     *
     *  i += lsb(i) is to iterate left-wise ( to the bottom of the tree, the range shrinks)
     *  i -= lsb(i) is to iterate right-wise ( to the top of the tree, the range grows)
     *
     */
    private int[] ft;
    private int[] copy;

    public BinaryIndexedTree(int[] input) {
        ft = new int[input.length + 1]; // so our index start from 1
        copy = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            update(i, input[i]);
        }
    }

    /**
     * Query prefix sum till position, [0, position] inclusive
     * @param pos
     * @return
     */
    public int query(int pos) {
        int sum = 0;
        for(int i = pos + 1; i > 0; i = i - lsb(i)) {
            sum += ft[i];
        }
        return sum;
    }

    public int queryRange(int start, int end) {
        return query(end) - query(start - 1);
    }

    /**
     * Position is 0 based in the original index. So we need to use i=pos+1 to transform the coordinate
     *
     * The update is delta based. If we want to set value, we need to keep track of the original array
     */
    public void update(int pos, int delta) {
        for(int i = pos + 1; i < ft.length; i = i + lsb(i)) {
            ft[i] += delta;
        }
        copy[pos] += delta;
    }

    public void set(int pos, int value) {
        int diff = value - copy[pos];
        for (int j = pos + 1; j < ft.length; j += lsb(j)) {
            ft[j] += diff;
        }
        copy[pos] = value;
        System.out.println(Arrays.toString(ft));
    }

    private int lsb(int i) {
        return -i & i;
    }


    public static void main(String[] args) {
        BinaryIndexedTree bit = new BinaryIndexedTree(new int[]{0, 1, 2, 3, 4, 5});
        System.out.println("Range [0,0]" + bit.query(0));
        System.out.println("Range [0,1]" + bit.query(1));
        System.out.println("Range [0,2]" + bit.query(2));
        System.out.println("Range [0,3]" + bit.query(3));
        System.out.println("Range [0,4]" + bit.query(4));
        System.out.println("Range [0,5]" + bit.query(5));

        System.out.println("----------------");

        System.out.println("Range [2,3]" + bit.queryRange(2, 3));
        System.out.println("Range [2,4]" + bit.queryRange(2, 4));
        System.out.println("Range [2,5]" + bit.queryRange(2, 5));



        System.out.println("----------------");
        System.out.println("Increment pos 3 by 2");
        bit.update(3, 2);

        System.out.println("Range [2,3]" + bit.queryRange(2, 3));
        System.out.println("Range [2,4]" + bit.queryRange(2, 4));
        System.out.println("Range [2,5]" + bit.queryRange(2, 5));


        System.out.println("----------------");
        System.out.println("Set pos 3 to 1");
        bit.set(3, 1);
        System.out.println("Range [2,3]" + bit.queryRange(2, 3));
        System.out.println("Range [2,4]" + bit.queryRange(2, 4));
        System.out.println("Range [2,5]" + bit.queryRange(2, 5));
    }
}
