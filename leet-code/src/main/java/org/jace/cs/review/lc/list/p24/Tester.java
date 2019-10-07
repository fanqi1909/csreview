package org.jace.cs.review.lc.list.p24;

import org.jace.cs.review.lc.list.ListNode;

public class Tester {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(n1);

        System.out.println(solution.swapPairs(n1));
    }
}
