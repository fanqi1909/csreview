package templates;

import java.util.Arrays;

//this is a bottom-up implementation of segment tree
public class SegmentTree {
    int[] tree;
    int size; // the number of child node;

    public SegmentTree(int[] nums) {
        size = nums.length;
//        int next = 1;
//        while ((size & next) != next) next = next << 1;
        tree = new int[size * 2]; //no need to go for the exact 2^n, if required, we can build tree as int[next * 2];
        buildTree(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(tree));
    }

    //build the tree from bottom up
    private void buildTree(int[] nums) {
        for (int i = size; i < size * 2; i++) {
            tree[i] = nums[i - nums.length]; //
        }
        for (int i = size - 1; i > 0; --i) {
            tree[i] = merge(tree[i * 2], tree[i * 2 + 1]);
        }
    }

    public void set(int i, int value) {
        int child = i + size;
        tree[child] = value;
        while (child > 0) {
            tree[child / 2] = merge(tree[child], tree[child ^ 1]);
            child = child / 2;
        }
        System.out.println(Arrays.toString(tree));
    }

    public int queryRange(int i, int j) {
        int ans = 0; // this has to be updated with merge(left, right);
        int l = i + size;
        int r = j + size;
        for (; l <= r; l /= 2, r /= 2) {
            if ((l & 1) == 1) ans = merge(ans, tree[l++]); // if l is right child, we add itself, otherwise we add it parent
            if ((r & 1) == 0) ans = merge(ans, tree[r--]); // if r is a left child, we add itself, otherwise we add it parent
        }
        return ans;
    }

    private int merge(int left, int right) {
        return left + right;
    }

    public static void main(String[] args) {
        SegmentTree seg = new SegmentTree(new int[]{5,3,0,2,1,4});
        System.out.println("Range [0,0]" + seg.queryRange(0, 0));
        System.out.println("Range [0,1]" + seg.queryRange(0, 1));
        System.out.println("Range [0,2]" + seg.queryRange(0, 2));
        System.out.println("Range [0,3]" + seg.queryRange(0, 3));
        System.out.println("Range [0,4]" + seg.queryRange(0, 4));
        System.out.println("Range [0,5]" + seg.queryRange(0, 5));

        System.out.println("----------------");

        System.out.println("Range [2,3]" + seg.queryRange(2, 3));
        System.out.println("Range [2,4]" + seg.queryRange(2, 4));
        System.out.println("Range [2,5]" + seg.queryRange(2, 5));


        System.out.println("----------------");
        System.out.println("Set pos 2 to 3");
        seg.set(2, 3);
        System.out.println("Range [2,3]" + seg.queryRange(2, 3));
        System.out.println("Range [2,4]" + seg.queryRange(2, 4));
        System.out.println("Range [2,5]" + seg.queryRange(2, 5));
    }
}
