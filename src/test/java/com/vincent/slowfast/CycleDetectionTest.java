package com.vincent.slowfast;

import com.vincent.util.LinkedList;
import com.vincent.util.LinkedListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CycleDetectionTest {
    static int[][] input = { { 2, 4, 6, 8, 10, 12 }, { 1, 3, 5, 7, 9, 11 },
        { 0, 1, 2, 3, 4, 6 }, { 3, 4, 7, 9, 11, 17 }, { 5, 1, 4, 9, 2, 3 }, {}, {1} };
    static int[] pos = { 0, -1, 1, -1, 2, -1, -1 };
    static boolean[] expected = {
        true, false, true, false, true, false
    };

    CycleDetection cycleDetection = new CycleDetection();
    LinkedList<Integer> linkedList;
    @BeforeEach
    void setup(){
        linkedList = new LinkedList<>();
    }

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        LinkedList<Integer> linkedList;
        for (int i = 0; i < expected.length; i++) {
            // create the input linked list
            linkedList = new LinkedList<>();
            linkedList.createLinkedList(input[i]);
            if (pos[i] != -1){
                // create the cycle
                int length = linkedList.getLength(linkedList.head);
                LinkedListNode lastNode = linkedList.getNode(linkedList.head, length - 1);
                lastNode.next = linkedList.getNode(linkedList.head, pos[i]);
            }
            testCases.add(Arguments.of(linkedList.head, expected[i]));
        }
        return testCases.stream();
    }

    @ParameterizedTest(name = "Test case: {index} => listA={0} expected={1}")
    @MethodSource("generateTestCases")
    void cycleDectionTest(LinkedListNode head, boolean expected) {
        assertEquals(expected, cycleDetection.detectCycle(head));
    }

}
