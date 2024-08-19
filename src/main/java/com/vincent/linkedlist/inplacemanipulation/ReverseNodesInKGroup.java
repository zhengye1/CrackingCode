package com.vincent.linkedlist.inplacemanipulation;

import com.vincent.util.LinkedListNode;

/**
 * LeetCode 25 Hard
 * Given a Linked list and a number <i>k</i>,
 * reverse the linked list in <i>k th</i> groups.
 * If remaining nodes are not in <i>k</i> groups then order remains <br>
 * Constraint:
 * - O(1) extra space solutions
 * - 1 &lt;= k &lt;= n &lt;= 5000
 * = 0 &lt;= <i>Node.value</i> &lt;= 10000
 */
public class ReverseNodesInKGroup {
    public LinkedListNode reverseKGroups(LinkedListNode head, int k) {
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;
        LinkedListNode pointer = dummy;

        // traverse pointer one
        while (pointer != null) {
            LinkedListNode tracker = pointer;
            for (int i = 0; i < k; i++) {
                if (tracker == null) break;
                tracker = tracker.next;
            }

            if (tracker == null) break;

            // reverse it in k groups
            LinkedListNode[] updatedNodes = reversedLinkedList(pointer.next, k);
            LinkedListNode prev = updatedNodes[0];
            LinkedListNode curr = updatedNodes[1];

            LinkedListNode lastNodeOfReversed = pointer.next;
            lastNodeOfReversed.next = curr;
            pointer.next = prev;
            pointer = lastNodeOfReversed;
        }

        return dummy.next;
    }

    private LinkedListNode[] reversedLinkedList(LinkedListNode node, int k) {
        LinkedListNode prev = null;
        LinkedListNode curr = node;
        LinkedListNode next = null;

        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new LinkedListNode[]{prev, curr};
    }

}
