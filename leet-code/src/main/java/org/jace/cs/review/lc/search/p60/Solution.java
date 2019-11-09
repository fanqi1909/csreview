package org.jace.cs.review.lc.search.p60;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        int factorial = fact(n - 1);
        StringBuilder builder = new StringBuilder();

        permutation(numbers, factorial, k - 1, builder);

        return builder.toString();
    }

    private int fact(int n) {
        return n <= 1 ? 1 : n * fact(n - 1);
    }

    private void permutation(List<Integer> numbers, int factorial, int k, StringBuilder result) {
        if (numbers.size() == 1) {
            result.append(numbers.get(0));
        } else {
            //find the numebr
            int index = k / factorial;
            int num = numbers.get(index);
            numbers.remove(index);
            permutation(numbers, factorial / numbers.size(), k % factorial, result.append(num));
        }
    }

    public static void main(String[] args) {
        Solution solutions = new Solution();

        for(int k = 1; k <=6 ; k++) {
            System.out.println(solutions.getPermutation(3, k));
        }


        for(int k = 1; k <= 24; k++) {
            System.out.println(solutions.getPermutation(4, k));
        }

        System.out.println(solutions.getPermutation(1,1));


    }
}
