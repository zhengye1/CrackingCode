package com.vincent.linkedlist;

import com.vincent.util.LinkedListNode;

/**
 * LeetCode 160 - Easy
 * Given 2 linked list, find the intersection val
 * if no intersect, return 0. <br>
 * O(m + n) time and O(1) space
 */
public class IntersectionOfLinkedList {
    public LinkedListNode getIntersectionNode(LinkedListNode headA, LinkedListNode headB) {
        LinkedListNode currA = headA;
        LinkedListNode currB = headB;
        while (currA != null && currB != null) {
            currA = currA.next;
            currB = currB.next;
        }
        // to check who end first
        int diff = 0;
        if (currA != null) {
            while (currA != null) {
                currA = currA.next;
                diff++;
            }
            currA = headA;
            currB = headB;
            while (diff-- > 0){
                currA = currA.next;
            }
            while (currA != currB) {
                currA = currA.next;
                currB = currB.next;
            }
            return currA;
        }else{
            while (currB != null) {
                currB = currB.next;
                diff++;
            }
            currA = headA;
            currB = headB;
            while (diff-- > 0){
                currB = currB.next;
            }
            while (currA != currB) {
                currA = currA.next;
                currB = currB.next;
            }
            return currB;
        }
    }
}
