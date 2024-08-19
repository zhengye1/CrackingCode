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

public class MergeSortLinkedListTest {
    static int[][] input =
        {
            {5, 1, 6, 2, 3, 4},
            {90,67,-89,11,12,34,-56,-100,47},
            {-231,-59,-20,-532,-659,486},
            {-1,5,3,4,0},
            {4,2,1,3},
            {44,89,12,90,111,341,5}
        };

    static int[][] expected = {
        {1, 2, 3, 4, 5, 6},
        {-100,-89,-56,11,12,34,47,67,90},
        {-659,-532,-231,-59,-20,486},
        {-1,0,3,4,5},
        {1, 2, 3, 4},
        {5,12,44,89,90,111,341}
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

    MergeSortLinkedList mergeSortLinkedList = new MergeSortLinkedList();

    @ParameterizedTest(name = "Test case: {index} => input={0} expected={1}")
    @MethodSource("generateTestCases")
    void mergeSortLinkedList(LinkedListNode input, LinkedListNode expected) {
        assertEquals(expected, mergeSortLinkedList.mergeSort(input));
    }
}
