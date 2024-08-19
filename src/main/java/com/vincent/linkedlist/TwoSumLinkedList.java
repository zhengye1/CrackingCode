package com.vincent.linkedlist;

import com.vincent.util.LinkedListNode;

/**
 * LeetCode 2 - Medium
 * Given two linked list, return the sum in linked list <br>
 * 2 -> 4 -> 3  + 5 -> 6 -> 4 =  7 -> 0 -> 8 due to 342 + 465 = 807
 */
public class TwoSumLinkedList {
    public LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
        int carry = 0;
        LinkedListNode result = new LinkedListNode(0);
        LinkedListNode tail = result;
        while (l1 != null || l2 != null || carry > 0) {
            int sum = (l1 == null ? 0 : l1.data) + (l2 == null ? 0 : l2.data) + carry;
            tail.next = new LinkedListNode(sum % 10);
            tail = tail.next;
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return result.next;
    }
}
