package com.vincent.inplacemanipulatelinkedlist;


import com.vincent.util.LinkedListNode;

/**
 * LeetCode 1721 - Medium
 * Given a linked list, and k, swap the kth node from beginning and kth node from the end
 */
public class SwapNodes {
    // Think too much
    // just find the proper node and swap their value ....
    public LinkedListNode swapNodes(LinkedListNode head, int k) {
        // Step 1: Find the k-th node from the beginning
        LinkedListNode first = head;
        LinkedListNode firstPrev = null;
        for (int i = 1; i < k; i++) {
            firstPrev = first;
            first = first.next;
        }

        // Step 2: Find the k-th node from the end
        LinkedListNode second = head;
        LinkedListNode secondPrev = null;
        LinkedListNode curr = first;
        while (curr.next != null) {
            curr = curr.next;
            secondPrev = second;
            second = second.next;
        }

        // Step 3: Swap the nodes
        if (firstPrev != null) {
            firstPrev.next = second;
        } else {
            head = second;
        }

        if (secondPrev != null) {
            secondPrev.next = first;
        } else {
            head = first;
        }

        LinkedListNode tempNext = first.next;
        first.next = second.next;
        second.next = tempNext;

        return head;
    }

    public LinkedListNode swapNodesEasySolution(LinkedListNode head, int k) {
        // Step 1: Find the k-th node from the beginning
        if (head == null || head.next == null) return head;
        int index = 0;
        LinkedListNode curr = head;
        LinkedListNode first = null;
        LinkedListNode second = null;
        while (curr != null) {
            index++;
            if (second != null){
                second = second.next;
            }

            if (index == k){
                first = curr;
                second = head;
            }
            curr = curr.next;
        }

        // swap the data on first and second
        int temp = first.data;
        first.data = second.data;
        second.data = temp;

        return head;
    }
}
