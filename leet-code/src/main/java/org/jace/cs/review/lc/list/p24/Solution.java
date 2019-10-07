package org.jace.cs.review.lc.list.p24;

import org.jace.cs.review.lc.list.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } else {
            ListNode second = head.next;
            head.next = swapPairs(second.next);
            second.next = head;
            return second;
        }
    }
}