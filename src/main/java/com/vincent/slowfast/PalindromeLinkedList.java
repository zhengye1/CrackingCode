package com.vincent.slowfast;

import com.vincent.util.LinkedListNode;

/**
 * LeetCode 234 Easy
 * Given the head of a linked list, your task is to check whether the linked list is a palindrome or not.
 * Return TRUE if the linked list is a palindrome; otherwise, return FALSE. <br>
 * Constraint: <br>
 * 1 &lt;= <i>n</i> &lt;= 10^5
 * 0 &lt;= <i>Node.val</i> &lt;= 9
 * Bonus: O(n) Time and O(1) space complexity.
 */
public class PalindromeLinkedList {
    // Complexity: O(n) Time and O(1) space complexity.
    public boolean isPalindrome(LinkedListNode head){
        if(head.next == null){
            return true;
        }

        // Find the middle of the linked list
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse it
        // now slow is the middle one
        LinkedListNode prev = null;
        while (slow != null){
            LinkedListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // compare the two halves
        while (prev != null){
            if (prev.data != head.data) return false;
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}
