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

public class TwoSumLinkedListTest {
    static int[][] listA = {
        {2, 4, 3},
        {0},
        {9,9,9,9,9,9,9},
        {9}
    };
    static int[][] listB = {
        {5,6,4},
        {0},
        {9,9,9,9},
        {1}
    };
    static int[][] expected = {
        {7, 0, 8},
        {0},
        {8,9,9,9,0,0,0,1},
        {0, 1}
    };
    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        LinkedList<Integer> listALL;
        LinkedList<Integer> listBLL;
        LinkedList<Integer> expectedLL;
        for (int i = 0; i < expected.length; i++){
            expectedLL = new LinkedList<>();
            expectedLL.createLinkedList(expected[i]);
            listALL = new LinkedList<>();
            listALL.createLinkedList(listA[i]);
            listBLL = new LinkedList<>();
            listBLL.createLinkedList(listB[i]);
            testCases.add(Arguments.of(listALL.head, listBLL.head, expectedLL.head));
        }
        return testCases.stream();
    }

    TwoSumLinkedList twoSumLinkedList = new TwoSumLinkedList();
    @ParameterizedTest(name = "Test case: {index} => listA={0}, listB={1} expected={2}")
    @MethodSource("generateTestCases")
    void twoSumLinkedListTest(LinkedListNode listA, LinkedListNode listB, LinkedListNode expected) {
        assertEquals(expected, twoSumLinkedList.addTwoNumbers(listA, listB));
    }

}
