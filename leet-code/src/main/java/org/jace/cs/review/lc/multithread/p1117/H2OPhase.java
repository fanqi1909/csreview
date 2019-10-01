package org.jace.cs.review.lc.multithread.p1117;


import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class H2OPhase implements Solution {

    Semaphore hs = new Semaphore(2);
    Semaphore os = new Semaphore(1);
    Phaser phaser = new Phaser(3);

    public H2OPhase() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hs.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        if(hs.availablePermits() == 0) {
            phaser.arriveAndAwaitAdvance();
            hs.release();
            hs.release();
        } else {
            phaser.arrive();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        os.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        phaser.arriveAndAwaitAdvance();
        os.release();
    }
}
