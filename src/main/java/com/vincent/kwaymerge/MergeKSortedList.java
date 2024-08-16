package com.vincent.kwaymerge;

import com.vincent.util.LinkedListNode;

import java.util.List;

/**
 * LeetCode 23 - Hard
 * Given an array of <i>k</i> sorted linked lists,
 * your task is to merge them into a single sorted linked list and return the head of this linked list.
 */
public class MergeKSortedList {
    private LinkedListNode merge2Lists(LinkedListNode head1, LinkedListNode head2) {
        // create the dummy
        LinkedListNode dummy = new LinkedListNode(-1);
        LinkedListNode prev = dummy;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                prev.next = head1;
                head1 = head1.next;
            } else {
                prev.next = head2;
                head2 = head2.next;
            }
            prev = prev.next;
        }
        if (head1 == null) {
            prev.next = head2;
        } else {
            prev.next = head1;
        }

        return dummy.next;
    }

    public LinkedListNode mergeKLists(List<LinkedListNode> lists) {
        if (!lists.isEmpty()) {
            int step = 1;
            while (step < lists.size()) {
                for (int i = 0; i < lists.size() - step; i += step * 2) {
                    lists.set(i, merge2Lists(lists.get(i), lists.get(i + step)));
                }
                step *= 2;
            }
            return lists.getFirst();
        } else {
            return null;
        }
    }

    public LinkedListNode mergeKLists(LinkedListNode[] lists){
        if (lists == null || lists.length == 0) return null;
        return mergeK(lists, 0, lists.length - 1);
    }

    public LinkedListNode mergeK(LinkedListNode[] list, int l, int r){
        if (l == r) return list[l];
        int mid = l + ((r  - l) >> 1);
        LinkedListNode l1 = mergeK(list, l, mid);
        LinkedListNode l2 = mergeK(list, mid + 1, r);
        return merge2Lists(l1, l2);
    }
}
