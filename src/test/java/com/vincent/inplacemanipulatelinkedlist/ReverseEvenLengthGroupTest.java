package com.vincent.inplacemanipulatelinkedlist;

import com.vincent.util.LinkedList;
import com.vincent.util.LinkedListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseEvenLengthGroupTest {
    static int[][] input =
        {{1, 2, 3, 4}, {10, 11, 12, 13, 14}, {15}, {16, 17}, {5, 2, 6, 3, 9, 1, 7, 3, 8, 4}, {1, 1, 0, 6},
            {1, 1, 0, 6, 5}};
    static int[][] expected =
        {{1, 3, 2, 4}, {10, 12, 11, 14, 13}, {15}, {16, 17}, {5, 6, 2, 3, 9, 1, 4, 8, 3, 7}, {1, 0, 1, 6},
            {1, 0, 1, 5, 6}};

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

    ReverseEvenLengthGroups evenLengthGroups = new ReverseEvenLengthGroups();
    @ParameterizedTest(name = "Test case: {index} => head={0}, expected={1}")
    @MethodSource("generateTestCases")
    void testReverseEvenLengthGroupTest(LinkedListNode head, LinkedListNode expected){
        assertEquals(expected, evenLengthGroups.reverseEvenLengthGroups(head));
    }
}
