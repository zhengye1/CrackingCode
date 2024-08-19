package com.vincent.linkedlist.inplacemanipulation;

import com.vincent.util.LinkedListNode;

public class MergeSortLinkedList {
    public LinkedListNode mergeSort(LinkedListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        // find the middle node
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // now the slow is the middle pointer
        LinkedListNode right = slow.next;
        slow.next = null;
        LinkedListNode left = head;
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private LinkedListNode merge(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode head = new LinkedListNode(-1);
        LinkedListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                current.next = l1;
                l1 = l1.next;
            }else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        return head.next;
    }

}
