package org.jace.cs.review.lc.contest.c162.p1252;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SolutionGreedy {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] columns) {
        int[] row1 = new int[columns.length];
        int[] row2 = new int[columns.length];

        for(int i = 0; i < columns.length; i++) {
            if(columns[i] == 2) {
                row1[i] = 1;
                upper--;
                row2[i] = 1;
                lower--;
            }
        }

        int position = 0;
        while(upper > 0 && position < row1.length) {
            if(row1[position] != 1 && columns[position] == 1) {
                row1[position] = 1;
                upper--;
            }
            position++;
        } //fill up all uppers
        while(lower > 0 && position < row2.length) {
            if(row2[position] != 1 && columns[position] == 1) {
                row2[position] = 1;
                lower--;
            }
            position++;
        } //fill up all uppers

        boolean noOnesRemaining = true;
        while(position < columns.length) {
            if(columns[position] == 1) {
                noOnesRemaining = false;
                break;
            }
            position++;
        }
        List<List<Integer>> result = new LinkedList<>();
        if(upper != 0 || lower != 0 || !noOnesRemaining) {
            return result;
        } else {
            List<Integer> uRow = new ArrayList<>();
            for(int row : row1) {
                uRow.add(row);
            }
            List<Integer> dRow = new ArrayList<>();
            for(int row : row2) {
                dRow.add(row);
            }
            result.add(uRow);
            result.add(dRow);
            return result;
        }
    }

    public static void main(String[] args) {
        SolutionGreedy solution = new SolutionGreedy();

        int[] test = new int[]{1, 1, 1};

        solution.reconstructMatrix(2, 1, test).forEach(System.out::println);

        test = new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1};
        solution.reconstructMatrix(5, 5, test).forEach(System.out::println);

        test = new int[]{2, 1, 2, 0, 2, 0, 1, 2, 0, 1};
        System.out.println(solution.reconstructMatrix(10, 5, test));

        test = new int[]{2, 2, 1, 1};
        System.out.println(solution.reconstructMatrix(2, 3, test));


        test = new int[]{2,1,2,0,1,0,1,2,0,1};
        System.out.println(solution.reconstructMatrix(5, 5, test));

        test = new int[]{2, 1, 2, 0, 0, 2};
        System.out.println(solution.reconstructMatrix(1, 4, test));
    }
}
