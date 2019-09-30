package org.jace.cs.review.lc.multithread.p1116;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tester {

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        final IntConsumer intConsumer = new IntConsumer();
        executorService.submit(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}
