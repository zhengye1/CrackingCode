package com.vincent.slowfast;

import com.vincent.util.LinkedListNode;

/**
 * LeetCode 876 Easy <br>
 * Given a linked list, return the middle node of the linked list<br>
 * If two node was in the middle then return the second one <br>
 * E.g. 1->2->3->4->5->6 return 4->5->6 <br>
 * Constraint: <br>
 * - 1 &lt;= n &lt;=100 <br>
 * - 1 &lt;= <i>Node.data</i> &lt;= 100
 * - <i>head</i> is not NULL
 */
public class MiddleNode {
    /**
     * Time Complexity: O(n) <br>
     * Space Complexity: O(1)
     * @param head - Linked list to find out the middle node
     * @return middle node for the linked list
     */
    public LinkedListNode middleNode(LinkedListNode head){
        LinkedListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
