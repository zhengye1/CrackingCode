package com.vincent.linkedlist;

import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

class LinkedList {
    Node left;
    Node right;
    Map<Integer, Node> maps;

    public LinkedList() {
        this.left = new Node(0, null, null);
        this.right = new Node(0, this.left, null);
        this.maps = new HashMap<>();
    }

    int length() {
        return this.maps.size();
    }

    void pushRight(int value) {
        Node node = new Node(value, this.right.prev, this.right);
        this.maps.put(value, node);
        this.right.prev = node;
        node.prev.next = node;
    }

    void pop(int value) {
        if (this.maps.containsKey(value)) {
            Node node = this.maps.get(value);
            Node next = node.next, prev = node.prev;
            next.prev = prev;
            prev.next = next;
            this.maps.remove(value);
        }
    }

    int popLeft() {
        int res = this.left.next.data;
        this.pop(res);
        return res;
    }
}

/**
 * LeetCode 460 - Hard
 * Also need O(1)
 */
public class LFUCache {
    int capacity;
    int lfuCnt;
    Map<Integer, Integer> valMap;
    Map<Integer, Integer> countMap;
    Map<Integer, LinkedList> listMap;
    ;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.lfuCnt = 0;
        this.valMap = new HashMap<>();
        this.countMap = new HashMap<>();
        this.listMap = new HashMap<>();
    }

    void counter(int key) {
        int cnt = this.countMap.get(key);
        LinkedList currentList = this.listMap.get(cnt);
        currentList.pop(key);

        // 更新使用频率
        int newCnt = cnt + 1;
        this.countMap.put(key, newCnt);

        LinkedList nextList = this.listMap.getOrDefault(newCnt, new LinkedList());
        nextList.pushRight(key);
        this.listMap.put(cnt, currentList);
        this.listMap.put(newCnt, nextList);

        // 如果当前频率是最少使用频率且列表为空，更新lfuCnt
        if (currentList.length() == 0 && cnt == this.lfuCnt) {
            this.lfuCnt++;
        }
    }

    int get(int key) {
        if (!this.valMap.containsKey(key)) {
            return -1;
        }
        this.counter(key);
        return this.valMap.get(key);
    }

    void put(int key, int value) {
        if (this.capacity == 0) return;

        if (this.valMap.containsKey(key)) {
            // 如果键已经存在，更新值，并增加使用计数
            this.valMap.put(key, value);
            this.counter(key);
        } else {
            // 如果缓存已满，驱逐最少使用的元素
            if (this.valMap.size() == this.capacity) {
                // 获取当前最少使用频率对应的链表
                LinkedList lfuList = this.listMap.get(this.lfuCnt);
                int res = lfuList.popLeft();
                this.valMap.remove(res);
                this.countMap.remove(res); // 删除计数记录
            }

            // 插入新键值对，并初始化频率
            this.valMap.put(key, value);
            this.countMap.put(key, 1); // 初始化频率为1
            this.lfuCnt = 1; // 插入新键时最小频率为1

            // 将新键加入到频率为1的链表中
            LinkedList freqList = this.listMap.getOrDefault(this.lfuCnt, new LinkedList());
            freqList.pushRight(key);
            this.listMap.put(this.lfuCnt, freqList);
        }
    }

}
