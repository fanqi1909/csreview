package org.jace.cs.review.lc.multithread.printFooBar;

import java.util.concurrent.Semaphore;

public class Solution2 implements Solution{
    private int n;
    private Semaphore fooLock = new Semaphore(1);
    private Semaphore barLock = new Semaphore(0);

    public Solution2(int n) {
        this.n = n;
    }

    @Override
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooLock.acquire();
            printFoo.run();
            barLock.release();
        }
    }

    @Override
    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barLock.acquire();
            printBar.run();
            fooLock.release();
        }
    }
}
