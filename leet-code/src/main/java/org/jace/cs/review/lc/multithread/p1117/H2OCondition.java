package org.jace.cs.review.lc.multithread.p1117;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class H2OCondition implements Solution {

    int hs = 0;
    int os = 0;
    Lock lock = new ReentrantLock(false);
    Condition formed = lock.newCondition();

    public H2OCondition() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();
        while (hs == 2) {
            formed.await();
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hs++;
        if (hs == 2 && os == 1) {
            hs = 0;
            os = 0;
            formed.signal();
        }
        lock.unlock();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        while (os == 1) {
            formed.await();
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        os++;
        if (hs == 2 && os == 1) {
            hs = 0;
            os = 0;
            formed.signal();
        }
        lock.unlock();
    }
}
