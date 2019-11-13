package org.jace.cs.review.lc.list.p86;

import org.jace.cs.review.lc.list.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return null;
        } else {
            ListNode next = partition(head.next, x);
            if(head.val < x || next == null||  next.val >= x) {
                head.next = next;
                return head;
            } else {
                ListNode dummy = new ListNode(-1);
                dummy.next = next;
                ListNode tmp = dummy;
                while(tmp.next != null && tmp.next.val <x) {
                    tmp = tmp.next;
                }
                head.next = tmp.next;
                tmp.next = head;
                dummy.next = null;
                return next;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        System.out.println(solution.partition(n1, 5));

    }

}
