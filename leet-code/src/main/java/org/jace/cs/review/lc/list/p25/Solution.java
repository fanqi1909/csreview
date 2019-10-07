package org.jace.cs.review.lc.list.p25;

import org.jace.cs.review.lc.list.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        ListNode next = head;
        int i = 0;
        for(; i < k && next != null; i++) {
            next = next.next;
        }
        if(i != k) {
            return head;
        } else {
            ListNode[] firstGroup = reverseKNodes(head, k);
            firstGroup[1].next = reverseKGroup(next, k);
            return firstGroup[0];
        }
    }

    protected ListNode[] reverseKNodes(ListNode head, int k) {
        if(head == null) {
            return null;
        } else if(k == 1) {
            return new ListNode[]{head, head};
        } else {
            ListNode[] node = reverseKNodes(head.next, k -1);
            node[1].next = head;
            head.next = null;
            node[1] = head;
            return node;
        }
    }
}
