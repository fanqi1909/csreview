package ps.google.sorting.searching;

import javafx.util.Pair;

import java.util.*;

/**
 * Three ways for this problem:
 * 1. Segment Tree/ Binary Index Tree to incrementally update the tail range
 * 2. Merge sort to calculate the inversions
 * 3. Augmented binary search tree to record count of smaller number of a current node.
 *
 */
public class CountOfSmallerElement {
    class Pair {
        int index;
        int value;
        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("[%d,%d]", value, index);
        }

    }
    public List<Integer> countSmaller(int[] nums) {
        int[] values = new int[nums.length];
        Pair[] pairs = new Pair[nums.length];
        for(int i = 0 ; i < nums.length; i++) {
            pairs[i] = new Pair(i, nums[i]);
        }

        mergesort(pairs, 0, nums.length - 1, values, new Pair[nums.length]);

        List<Integer> ans = new ArrayList<>();
        for(int val : values) {
            ans.add(val);
        }
        return ans;
    }

    private void mergesort(Pair[] pairs, int start, int end, int[] values, Pair[] workingArray) {
        if(start >= end) return;
        int mid = (start + end) >>> 1;
        mergesort(pairs, start, mid, values, workingArray);
        mergesort(pairs, mid + 1, end, values, workingArray);

        merge(pairs, start, end, mid, values, workingArray);
    }

    private void merge(Pair[] pairs, int start, int end, int mid, int[] values, Pair[] workingArray) {
        System.arraycopy(pairs, start, workingArray, start, end - start + 1);
        int p1 = start;
        int p2 = mid + 1;
        int next = start;
        while(p1 <= mid && p2 <= end) {
            if (workingArray[p1].value <= workingArray[p2].value) {
                values[workingArray[p1].index] += p2 - mid - 1;
                pairs[next++] = workingArray[p1++];
            } else {
                pairs[next++] = workingArray[p2++];
            }
        }
        while(p1 <= mid) {
            values[workingArray[p1].index] += end - mid;
            pairs[next++] = workingArray[p1++];
        }

        while(p2 <= mid) {
            pairs[next++] = workingArray[p2++];
        }
    }

    public static void main(String[] args) {
        CountOfSmallerElement coe = new CountOfSmallerElement();
        System.out.println(coe.countSmaller(new int[]{}));
        System.out.println(coe.countSmaller(new int[]{5, 2, 6, 1}));
        System.out.println(coe.countSmaller(new int[]{5, 5, 5, 5}));
        System.out.println(coe.countSmaller(new int[]{5, 2, 6, 1, 2, 4, 7, 8, 2, 1, 6}));
    }
}
