package ps.google.sorting.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Three ways for this problem:
 * 1. Segment Tree/ Binary Index Tree to incrementally update the tail range
 * 2. Merge sort to calculate the inversions
 * 3. Augmented binary search tree to record count of smaller number of a current node.
 *
 */
public class CountOfSmallerElementSegmentTree {
//    class Measure {
//        int max;
//        int min;
//        int count;
//        public Measure(int max, int min, int count) {
//            this.max = max;
//            this.min = min;
//            this.count = count;
//        }
//    }
//    Measure[] tree;
//    int size; // the number of child node;
//
//    //build the tree from bottom up
//    private void buildTree(int[] nums) {
//        size = nums.length;
//        tree = new Measure[size * 2];
//        for (int i = size; i < size * 2; i++) {
//            tree[i] = new Measure(nums[i - nums.length], nums[i - nums.length], 1);
//        }
//        for (int i = size - 1; i > 0; --i) {
//            tree[i] = merge(tree[i * 2], tree[i * 2 + 1]);
//        }
//    }
//
//    public void set(int i, int value) {
//        int child = i + size;
//        tree[child] = value;
//        while (child > 0) {
//            tree[child / 2] = merge(tree[child], tree[child ^ 1]);
//            child = child / 2;
//        }
//        System.out.println(Arrays.toString(tree));
//    }
//
//    public int queryRange(int i, int j) {
//        int ans = 0; // this has to be updated with merge(left, right);
//        int l = i + size;
//        int r = j + size;
//        for (; l <= r; l /= 2, r /= 2) {
//            if ((l & 1) == 1) ans = merge(ans, tree[l++]); // if l is right child, we add itself, otherwise we add it parent
//            if ((r & 1) == 0) ans = merge(ans, tree[r--]); // if r is a left child, we add itself, otherwise we add it parent
//        }
//        return ans;
//    }
//
//    private Measure merge(Measure left, Measure right) {
//
//    }
//
//    public List<Integer> countSmaller(int[] nums) {
//
//        List<Integer> ans = new ArrayList<>();
//
//        return ans;
//    }
//
//
//    public static void main(String[] args) {
//        CountOfSmallerElementSegmentTree coe = new CountOfSmallerElementSegmentTree();
//        System.out.println(coe.countSmaller(new int[]{}));
//        System.out.println(coe.countSmaller(new int[]{5, 2, 6, 1}));
//        System.out.println(coe.countSmaller(new int[]{5, 5, 5, 5}));
//        System.out.println(coe.countSmaller(new int[]{5, 2, 6, 1, 2, 4, 7, 8, 2, 1, 6}));
//    }
}
