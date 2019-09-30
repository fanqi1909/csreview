package org.jace.cs.review.lc.multithread.p1114;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tester {

    private static void testSolution(Solution solution) {
        ContentPrinter fp = new ContentPrinter("first");
        ContentPrinter sp = new ContentPrinter("second");
        ContentPrinter tp = new ContentPrinter("third");

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                solution.first(fp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                solution.second(sp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                solution.third(tp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }

    public static void main(String[] args) throws Exception{
        Solution solution1 = new Foo();
        testSolution(solution1);
    }
}
