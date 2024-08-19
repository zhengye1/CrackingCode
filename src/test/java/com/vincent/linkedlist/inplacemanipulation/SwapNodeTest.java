package com.vincent.linkedlist.inplacemanipulation;

import com.vincent.util.LinkedList;
import com.vincent.util.LinkedListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwapNodeTest {
    static int[][] input = {
            {1, 2, 3, 4, 5, 6, 7},
            {6, 9, 3, 10, 7, 4, 6},
            {6, 9, 3, 4},
            {6, 2, 3, 6, 9},
            {6, 2}
    };
    static int[] k = {2, 3, 2, 3, 1};

    static int[][] expected = {
            {1,6,3,4,5,2,7},
            {6,9,7,10,3,4,6},
            {6,3,9,4},
            {6,2,3,6,9},
            {2,6}
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        LinkedList<Integer> inputLinkedList;
        LinkedList<Integer> expectedLinkedList;
        for (int i = 0; i < expected.length; i++) {
            inputLinkedList = new LinkedList<>();
            expectedLinkedList = new LinkedList<>();
            inputLinkedList.createLinkedList(input[i]);
            expectedLinkedList.createLinkedList(expected[i]);
            testCases.add(Arguments.of(inputLinkedList.head, k[i], expectedLinkedList.head));
        }
        return testCases.stream();
    }

    SwapNodes swapNodes = new SwapNodes();

    @ParameterizedTest(name = "Test case: {index} => head={0}, k={1}, expected={2}")
    @MethodSource("generateTestCases")
    void testSwapNodeByNode(LinkedListNode head, int k, LinkedListNode expected) {
        assertEquals(expected, swapNodes.swapNodes(head, k));
    }

    @ParameterizedTest(name = "Test case: {index} => head={0}, k={1}, expected={2}")
    @MethodSource("generateTestCases")
    void testSwapNodeByValue(LinkedListNode head, int k, LinkedListNode expected) {
        assertEquals(expected, swapNodes.swapNodesEasySolution(head, k));
    }
}
