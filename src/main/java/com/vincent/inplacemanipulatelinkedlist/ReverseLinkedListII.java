package com.vincent.inplacemanipulatelinkedlist;

import com.vincent.util.LinkedList;
import com.vincent.util.LinkedListNode;

/**
 * LeetCode 92 Medium
 * Given a singly linked list with <i>n</i>
 * nodes and two positions, <i>left</i> and <i>right</i>,
 * the objective is to reverse the nodes of the list from left to right. Return the modified list.
 */
public class ReverseLinkedListII {
    public LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {
        if (head == null || left == right) return head;

        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;
        LinkedListNode previous = dummy;

        // Move previous to the node before left position
        for (int i = 1; i < left; i++) {
            previous = previous.next;
        }

        // `leftNode` is the first node to be reversed
        LinkedListNode leftNode = previous.next;
        LinkedListNode curr = leftNode;
        LinkedListNode prev = null;
        LinkedListNode next = null;

        // Reverse the sublist
        for (int i = 0; i <= right - left; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Connect the reversed sublist back to the original list
        previous.next = prev;
        leftNode.next = curr;

        return dummy.next;
    }

}
