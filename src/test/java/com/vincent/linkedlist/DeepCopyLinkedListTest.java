package com.vincent.linkedlist;

import com.vincent.util.LinkedListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class DeepCopyLinkedListTest {
    static int[][][] input = {
        {{7, -1}, {13, 0}, {11, 4}, {10, 2}, {1, 0}},
        {{1, 1}, {2, 1}},
        {{3,-1},{3,0},{3,-1}}
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            Map<Integer, LinkedListNode> nodesMap = new HashMap<>();
            for (int j = 0; j < input[i].length; j++) {
                nodesMap.put(j, new LinkedListNode(input[i][j][0]));
            }
            for (int j = 0; j < nodesMap.size(); j++) {
                LinkedListNode node = nodesMap.get(j);
                if (j + 1 < nodesMap.size()){
                    node.next = nodesMap.get(j + 1);
                }else{
                    node.next = null;
                }

                if (input[i][j][1] != -1){
                    node.random = nodesMap.get(input[i][j][1]);
                }else{
                    node.random = null;
                }
            }

            testCases.add(Arguments.of(nodesMap.get(0)));
        }
        return testCases.stream();
    }

    DeepCopyLinkedList deepCopyLinkedList = new DeepCopyLinkedList();
    @ParameterizedTest(name = "Test case: {index} => head={0}")
    @MethodSource("generateTestCases")
    void deepCopyLinkedListTest(LinkedListNode head) {

        LinkedListNode copiedList = deepCopyLinkedList.copyRandomList(head);
        // 1. 确保链表不是同一个实例
        assertNotSame(head, copiedList);

        // 2. 确保链表的值和结构相同
        while (head != null && copiedList != null) {
            assertEquals(head.data, copiedList.data); // 确保值相同
            assertEquals(head.random == null ? null : head.random.data,
                copiedList.random == null ? null : copiedList.random.data); // 确保random指针指向的值相同
            head = head.next;
            copiedList = copiedList.next;
        }

        // 3. 确保两个链表的长度相同
        assertNull(head);
        assertNull(copiedList);
    }

}
