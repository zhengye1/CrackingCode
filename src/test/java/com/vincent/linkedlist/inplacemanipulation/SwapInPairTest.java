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

public class SwapInPairTest {
    static int[][] input = {
        {9, 0, 8, 2},
        {0, 8, 3, 1, 9, 2, 7},
        {1, 2, 3, 4, 5, 6},
        {10, 20, 30, 40, 50},
        {},
        {1}
    };

    static int[][] expected = {
        {0, 9, 2, 8},
        {8, 0, 1, 3, 2, 9, 7},
        {2, 1, 4, 3, 6, 5},
        {20, 10, 40, 30, 50},
        {},
        {1}
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
            testCases.add(Arguments.of(inputLinkedList.head, expectedLinkedList.head));
        }
        return testCases.stream();
    }
    SwapInPair swapInPair = new SwapInPair();

    @ParameterizedTest(name = "Test case: {index} => head={0}, expected={1}")
    @MethodSource("generateTestCases")
    void testReversedLinkedList(LinkedListNode head, LinkedListNode expected) {
        assertEquals(expected, swapInPair.swapPairs(head));
    }
}
