package ps.google.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Use doubly linked list to maintain the Cache Node
 * The doubly linked list is equipted with head->tail/tail->head. Therefore we always have head/tail as reference.
 *
 * Use hashmap to maintain the mapping between Key and Cache Node.
 * <p>
 * A Library-ready package is LinkedHashMap
 */
public class LRUCache {

    class CacheBlock {
        int key;
        int value;
        CacheBlock prev;
        CacheBlock next;
    }

    private void addNode(CacheBlock node) {
        /**
         * Always add the new node right after head.
         */
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(CacheBlock node) {
        /**
         * Remove an existing node from the linked list.
         */
        CacheBlock prev = node.prev;
        CacheBlock next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(CacheBlock node) {
        /**
         * Move certain node in between to the head.
         */
        removeNode(node);
        addNode(node);
    }

    private CacheBlock popTail() {
        /**
         * Pop the current tail.
         */
        CacheBlock res = tail.prev;
        removeNode(res);
        return res;
    }

    private Map<Integer, CacheBlock> cache = new HashMap<>();
    private int size;
    private int capacity;
    private CacheBlock head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new CacheBlock();
        // head.prev = null;

        tail = new CacheBlock();
        // tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        CacheBlock node = cache.get(key);
        if (node == null) return -1;

        // move the accessed node to the head;
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        CacheBlock node = cache.get(key);

        if (node == null) {
            CacheBlock newNode = new CacheBlock();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++size;

            if (size > capacity) {
                // pop the tail
                CacheBlock tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            // update the value.
            node.value = value;
            moveToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

    }
}
