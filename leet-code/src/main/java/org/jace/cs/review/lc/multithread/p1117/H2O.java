package org.jace.cs.review.lc.multithread.p1117;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class H2O implements Solution {

   volatile int hs = 0;
    volatile int os = 0;
    Lock lock = new ReentrantLock(false);
    Condition formed = lock.newCondition();

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
       // lock.lock();
        while(hs == 2) {
            //formed.await();
            TimeUnit.NANOSECONDS.sleep(1);
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hs++;
        if(hs == 2 && os == 1) {
            hs = 0;
            os = 0;
            //formed.signal();
          //  this.notifyAll();
        }
   //     lock.unlock();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
   //     lock.lock();
        while(os == 1) {
            //formed.await();
            TimeUnit.NANOSECONDS.sleep(1);
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        os++;
        if(hs == 2 && os == 1) {
            hs = 0;
            os = 0;
          //  formed.signal();
          //  this.notifyAll();
        }
   //     lock.unlock();
    }
}
