package org.jace.cs.review.lc.multithread.printFooBar;

public interface Solution {
    public void foo(Runnable fooPrinter) throws Exception;
    public void bar(Runnable barPrinter) throws Exception;
}
