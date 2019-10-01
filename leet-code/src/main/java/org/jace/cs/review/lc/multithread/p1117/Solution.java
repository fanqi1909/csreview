package org.jace.cs.review.lc.multithread.p1117;

public interface Solution {

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException;
    public void oxygen(Runnable releaseOxygen) throws InterruptedException;
}
