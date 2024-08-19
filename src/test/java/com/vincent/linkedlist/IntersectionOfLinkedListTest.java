package com.vincent.linkedlist;

import com.vincent.util.LinkedList;
import com.vincent.util.LinkedListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntersectionOfLinkedListTest {
    static int[][] expected = {
        {8, 4, 5},
        {2, 4},
        {}
    };
    static int[][] listA = {
        {4, 1},
        {1, 9, 1},
        {2, 6, 4}
    };

    static int[][] listB = {
        {5, 6, 1},
        {3},
        {1, 5}
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
            // make a copy and link the intersection
            LinkedListNode copy = listALL.head;
            while(copy.next != null){
                copy = copy.next;
            }
            copy.next = expectedLL.head;
            listBLL = new LinkedList<>();
            listBLL.createLinkedList(listB[i]);
            copy = listBLL.head;
            while(copy.next != null){
                copy = copy.next;
            }
            copy.next = expectedLL.head;
            testCases.add(Arguments.of(listALL.head, listBLL.head, expectedLL.head));
        }

        return testCases.stream();
    }

    IntersectionOfLinkedList intersectionOfLinkedList = new IntersectionOfLinkedList();

    @ParameterizedTest(name = "Test case: {index} => listA={0}, listB={1} expected={2}")
    @MethodSource("generateTestCases")
    void intersectionOfLinkedListTest(LinkedListNode listA, LinkedListNode listB, LinkedListNode expected) {
        assertEquals(expected, intersectionOfLinkedList.getIntersectionNode(listA, listB));
    }


}
