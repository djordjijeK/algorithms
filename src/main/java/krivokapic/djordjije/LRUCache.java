package krivokapic.djordjije;

import java.util.HashMap;


// https://leetcode.com/problems/lru-cache/description/
class LRUCache {
    private final int capacity;
    private final HashMap<Integer, Node> hashMap;

    private Node head;
    private Node tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.hashMap = new HashMap<>(capacity);

        this.head = null;
        this.tail = null;
    }


    public int get(int key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return -1;
        }

        reposition(node, node.value);
        return node.value;
    }


    public void put(int key, int value) {
        Node node = hashMap.get(key);
        if (node == null) {
            hashMap.put(key, insertNode(key, value));
        } else {
            reposition(node, value);
        }

        if (hashMap.size() > capacity) {
            deleteLRU();
        }
    }


    private Node insertNode(int key, int value) {
        Node node = new Node();
        node.key = key;
        node.value = value;

        if (this.head == null && this.tail == null) {
            this.head = node;
            this.tail = node;
            return node;
        }

        node.next = this.head;
        this.head.previous = node;
        this.head = node;

        return node;
    }


    private void reposition(Node node, int value) {
        node.value = value;

        if (node == this.head) {
            return;
        }

        if (node == this.tail) {
            this.tail = this.tail.previous;
            this.tail.next = null;

            node.previous = null;
            node.next = this.head;
            this.head.previous = node;
            this.head = node;

            return;
        }

        Node previous = node.previous;
        previous.next = node.next;
        node.next.previous = previous;

        node.previous = null;
        node.next = this.head;
        this.head.previous = node;
        this.head = node;
    }


    private void deleteLRU() {
        Node preTail = this.tail.previous;
        preTail.next = null;

        hashMap.remove(this.tail.key);

        this.tail = preTail;
    }


    private static class Node {
        int key;
        int value;
        Node previous;
        Node next;
    }
}