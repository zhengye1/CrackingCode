package com.vincent.inplacemanipulatelinkedlist;

import com.vincent.util.LinkedListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 138 - Medium
 * Given a linked list with random pointer, return the deepCopy
 */
public class DeepCopyLinkedList {
    public LinkedListNode copyRandomList(LinkedListNode head) {
        // [original, deepcopy]
        Map<LinkedListNode, LinkedListNode> map = new HashMap<>();
        LinkedListNode current = head;
        while (current != null) {
            LinkedListNode newNode = new LinkedListNode(current.data);
            map.put(current, newNode);
            current = current.next;
        }

        current = head;
        while (current != null) {
            LinkedListNode copy = map.get(current);
            // next
            copy.next = map.get(current.next);
            // random
            copy.random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }
}
