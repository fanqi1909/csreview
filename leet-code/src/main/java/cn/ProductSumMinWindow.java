package cn;

import java.util.*;

public class ProductSumMinWindow {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] input = new int[n];
        for(int i = 0; i <n ;i++) {
            input[i] = scanner.nextInt();
        }

        int ans = productMaxMin(input);
        System.out.println(ans);
    }

    private static int productMaxMin(int[] input) {
        int[] working = new int[input.length + 1];
        System.arraycopy(input, 0, working, 1, input.length);

        int[] prefix = new int[working.length];
        for(int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i-1] + working[i];
        }
//        System.out.println(Arrays.toString(working));
//        System.out.println(Arrays.toString(prefix));

        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < working.length; i++) {
            while(!stack.isEmpty() && working[stack.peek()] > working[i]) {
                int index = stack.pop();
                //for this index
                int leftIndex = stack.isEmpty() ? 0 : stack.peek();
                int rightIndex = i - 1;
               // System.out.println(index + "\t" + leftIndex + "\t" + rightIndex  + "\t" + (working[index] * (prefix[rightIndex] - prefix[leftIndex])));
                max = Math.max(max, working[index] * (prefix[rightIndex] - prefix[leftIndex]));
            }
            stack.push(i);
        }
     //   System.out.println(stack);

        int last = working.length - 1;
        while(stack.size() > 1) {
            int index = stack.pop();
            int leftIndex = stack.peek();
        //    System.out.println(index + "\t" + leftIndex + "\t" + last  + "\t" + (working[index] * (prefix[last] - prefix[leftIndex])));
            max = Math.max(max, working[index] * (prefix[last] - prefix[leftIndex]));
        }
        return max;

    }

}
