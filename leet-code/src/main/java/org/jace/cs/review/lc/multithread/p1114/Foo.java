package org.jace.cs.review.lc.multithread.p1114;

import java.util.concurrent.Semaphore;

public class Foo implements Solution {

    Semaphore secondReady;
    Semaphore thirdReady;

    public Foo() {
        secondReady = new Semaphore(0);
        thirdReady = new Semaphore(0);
    }

    @Override
    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        secondReady.release();
    }

    @Override
    public void second(Runnable printSecond) throws InterruptedException {
        secondReady.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        thirdReady.release();
    }

    @Override
    public void third(Runnable printThird) throws InterruptedException {
        thirdReady.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        //release all
        thirdReady.release();
        secondReady.release();
    }
}
