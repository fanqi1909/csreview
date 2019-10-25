package org.jace.cs.review.lc.string.p38;

import java.util.stream.IntStream;

public class Tester {

    public static void main(String[] args) {
        Solution solution = new Solution();
        IntStream.range(1, 31).forEach(
                i -> System.out.println(i + "\t" + solution.countAndSay(i))
        );


    }
}
