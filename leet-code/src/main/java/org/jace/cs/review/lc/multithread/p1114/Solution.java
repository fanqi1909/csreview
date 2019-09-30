package org.jace.cs.review.lc.multithread.p1114;

public interface Solution {
    public void first(Runnable printThird) throws InterruptedException;
    public void second(Runnable printThird) throws InterruptedException;
    public void third(Runnable printThird) throws InterruptedException;

}
