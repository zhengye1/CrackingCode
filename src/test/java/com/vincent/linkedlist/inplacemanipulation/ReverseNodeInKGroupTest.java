package com.vincent.linkedlist.inplacemanipulation;

import com.vincent.util.LinkedList;
import com.vincent.util.LinkedListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseNodeInKGroupTest {
    static List<List<Integer>> inputLists = new ArrayList<>(Arrays.asList(
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8),
            Arrays.asList(3, 4, 5, 6, 2, 8, 7, 7),
            Arrays.asList(1, 2, 3, 4, 5),
            Arrays.asList(1, 2, 3, 4, 5, 6, 7),
            Arrays.asList(1)
    ));
    static List<Integer> k = new ArrayList<>(Arrays.asList(3, 2, 1, 7, 1));
    static List<List<Integer>> expected = new ArrayList<>(Arrays.asList(
            Arrays.asList(3, 2, 1, 6, 5, 4, 7, 8),
            Arrays.asList(4,3,6,5,8,2,7,7),
            Arrays.asList(1,2,3,4,5),
            Arrays.asList(7,6,5,4,3,2,1),
            Arrays.asList(1)
    ));

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        LinkedList<Integer> inputLinkedList;
        LinkedList<Integer> expectedLinkedList;
        for (int i = 0; i < expected.size(); i++) {
            inputLinkedList = new LinkedList<>();
            expectedLinkedList = new LinkedList<>();
            inputLinkedList.createLinkedList(inputLists.get(i));
            expectedLinkedList.createLinkedList(expected.get(i));
            testCases.add(Arguments.of(inputLinkedList.head, k.get(i), expectedLinkedList.head));
        }
        return testCases.stream();
    }

    ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
    @ParameterizedTest(name = "Test case: {index} => head={0}, k={1} expected={2}")
    @MethodSource("generateTestCases")
    void testReverseNodeInKGroup(LinkedListNode head, int k, LinkedListNode expected) {
        assertEquals(expected, reverseNodesInKGroup.reverseKGroups(head, k));
    }
}
