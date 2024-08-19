package com.vincent.linkedlist.inplacemanipulation;

import com.vincent.util.LinkedListNode;

/** LeetCode 143 - Mediumz`
 *  Given a head of linked list, reorder it as foled on itself
 *  Leetcode version modify the original one
 *
 */
public class ReOrderList {
    public void reorderList(LinkedListNode head) {
        //find the middle node first
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // the slow contains the middle node
        // reverse it
        LinkedListNode prev = null;
        LinkedListNode curr = slow;
        while (curr != null){
            LinkedListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // prev contains the reverse of node
        LinkedListNode first = head;
        LinkedListNode second = prev;
        while (second.next != null){
            LinkedListNode firstNext = first.next;
            LinkedListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }

    }

    public LinkedListNode reorderListNewList(LinkedListNode head){
        reorderList(head);
        return head;
    }
}
