package com.vincent.inplacemanipulatelinkedlist;

import com.vincent.util.LinkedListNode;

/**
 * LeetCode 206 - Easy
 *
 */
public class ReverseLinkedList {
    /**
     * Easy solution
     * @param head
     * @return
     */
    public LinkedListNode reverseList(LinkedListNode head) {
        LinkedListNode prev = null;
        LinkedListNode curr = head;
        while(curr != null) {
            LinkedListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
