package ps.google.sorting.searching;

import java.util.*;

public class CountOfSmallerElement {

    // segment stores max in the interval of [from,to];
    class Segment {
        int max;
        int min;
        int from;
        int to;

        @Override
        public String toString() {
            return String.format("[%d,%d -> %d,%d]", from, to, min, max);
        }
    }

    Segment[] heap;

    private void buildHeap(int[] nums) {
        int size = (int) (2 * Math.pow(2.0, Math.floor((Math.log((double) nums.length) / Math.log(2.0)) + 1)));
        heap = new Segment[size];
        build(1, 0, nums.length, nums);
//        System.out.println(Arrays.toString(heap));
    }

    private void build(int child, int from, int size, int[] nums) {
        heap[child] = new Segment();
        heap[child].from = from;
        heap[child].to = from + size - 1;
        if (size == 1) {
            heap[child].max = nums[from];
            heap[child].min = nums[from];
        } else {
            build(2 * child, from, size / 2, nums);
            build(2 * child + 1, from + size / 2, size - size / 2, nums);
            heap[child].max = Math.max(heap[2 * child].max, heap[2 * child + 1].max);
            heap[child].min = Math.min(heap[2 * child].min, heap[2 * child + 1].min);
        }
    }

    private int countMin(int val, int from, int to) {
        return countMinR(1, val, from, to);
    }

    private int countMinR(int v, int val, int from, int to) {
        Segment n = heap[v];
        if (contains(from, to, n.from, n.to)) {
            if (n.max < val) {
                return n.to - n.from + 1;
            } else if (n.min > val) {
                return 0;
            } else if (n.to > n.from) {
                return countMinR(2 * v, val, from, to) + countMinR(2 * v + 1, val, from, to);
            } else {
                return 0;
            }
        } else if (intersects(from, to, n.from, n.to)) {
            int left = countMinR(2 * v, val, from, to);
            int right = countMinR(v * 2 + 1, val, from, to);
            return left + right;
        }
        return 0;
    }

    private boolean contains(int from1, int to1, int from2, int to2) {
        return from2 >= from1 && to2 <= to1;
    }

    private boolean intersects(int from1, int to1, int from2, int to2) {
        return (from1 <= from2 && to1 >= from2)
                || (from1 >= from2 && from1 <= to2);
    }


    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new LinkedList<>();
        if (nums.length == 0) return result;
        buildHeap(nums);
        for (int i = 0; i < nums.length; i++) {
            result.add(countMin(nums[i], i + 1, nums.length - 1));
        }
        return result;
    }

    public static void main(String[] args) {
        CountOfSmallerElement coe = new CountOfSmallerElement();
        System.out.println(coe.countSmaller(new int[]{}));
        System.out.println(coe.countSmaller(new int[]{5, 2, 6, 1}));
        System.out.println(coe.countSmaller(new int[]{5, 5, 5, 5}));
        System.out.println(coe.countSmaller(new int[]{5, 2, 6, 1, 2, 4, 7, 8, 2, 1, 6}));
    }
}
