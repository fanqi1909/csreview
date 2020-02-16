package org.jace.cs.review.lc.dp.p1340;


import java.util.Arrays;
import java.util.Stack;

public class JumpGameV {

    class Pair {
        int left;
        int right;

        public Pair(int l, int r) {
            this.left = l;
            this.right = r;
        }

        @Override
        public String toString() {
            return String.format("%s=%s", left, right);
        }
    }

    public int maxJumps(int[] arr, int d) {
        int max = 0;
        Integer[] results = new Integer[arr.length];
        Pair[] boundaryList = generateBoundray(arr, d);
//        System.out.println(Arrays.toString(boundaryList));
        for (int i = 0; i < results.length; i++) {
            max = Math.max(max, compute(i, results, boundaryList));
        }
//        System.out.println(Arrays.toString(results));
        return max;
    }

    private Pair[] generateBoundray(int[] arr, int d) {
        Pair[] boundries = new Pair[arr.length];
        for (int i = 0; i < boundries.length; i++) {
            boundries[i] = new Pair(Math.max(-1, i - d - 1), Math.min(arr.length, i + d + 1));
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            boolean seenSame = false;
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                int top = stack.pop();
                boundries[top].right = Math.min(i, top + d + 1);
                if(arr[top] == arr[i]) {
                    seenSame = true;
                    boundries[i].left = Math.max(top, i - d - 1);
                }
            }
            if (!stack.isEmpty()) {
                int top = stack.peek();
                if(!seenSame) {
                    boundries[i].left = Math.max(top, i - d - 1);
                }
            }
            stack.push(i);
        }
        return boundries;
    }


    private int compute(int pos, Integer[] results, Pair[] boundariesList) {
        if (results[pos] != null) {
            return results[pos];
        }

        Pair boundary = boundariesList[pos];
        int max = 1;
        for (int l = boundary.left + 1; l < pos; l++) {
            max = Math.max(max, compute(l, results, boundariesList) + 1);
        }
        for (int r = boundary.right - 1; r > pos; r--) {
            max = Math.max(max, compute(r, results, boundariesList) + 1);
        }

        results[pos] = max;
        return results[pos];
    }

    public static void main(String[] args) {
        JumpGameV jgv = new JumpGameV();
//
        System.out.println(Arrays.toString(jgv.generateBoundray(new int[]{6,4,14,6,8,13,9,7,10,6,12}, 20)));
        System.out.println(Arrays.toString(jgv.generateBoundray(new int[]{6,4,14,6,8,13,9,7,10,6,12}, 2)));
        System.out.println(jgv.maxJumps(new int[]{6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12}, 2));
        System.out.println(jgv.maxJumps(new int[]{3, 3, 3, 3, 3}, 3));
        System.out.println(jgv.maxJumps(new int[]{7, 6, 5, 4, 3, 2, 1}, 1));
        System.out.println(jgv.maxJumps(new int[]{7, 1, 7, 1, 7, 1}, 2));
        System.out.println(jgv.maxJumps(new int[]{66}, 1));

        System.out.println(jgv.maxJumps(new int[]{22, 29, 52, 97, 29, 75, 78, 2, 92, 70, 90, 12, 43, 17, 97, 18, 58, 100, 41, 32}, 17));

    }
}