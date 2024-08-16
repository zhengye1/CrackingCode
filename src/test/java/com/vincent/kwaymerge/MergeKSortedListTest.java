package com.vincent.kwaymerge;

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

public class MergeKSortedListTest {
    static List<List<List<Integer>>> input =
        Arrays.asList(Arrays.asList(Arrays.asList(21, 23, 42), Arrays.asList(1, 2, 4)),
            Arrays.asList(Arrays.asList(11, 41, 51), Arrays.asList(21, 23, 42)),
            Arrays.asList(Arrays.asList(2), Arrays.asList(1, 2, 4), Arrays.asList(25, 56, 66, 72)),
            Arrays.asList(Arrays.asList(11, 41, 51), Arrays.asList(2), Arrays.asList(2), Arrays.asList(2),
                Arrays.asList(1, 2, 4)),
            Arrays.asList(Arrays.asList(10, 30), Arrays.asList(15, 25), Arrays.asList(1, 7), Arrays.asList(3, 9),
                Arrays.asList(100, 300), Arrays.asList(115, 125), Arrays.asList(10, 70), Arrays.asList(30, 90)));

    static List<List<Integer>> expected =
        Arrays.asList(Arrays.asList(1, 2, 4, 21, 23, 42), Arrays.asList(11, 21, 23, 41, 42, 51),
            Arrays.asList(1, 2, 2, 4, 25, 56, 66, 72), Arrays.asList(1, 2, 2, 2, 2, 4, 11, 41, 51),
            Arrays.asList(1, 3, 7, 9, 10, 10, 15, 25, 30, 30, 70, 90, 100, 115, 125, 300));

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        LinkedList<Integer> inputLinkedList;
        LinkedList<LinkedListNode> expectedLinkedList;
        List<LinkedListNode> inputList;
        for (int i = 0; i < expected.size(); i++) {
            inputList = new ArrayList<>();
            for (int j = 0; j < input.get(i).size(); j++) {
                inputLinkedList = new LinkedList<>();
                inputLinkedList.createLinkedList(input.get(i).get(j));
                inputList.add(inputLinkedList.head);
            }

            expectedLinkedList = new LinkedList<>();
            expectedLinkedList.createLinkedList(expected.get(i));
            testCases.add(Arguments.of(inputList, expectedLinkedList.head));
        }
        return testCases.stream();
    }


    static Stream<Arguments> generateTestCasesArrayVersion() {
        List<Arguments> testCases = new ArrayList<>();
        LinkedList<Integer> inputLinkedList;
        LinkedList<LinkedListNode> expectedLinkedList;
        LinkedListNode[] inputList;
        for (int i = 0; i < expected.size(); i++) {
            inputList = new LinkedListNode[input.get(i).size()];
            for (int j = 0; j < input.get(i).size(); j++) {
                inputLinkedList = new LinkedList<>();
                inputLinkedList.createLinkedList(input.get(i).get(j));
                inputList[j] = inputLinkedList.head;
            }

            expectedLinkedList = new LinkedList<>();
            expectedLinkedList.createLinkedList(expected.get(i));
            testCases.add(Arguments.of(inputList, expectedLinkedList.head));
        }
        return testCases.stream();
    }

    MergeKSortedList mergeKSortedList = new MergeKSortedList();

    @ParameterizedTest(name = "Test case: {index} => lists={0}, expected={1}")
    @MethodSource("generateTestCases")
    void testMergeKSortedList(List<LinkedListNode> lists, LinkedListNode expected) {
        assertEquals(expected, mergeKSortedList.mergeKLists(lists));
    }

    @ParameterizedTest(name = "Test case: {index} => lists={0}, expected={1}")
    @MethodSource("generateTestCasesArrayVersion")
    void testMergeKSortedList(LinkedListNode[] lists, LinkedListNode expected) {
        assertEquals(expected, mergeKSortedList.mergeKLists(lists));
    }
}
