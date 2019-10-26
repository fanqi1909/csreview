package org.jace.cs.review.lc.dp.p300;

public class Tester {

    public static void main(String[] args) {
        Solution dp = new SolutionDP();

        Solution bs = new SolutionBS();

        int[] test;

        test = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(bs.lengthOfLIS(test) + " === " + dp.lengthOfLIS(test));

        test = new int[]{1,3,6,7,9,4,10,5,6};
        System.out.println(bs.lengthOfLIS(test) + " === " + dp.lengthOfLIS(test));

    }
}
