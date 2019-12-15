package contest.c167;

import org.jace.cs.review.lc.list.ListNode;

public class Q1 {

    public int getDecimalValue(ListNode head) {
        int size = getSize(head);
        if(size == 0) {
            return 0;
        }

        int sum = 0;
        while(head != null) {
                sum += head.val << (size - 1);
                size --;
                head = head.next;
        }
        return sum;
    }

    private int getSize(ListNode head) {
        if(head == null) {
            return 0;
        } else {
            return 1 + getSize(head.next);
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(1);

        Q1 sol = new Q1();
        System.out.println(sol.getDecimalValue(n1));
        n1 .next = n2;
        System.out.println(sol.getDecimalValue(n1));
        n2.next = n3;
        System.out.println(sol.getDecimalValue(n1));

        System.out.println(sol.getDecimalValue(new ListNode(0)));
        System.out.println(sol.getDecimalValue(new ListNode(1)));
    }
}
