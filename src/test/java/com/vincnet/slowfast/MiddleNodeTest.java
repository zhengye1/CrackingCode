package com.vincnet.slowfast;

import com.vincent.slowfast.MiddleNode;
import com.vincnet.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiddleNodeTest {
    MiddleNode middleNode = new MiddleNode();
    int[][] input = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6}, {3, 2, 1}, {10}, {1, 2}};
    int[] output = {3, 4, 2, 10, 2};
    LinkedList<Integer> linkedList;
    @BeforeEach
    void setup(){
       linkedList = new LinkedList<>();
    }
    @Test
    void testCase1(){
        int testCase = 0;
        linkedList.createLinkedList(input[testCase]);
        assertEquals(output[testCase], middleNode.middleNode(linkedList.head).data);
    }

    @Test
    void testCase2(){
        int testCase = 1;
        linkedList.createLinkedList(input[testCase]);
        assertEquals(output[testCase], middleNode.middleNode(linkedList.head).data);
    }

    @Test
    void testCase3(){
        int testCase = 2;
        linkedList.createLinkedList(input[testCase]);
        assertEquals(output[testCase], middleNode.middleNode(linkedList.head).data);
    }

    @Test
    void testCase4(){
        int testCase = 3;
        linkedList.createLinkedList(input[testCase]);
        assertEquals(output[testCase], middleNode.middleNode(linkedList.head).data);
    }

    @Test
    void testCase5(){
        int testCase = 4;
        linkedList.createLinkedList(input[testCase]);
        assertEquals(output[testCase], middleNode.middleNode(linkedList.head).data);
    }
}
