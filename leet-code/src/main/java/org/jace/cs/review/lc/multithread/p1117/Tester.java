package org.jace.cs.review.lc.multithread.p1117;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tester {

    private void test(Solution solution,   int oxs) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        AtomReleaser releaseH = new AtomReleaser("H");
        AtomReleaser releaseO = new AtomReleaser("O");


        executorService.submit(() -> {
            try {
                for(int i = 0; i < oxs * 2; i++) {
                    solution.hydrogen(releaseH);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                for(int i = 0; i < oxs; i++) {
                    solution.oxygen(releaseO);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
        executorService.shutdownNow();
        System.out.println();
    }


    public static void main(String[] args) throws InterruptedException {
        Tester tester = new Tester();
        Solution h2o = new H2O();
        tester.test(h2o, 5);

        Solution h2oCondition = new H2OCondition();
        tester.test(h2oCondition, 5);

        Solution h2Phaser = new H2OPhase();
        tester.test(h2Phaser, 5);

    }
}
