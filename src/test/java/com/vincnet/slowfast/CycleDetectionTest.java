package com.vincnet.slowfast;

import com.vincent.slowfast.CycleDetection;
import com.vincent.util.LinkedListNode;
import com.vincnet.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CycleDetectionTest {
    int[][] input = { { 2, 4, 6, 8, 10, 12 }, { 1, 3, 5, 7, 9, 11 },
        { 0, 1, 2, 3, 4, 6 }, { 3, 4, 7, 9, 11, 17 }, { 5, 1, 4, 9, 2, 3 }, {}, {1} };
    int[] pos = { 0, -1, 1, -1, 2, -1, -1 };

    CycleDetection cycleDetection = new CycleDetection();
    LinkedList<Integer> linkedList;
    @BeforeEach
    void setup(){
        linkedList = new LinkedList<>();
    }
    @Test
    void testCase1(){
        int testCase = 0;
        linkedList.createLinkedList(input[testCase]);
        if (pos[testCase] != -1) {
            int length = linkedList.getLength(linkedList.head);
            LinkedListNode lastNode = linkedList.getNode(linkedList.head, length - 1);
            lastNode.next = linkedList.getNode(linkedList.head, pos[testCase]);
        }
        assertTrue(cycleDetection.detectCycle(linkedList.head));
    }
    @Test
    void testCase2(){
        int testCase = 1;
        linkedList.createLinkedList(input[testCase]);
        if (pos[testCase] != -1) {
            int length = linkedList.getLength(linkedList.head);
            LinkedListNode lastNode = linkedList.getNode(linkedList.head, length - 1);
            lastNode.next = linkedList.getNode(linkedList.head, pos[testCase]);
        }
        assertFalse(cycleDetection.detectCycle(linkedList.head));
    }
    @Test
    void testCase3(){
        int testCase = 2;
        linkedList.createLinkedList(input[testCase]);
        if (pos[testCase] != -1) {
            int length = linkedList.getLength(linkedList.head);
            LinkedListNode lastNode = linkedList.getNode(linkedList.head, length - 1);
            lastNode.next = linkedList.getNode(linkedList.head, pos[testCase]);
        }
        assertTrue(cycleDetection.detectCycle(linkedList.head));
    }
    @Test
    void testCase4(){
        int testCase = 3;
        linkedList.createLinkedList(input[testCase]);
        if (pos[testCase] != -1) {
            int length = linkedList.getLength(linkedList.head);
            LinkedListNode lastNode = linkedList.getNode(linkedList.head, length - 1);
            lastNode.next = linkedList.getNode(linkedList.head, pos[testCase]);
        }
        assertFalse(cycleDetection.detectCycle(linkedList.head));
    }
    @Test
    void testCase5(){
        int testCase = 4;
        linkedList.createLinkedList(input[testCase]);
        if (pos[testCase] != -1) {
            int length = linkedList.getLength(linkedList.head);
            LinkedListNode lastNode = linkedList.getNode(linkedList.head, length - 1);
            lastNode.next = linkedList.getNode(linkedList.head, pos[testCase]);
        }
        assertTrue(cycleDetection.detectCycle(linkedList.head));
    }
    @Test
    void testCase6(){
        int testCase = 5;
        linkedList.createLinkedList(input[testCase]);
        if (pos[testCase] != -1) {
            int length = linkedList.getLength(linkedList.head);
            LinkedListNode lastNode = linkedList.getNode(linkedList.head, length - 1);
            lastNode.next = linkedList.getNode(linkedList.head, pos[testCase]);
        }
        assertFalse(cycleDetection.detectCycle(linkedList.head));
    }
    @Test
    void testCase7(){
        int testCase = 6;
        linkedList.createLinkedList(input[testCase]);
        if (pos[testCase] != -1) {
            int length = linkedList.getLength(linkedList.head);
            LinkedListNode lastNode = linkedList.getNode(linkedList.head, length - 1);
            lastNode.next = linkedList.getNode(linkedList.head, pos[testCase]);
        }
        assertFalse(cycleDetection.detectCycle(linkedList.head));
    }
}
