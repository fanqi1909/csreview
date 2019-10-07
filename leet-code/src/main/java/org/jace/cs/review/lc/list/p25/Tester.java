package org.jace.cs.review.lc.list.p25;

import org.jace.cs.review.lc.list.ListNode;

public class Tester {

    public static void main(String[] args) {
        Solution solution = new Solution();
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

        System.out.println(solution.reverseKGroup(n1, 3));

//        ListNode[] headTail = solution.reverseKNodes(n1, 2);
//        System.out.println(headTail[0] + "\t" + headTail[1]);
    }
}
