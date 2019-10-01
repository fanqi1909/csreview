package org.jace.cs.review.lc.multithread.p1195;

import java.util.concurrent.Semaphore;

public class FizzBuzz {
    private int n;
    Semaphore fizzSep = new Semaphore(0);
    Semaphore buzzSep = new Semaphore(0);
    Semaphore fizzBuzzSep = new Semaphore(0);
    Semaphore numberSep = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {

        int numOfFizz = n/3 - n/15;
        for (int i = 1; i <= numOfFizz; i++) {
            fizzSep.acquire();
            printFizz.run();
            numberSep.release();
        }

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        int numOfBuzz = n/5 - n/15;
        for(int i = 1; i <= numOfBuzz; i++) {
            buzzSep.acquire();
            printBuzz.run();
            numberSep.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        int numOfFizzBuzz = n/15;
        for(int i = 1; i <= numOfFizzBuzz; i++) {
            fizzBuzzSep.acquire();
            printFizzBuzz.run();
            numberSep.release();
        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int counter = 1; counter <= n; counter++) {
            numberSep.acquire();
            if (counter % 15 == 0) {
                fizzBuzzSep.release();
            } else if (counter % 3 == 0) {
                fizzSep.release();
            } else if (counter % 5 == 0) {
                buzzSep.release();
            } else {
                printNumber.accept(counter);
                numberSep.release();
            }
        }
    }
}