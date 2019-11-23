package ps.google.array.string;

import org.jace.cs.review.lc.list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> buffer = new PriorityQueue<>(Math.min(lists.length, 0) + 1, Comparator.comparingInt(n -> n.val));

        for(ListNode node : lists) {
            if(node != null) {
                buffer.add(node);
            }
        }

        ListNode head = new ListNode(-1);
        ListNode last = head;
        while(!buffer.isEmpty()) {
            ListNode tmp = buffer.poll();
            if(tmp.next != null) {
                buffer.add(tmp.next);
            }
            last.next = tmp;
            last = tmp;
        }
        return head.next;
    }

    public static void main(String[] args) {
        MergeKSortedList solution = new MergeKSortedList();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);
        n1.next = n2; n2.next = n3;

        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n4.next = n5; n5.next = n6;

        ListNode n7 = new ListNode(2);
        ListNode n8 = new ListNode(6);
        n7.next = n8;

        System.out.println(solution.mergeKLists(new ListNode[]{n1, n4, n7}));

        System.out.println(solution.mergeKLists(new ListNode[]{}));
    }
}
