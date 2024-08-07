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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReverseLinkedListTest {
   static  int[][] input = {
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5, 6},
            {3, 2, 1},
            {10},
            {1, 2},
            {}
    };

   static int[][] expected = {
           {5, 4, 3, 2, 1},
           {6,5,4,3,2,1},
           {1,2,3},
           {10},
           {2, 1},
           {}
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
    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
    @ParameterizedTest(name = "Test case: {index} => head={0}, expected={1}")
    @MethodSource("generateTestCases")
    void testReversedLinkedList(LinkedListNode head, LinkedListNode expected) {
        assertEquals(expected, reverseLinkedList.reverseList(head));
    }

}
