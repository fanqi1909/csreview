package org.jace.cs.review.lc.list.p82;

import org.jace.cs.review.lc.list.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        } else {
            ListNode next = head.next;
            boolean duplicateHead = false;
            while (next != null && next.val == head.val) {
                duplicateHead = true;
                next = next.next;
            }
            next = deleteDuplicates(next);
            if (duplicateHead) {
                return next;
            } else {
                head.next = next;
                return head;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        System.out.println(solution.deleteDuplicates(n1));

        ListNode n8 = new ListNode(1);
        ListNode n9 = new ListNode(1);
        ListNode n10 = new ListNode(1);
        ListNode n11 = new ListNode(2);
        ListNode n12 = new ListNode(3);
        n8.next = n9;
        n9.next = n10;
        n10.next = n11;
        n11.next = n12;

        System.out.println(solution.deleteDuplicates(n8));

    }
}
