package org.jace.cs.review.lc.multithread.p1117;

public class AtomReleaser implements Runnable {
    private String atom;

    AtomReleaser(String atom) {
        this.atom = atom;
    }

    @Override
    public void run() {
        System.out.print(atom);
    }
}
