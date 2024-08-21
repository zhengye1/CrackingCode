package com.vincent.binarytree;

import com.vincent.util.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ConstructBSTUsingPreInOrderTest {
    static int[][] pOrder = {{3, 9, 20, 15, 7}, {-1}, {10, 20, 40, 50, 30, 60}, {1, 2, 4, 5, 3, 6}, {1, 2, 4, 7, 3},
        {1, 2, 4, 8, 9, 5, 3, 6, 7}};

    static int[][] iOrder = {{9, 3, 15, 20, 7}, {-1}, {40, 20, 50, 10, 60, 30}, {4, 2, 5, 1, 6, 3}, {4, 2, 7, 1, 3},
        {8, 4, 9, 2, 5, 1, 6, 3, 7}};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < pOrder.length; i++) {
            testCases.add(Arguments.of(pOrder[i], iOrder[i]));
        } return testCases.stream();
    }

    ConstructBSTUsingPreInOrder constructBSTUsingPreInOrder = new ConstructBSTUsingPreInOrder();
    BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();

    @ParameterizedTest(name = "Test case: {index} => preOrder={0} inOrder={1}")
    @MethodSource("generateTestCases")
    void constructBSTUsingPreInOrderTest(int[] pOrder, int[] iOrder) {
        TreeNode<Integer> actual = constructBSTUsingPreInOrder.buildTree(pOrder, iOrder);

        assertArrayEquals(pOrder,
            binaryTreeTraversal.preOrderTraversal(actual).stream().mapToInt(Integer::intValue).toArray());

        assertArrayEquals(iOrder,
            binaryTreeTraversal.inorderTraversal(actual).stream().mapToInt(Integer::intValue).toArray());

    }

}
