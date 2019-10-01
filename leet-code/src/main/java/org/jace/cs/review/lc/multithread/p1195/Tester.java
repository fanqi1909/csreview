package org.jace.cs.review.lc.multithread.p1195;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Tester {

    public static void main(String[] args) {
        FizzBuzz fizBuzz = new FizzBuzz(15);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        final IntConsumer intConsumer = new IntConsumer();
        final ContentPrinter fizzPrinter = new ContentPrinter("fizz ");
        final ContentPrinter buzzPrinter = new ContentPrinter("buzz ");
        final ContentPrinter fbPrinter = new ContentPrinter("fizzbuzz ");
        executorService.submit(() -> {
            try {
                fizBuzz.fizz(fizzPrinter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                fizBuzz.buzz(buzzPrinter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                fizBuzz.fizzbuzz(fbPrinter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                fizBuzz.number(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}
