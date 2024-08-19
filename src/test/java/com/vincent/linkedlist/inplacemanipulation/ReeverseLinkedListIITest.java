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

public class ReeverseLinkedListIITest {
    static int[][] input = {
            {1, 2, 3, 4, 5, 6, 7},
            {6, 9, 3, 10, 7, 4, 6},
            {6, 9, 3, 4},
            {6, 2, 3, 6, 9},
            {6, 2}
    };
    static int[] left = {1, 3, 2, 1, 1};
    static int[] right = {5, 6, 4, 3, 2};

    ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
    static int[][] expected = {
            {5, 4, 3, 2, 1, 6, 7},
            {6, 9, 4, 7, 10, 3, 6},
            {6, 4, 3, 9},
            {3, 2, 6, 6, 9},
            {2, 6}
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
            testCases.add(Arguments.of(inputLinkedList.head, left[i], right[i], expectedLinkedList.head));
        }
        return testCases.stream();
    }

    @ParameterizedTest(name = "Test case: {index} => head={0}, left={1}, right={2}, expected={3}")
    @MethodSource("generateTestCases")
    void testReversedLinkedList(LinkedListNode head, int left, int right, LinkedListNode expected) {
        assertEquals(expected, reverseLinkedListII.reverseBetween(head, left, right));
    }

}
