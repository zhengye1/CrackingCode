package com.vincent.slowfast;

import com.vincent.util.LinkedListNode;

/**
 * LeetCode 142 - Medium
 * Same as cycle detection, return the first node that in the cycle
 */
public class CycleDectionII {
    public LinkedListNode detectCycle(LinkedListNode head) {
        if (head == null || head.next == null) return null;
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while (true){
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
