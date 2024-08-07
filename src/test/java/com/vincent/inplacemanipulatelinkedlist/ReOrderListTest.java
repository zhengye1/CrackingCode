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

public class ReOrderListTest {
    static int[][] input = {
            {1, 1, 2, 2, 3, -1, 10, 12},
            {10, 20, -22, 21, -12},
            {1, 1, 1},
            {-2, -5, -6, 0, -1, -4},
            {3, 1, 5, 7, -4, -2, -1, -6}
    };
    static int[][] expected = {
            {1, 12, 1, 10, 2, -1, 2, 3},
            {10, -12, 20, 21, -22},
            {1, 1, 1},
            {-2, -4, -5, -1, -6, 0},
            {3, -6, 1, -1, 5, -2, 7, -4}
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

    ReOrderList reOrderList = new ReOrderList();
    @ParameterizedTest(name = "Test case: {index} => head={0}, expected={1}")
    @MethodSource("generateTestCases")
    public void testReOrderList(LinkedListNode head, LinkedListNode expected) {
        reOrderList.reorderList(head);
        assertEquals(head, expected);
    }
}
