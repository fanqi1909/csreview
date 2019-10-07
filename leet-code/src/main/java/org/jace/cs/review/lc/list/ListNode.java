package org.jace.cs.review.lc.list;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        if (next == null) {
            return val + "";
        } else {
            return val + "->" + next.toString();
        }
    }
}