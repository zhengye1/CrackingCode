package com.vincent.slowfast;

import com.vincent.util.LinkedListNode;

/**
 * LeetCode question 141 - Easy <br>
 * Given a linked list, to detect the linked list has cycle <br>
 * Constraint: <br>
 * - 0 &lt;= n &lt;=500 <br>
 * - -10^5 &lt;= <i>Node.data</i> &lt;= 10^5
 */
public class CycleDetection {
    /**
     * Time Complexity O(n), just need to traverse once <br>
     * Space Complexity O(1) since only modify on the same linked list
     * @param head Linked List Node to detect have cycle or not
     * @return TRUE if has cycle, FALSE otherwise
     */
    public boolean detectCycle(LinkedListNode head) {
        LinkedListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true; // if slow and fast meet, there is a cycle
        }
        return false;
    }
}
