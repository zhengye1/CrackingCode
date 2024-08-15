package com.vincent.inplacemanipulatelinkedlist;

import com.vincent.util.LinkedListNode;

/**
 * LeetCode 24 Medium
 * Given a single linked list, swap every two adjacent nodes of the linked list <br>
 * Constraint:  <br>
 * - length for linked list [0, 100]
 * - 0 &lt;= <i>node.value</i> &lt;= 100 <br>
 * - don't swap the data value
 */
public class SwapInPair {
    // Not a good solution because cannot swap the value
    public LinkedListNode swapPairsBad(LinkedListNode head) {
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

    public LinkedListNode swapPairs(LinkedListNode head) {
        LinkedListNode dummy  = new LinkedListNode(0);
        dummy.next = head;
        LinkedListNode curr = dummy;
        while(curr.next != null && curr.next.next != null) {
            LinkedListNode next = curr.next;
            LinkedListNode nextNext = next.next;
            curr.next = nextNext;
            next.next = nextNext.next;
            nextNext.next = next;
            curr = next;
        }

        return dummy.next;
    }

}
