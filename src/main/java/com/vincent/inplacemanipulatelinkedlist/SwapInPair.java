package com.vincent.inplacemanipulatelinkedlist;

import com.vincent.util.LinkedListNode;

/**
 * LeetCode 24 Medium
 * Given a single linked list, swap every two adjacent nodes of the linked list <br>
 * Constraint:  <br>
 * - length for linked list [0, 100]
 * - 0 &lt;= <i>node.value</i> &lt;= 100
 */
public class SwapInPair {
    public LinkedListNode swapPairs(LinkedListNode head) {
        LinkedListNode result = head;
        while (result != null && result.next != null) {
            // which means it have the pair for swap
            int nextData = result.next.data;
            result.next.data = result.data;
            result.data = nextData;
            result = result.next.next;
        }

        return head;
    }
}
