package org.jace.cs.review.lc.multithread.printFooBar;

public class ContentPrinter implements Runnable {
    private String content;

    ContentPrinter(String content) {
        this.content = content;
    }

    @Override
    public void run() {
        System.out.print(content);
    }
}
