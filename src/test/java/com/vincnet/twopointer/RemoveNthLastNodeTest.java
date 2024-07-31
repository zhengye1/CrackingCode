package com.vincnet.twopointer;

import com.vincent.twopointer.RemoveNthLastNode;
import com.vincent.util.LinkedListNode;
import com.vincnet.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RemoveNthLastNodeTest {
    RemoveNthLastNode removeNthLastNode = new RemoveNthLastNode();
    int[][] inputs = {
            {23, 89, 10, 5, 67, 39, 70, 28},
            {34, 53, 6, 95, 38, 28, 17, 63, 16, 76},
            {288, 224, 275, 390, 4, 383, 330, 60, 193},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {69, 8, 49, 106, 116, 112, 104, 129, 39, 14, 27, 12}
    };

    int[] n = {4, 1, 6, 9, 11};

    private LinkedListNode buildLinkedListNode(int[] input) {
        LinkedList<Integer> inputLinkedList = new LinkedList<Integer>();
        inputLinkedList.createLinkedList(input);
        return inputLinkedList.head;
    }

    @Test
    void testCas1() {
        removeNthLastNode.removeNthLastNode(buildLinkedListNode(inputs[0]), n[0]);
    }
    @Test
    void testCas2() {
        removeNthLastNode.removeNthLastNode(buildLinkedListNode(inputs[1]), n[1]);
    }
    @Test
    void testCas3() {
        removeNthLastNode.removeNthLastNode(buildLinkedListNode(inputs[2]), n[2]);
    }
    @Test
    void testCas4() {
        removeNthLastNode.removeNthLastNode(buildLinkedListNode(inputs[3]), n[3]);
    }
    @Test
    void testCas5() {
        removeNthLastNode.removeNthLastNode(buildLinkedListNode(inputs[4]), n[4]);
    }
}
