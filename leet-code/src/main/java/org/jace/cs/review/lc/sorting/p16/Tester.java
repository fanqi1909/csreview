package org.jace.cs.review.lc.sorting.p16;

public class Tester {

    public static void main(String[] args) {
        Solution solution = new SolutionN2();

        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1) + " === 2");

        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 0) + " === -1");

        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, 3, -2, -4, -1}, 0) + " === 0");

        System.out.println(solution.threeSumClosest(new int[]{0, 1, 2}, 3) + " === 3");

        System.out.println(solution.threeSumClosest(new int[]{-1, 0, 1, 1, 55}, 3) + " === 2");

        System.out.println(solution.threeSumClosest(new int[]{1,2,5,10,11}, 12) + " === 13");

    }
}
