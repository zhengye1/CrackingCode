package com.vincent.linkedlist.inplacemanipulation;

import com.vincent.util.LinkedListNode;

/**
 * LeetCode 2074 - Medium
 * Given a head of linked list, the nodes in it are assigned to each group in sequential manner.
 * The length of these groups follows the sequence of natural number.
 * In other words: The 1st node in group 1, 2nd and 3rd node in group 2, 4th, 5th, 6th nodes in group 3 etc....
 * Task to reverse the even length group and return the modified head
 */
public class ReverseEvenLengthGroups {
    public LinkedListNode reverseEvenLengthGroups(LinkedListNode head) {
        int groupLength = 2;
        int numberOfNode = 0;
        LinkedListNode prev = head, node = head, curr = null, reverse = null, currNext = null, prevNext = null;
        while (prev.next != null) {
            node = prev;
            numberOfNode = 0;
            for (int i = 0; i < groupLength; i++) {
                if (node.next == null) break;
                numberOfNode++;
                node = node.next;
            }
            if (numberOfNode % 2 != 0){
                prev = node;
            }else{
                // reverse
                reverse = node.next;
                curr = prev.next;
                for (int j = 0; j < numberOfNode; j++) {
                    currNext = curr.next;
                    curr.next = reverse;
                    reverse = curr;
                    curr = currNext;
                }
                prevNext = prev.next;
                prev.next = node;
                prev = prevNext;
            }
            groupLength++;
        }
        return head;
    }
}
