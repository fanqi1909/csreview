package cn;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class O1Cache {
    class Node {
        int value;
        Node prev;
        Node next;
    }

    int M;
    Node head;
    Map<Integer, Node> lookupTable;

    public O1Cache(int M) {
        this.M = M;
        head = null;
        lookupTable = new HashMap<>();
    }

    public boolean add(int n) {
        if(lookupTable.containsKey(n)) {
            return false;
        }
        Node newHead = new Node();
        newHead.value = n;

        newHead.next = head;
        if(head != null) {
            head.prev = newHead;
        }
        head = newHead;

        lookupTable.put(n, newHead);
        return true;
    }

    public int pop() {
        if(head == null) {
            throw new RuntimeException("Cannot pop from an empty Main");
        }

        Node oldHead = head;
        //update head
        head = head.next;
        if(head != null) {
            head.prev = null;
        }

        lookupTable.remove(oldHead.value);
        return oldHead.value;
    }


    public boolean delete(int val) {
        if(!lookupTable.containsKey(val)) {
            return false; // key does not exist
        }
        Node tobeDeleted = lookupTable.remove(val);
        Node prev = tobeDeleted.prev;
        Node next = tobeDeleted.next;
        if(prev == null) {
            head = next;
        } else if(next == null) {
            prev.next = null;
        } else {
            prev.next = next;
            next.prev = prev;
        }
        tobeDeleted.next = null; tobeDeleted.prev = null;
        return true;
    }

    public void clear() {
        head = null;
        lookupTable = new HashMap<>();
    }
}
