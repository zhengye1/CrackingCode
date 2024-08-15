package com.vincent.twopointer;

import com.vincent.util.LinkedListNode;

/**
 * Given a singled linked list, remove <i>n</i>th node from the tail and return its head
 * LeetCode 19 Medium
 */
public class RemoveNthLastNode {
    public LinkedListNode removeNthLastNode(LinkedListNode head, int n){
        if (head == null) return null;
        LinkedListNode left = head;
        LinkedListNode right = head;

        // move the right pointer n steps
        for (int i = 0 ; i < n ; i++){
            right = right.next;
        }

        if (right == null) return head.next;
        while (right.next != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return head;
    }
}
