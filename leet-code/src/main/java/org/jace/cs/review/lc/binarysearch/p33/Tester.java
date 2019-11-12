package org.jace.cs.review.lc.binarysearch.p33;

public class Tester {
    public static void main(String[] args) {
        SolutionBS solution = new SolutionBS();


        System.out.println(solution.search(new int[]{0,1,2,4,5,6,7}, 0) + " ==== 0");
        System.out.println(solution.search(new int[]{1,2,4,5,6,7,0}, 0) + " ==== 6");
        System.out.println(solution.search(new int[]{2,4,5,6,7,0,1}, 0) + " ==== 5");
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 0) + " ==== 4");
        System.out.println(solution.search(new int[]{5,6,7,0,1,2,4}, 0) + " ==== 3");
        System.out.println(solution.search(new int[]{6,7,0,1,2,4,5}, 0) + " ==== 2");
        System.out.println(solution.search(new int[]{7,0,1,2,4,5,6}, 0) + " ==== 1");
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 3) + " ==== -1");
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 10) + " ==== -1");
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 15) + " ==== -1");
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, -3) + " ==== -1");

        System.out.println(solution.search(new int[]{3, 1}, 1) + " ==== 1");

        System.out.println(solution.search(new int[]{5, 1, 3}, 5) + " ==== 0");


    }
}