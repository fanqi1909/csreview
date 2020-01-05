package org.jace.cs.review.lc.list.p143;

import org.jace.cs.review.lc.list.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;

        ListNode n1 = head;
        ListNode n2 = head;
        while(n2 != null && n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        n2 = reverse(n1.next);

        n1.next = null;
        n1 = head;

        ListNode ans = new ListNode(-1);
        while(n1 != null && n2 != null) {
            ListNode tmp1 = n1.next;
            ListNode tmp2 = n2.next;
            ans.next = n1;
            ans = ans.next;
            ans.next = n2;
            ans = ans.next;
            n1 = tmp1;
            n2 = tmp2;
        }
        if(n1 == null) {
            ans.next = n2;
        }
        if(n2 == null) {
            ans.next = n1;
        }
    }

    private ListNode reverse(ListNode head) {
        if(head.next == null) {
            return head;
        }
        ListNode next = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }

    public static void main(String[] args) {
        ReorderList ro = new ReorderList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;

        ro.reorderList(n1);

        System.out.println(n1);

    }
}
