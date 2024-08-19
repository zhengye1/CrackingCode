package com.vincent.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 146 - Medium, <i>get</i> and <i>put</i> must be O(1)
 */

class DoubleLinkedListNode {
    int key;
    int value;
    DoubleLinkedListNode next;
    DoubleLinkedListNode prev;

    public DoubleLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    int size = 0;
    int capacity;
    DoubleLinkedListNode head;
    DoubleLinkedListNode tail;
    // store the key and node
    DoubleLinkedListNode[] hash;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hash = new DoubleLinkedListNode[10001];
        head = new DoubleLinkedListNode(0, 0);
        tail = new DoubleLinkedListNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void insert(DoubleLinkedListNode node) {
        DoubleLinkedListNode next = head.next;
        hash[node.key] = node;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    public void remove(DoubleLinkedListNode node) {
        DoubleLinkedListNode prev = node.prev;
        DoubleLinkedListNode next = node.next;
        prev.next = next;
        next.prev = prev;
        hash[node.key] = null;
    }

    public int get(int key) {
        DoubleLinkedListNode node = hash[key];
        if (node == null) return -1;
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedListNode node = hash[key];
        if (node != null) {
            remove(node);
            node.value = value;
            insert(node);
        } else {
            size++;
            node = new DoubleLinkedListNode(key, value);
            insert(node);
            if (size > capacity) {
                remove(tail.prev);
                size--;
            }
        }
    }
}

