package org.jace.cs.review.lc.multithread.p1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Solution1 implements Solution {
    private int n;

    private final ReentrantLock BQLock = new ReentrantLock(true);
    private final Condition printFooSig = BQLock.newCondition();
    private final Condition printBarSig = BQLock.newCondition();

    private volatile boolean toFoo = true;

    public Solution1(int n) {
        this.n = n;
    }

    @Override
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            BQLock.lock();
            try {

                while(!toFoo) {
                    printFooSig.await();
                }
                // printBarSig.signal();
                printFoo.run();
                printBarSig.signal();
                toFoo = false;

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BQLock.unlock();
            }
        }
    }

    @Override
    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            BQLock.lock();
            try {
                while(toFoo) {
                    printBarSig.await();
                }
          //      printFooSig.signal();
                printBar.run();
                printFooSig.signal();
                toFoo = true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BQLock.unlock();
            }
        }
    }

}


