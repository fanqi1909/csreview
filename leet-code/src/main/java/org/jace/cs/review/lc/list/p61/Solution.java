package org.jace.cs.review.lc.list.p61;

import org.jace.cs.review.lc.list.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len = length(head);

        if(len == 0) {
            return head;
        }

        k = k % len;

        if(k == 0) {
            return head;
        }

        ListNode n1 = head, n2 = head;
        for(int i = 0; i < k; i++) {
            n2 = n2.next;
        }

        while(n2.next != null) {
            n2 = n2.next;
            n1 = n1.next;
        }

        ListNode newHead = n1.next;
        n1.next = null;
        n2.next = head;

        return newHead;
    }

    private int length(ListNode head) {
        return head == null ? 0 : 1 + length(head.next);
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(n1);

        Solution solution = new Solution();

        System.out.println(solution.rotateRight(n1, 6));
    }
}
