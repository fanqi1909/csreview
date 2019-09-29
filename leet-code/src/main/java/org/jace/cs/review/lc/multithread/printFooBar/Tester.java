package org.jace.cs.review.lc.multithread.printFooBar;

public class Tester {

    private static void testSolution(Solution solution) throws InterruptedException {
        ContentPrinter fp = new ContentPrinter("foo");
        ContentPrinter bp = new ContentPrinter("bar");
        Thread fooThread = new Thread(() -> {
            try {
                solution.foo(fp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread barThread = new Thread(() -> {
            try {
                solution.bar(bp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        fooThread.start();
        barThread.start();
        fooThread.join();
        barThread.join();
    }

    public static void main(String[] args) throws Exception{
        Solution solution1 = new Solution1(10);
        Solution solution2 = new Solution2(10);

        testSolution(solution1);
        System.out.println();
        testSolution(solution2);
    }
}
