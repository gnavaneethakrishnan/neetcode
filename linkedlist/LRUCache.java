package neetcode.linkedlist;

import org.example.ListNode;

import java.util.HashMap;
import java.util.Map;

//leetcode 146
public class LRUCache {

    private int capacity;
    Map<Integer, DoublyListNode> cache;
    DoublyListNode head;
    DoublyListNode tail;



    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new DoublyListNode(-1,-1);
        tail = new DoublyListNode(-1,-1);
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {

        if(!cache.containsKey(key)) return  -1;
        DoublyListNode node = cache.get(key);
        remove(node);
        insert(node);
        return node.value;

    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            DoublyListNode node = cache.get(key);
            remove(node);
            insert(node);
            node.value = value;
            cache.put(key,node);
        } else {
            if (cache.size() == capacity) {
                DoublyListNode prev = tail.prev;
                remove(prev);
                cache.remove(prev.key);
                DoublyListNode newnode = new DoublyListNode(key,value);
                insert(newnode);
                cache.put(key,newnode);
            } else {
                DoublyListNode newnode = new DoublyListNode(key,value);
                insert(newnode);
                cache.put(key,newnode);

            }

        }

    }

    public void insert(DoublyListNode node) {

        DoublyListNode temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;

    }

    public void remove(DoublyListNode node) {
        DoublyListNode prev = node.prev;
        DoublyListNode next = node.next;

        prev.next = next;
        next.prev = prev;


    }

    class DoublyListNode {

        int key;
        int value;
        DoublyListNode next;
        DoublyListNode prev;

        public DoublyListNode() {

        }

        public DoublyListNode(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }
}
