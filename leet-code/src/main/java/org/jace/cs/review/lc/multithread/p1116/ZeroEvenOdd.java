package org.jace.cs.review.lc.multithread.p1116;

import java.util.concurrent.Semaphore;

public class ZeroEvenOdd {
    private int n;

    Semaphore zReady = new Semaphore(1);
    Semaphore eReady = new Semaphore(0);
    Semaphore oReady = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int j = 1; j <= n; j ++) {
            zReady.acquire();
            printNumber.accept(0);
            if((j & 0x01) == 0) {
                oReady.release();
            } else {
                eReady.release();
            }

        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i+=2) {
            eReady.acquire();
            printNumber.accept(i);
            zReady.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i <= n; i+=2) {
            oReady.acquire();
            printNumber.accept(i);
            zReady.release();
        }
    }
}
