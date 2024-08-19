package com.vincent.binarytree;

import com.vincent.util.Tree;
import com.vincent.util.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class BinaryTreeTraversalTest {
    static Object[][] input = {
            {7, 9, 11, 13, 15},
            {1, null, 2, 3},
            {},
            {1}
    };
    static int[][] inOrderExpected = {{13, 9, 15, 7, 11}, {1, 3, 2}, {}, {1}};

    static int[][] preOrderExpected = {{7, 9, 13, 15, 11}, {1, 2, 3}, {}, {1}};


    static int[][] postOrderExpected = {{13, 15, 9, 11, 7}, {3, 2, 1}, {}, {1}};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            List<TreeNode<Integer>> listofNodes = new ArrayList<>();
            for (int j = 0; j < input[i].length; j++) {
                if(input[i][j] != null) {
                    listofNodes.add(new TreeNode<>((int)input[i][j]));
                }else{
                    listofNodes.add(null);
                }
            }
            Tree<Integer> tree = new Tree<>(listofNodes);

            // create the list
            List<Integer> inOrderExpectedList = new ArrayList<>();
            for (int j = 0; j < inOrderExpected[i].length; j++) {
                inOrderExpectedList.add(inOrderExpected[i][j]);
            }
            // create the list
            List<Integer> preOrderExpectedList = new ArrayList<>();
            for (int j = 0; j < preOrderExpected[i].length; j++) {
                preOrderExpectedList.add(preOrderExpected[i][j]);
            }
            // create the list
            List<Integer> postOrderExpectedList = new ArrayList<>();
            for (int j = 0; j < postOrderExpected[i].length; j++) {
                postOrderExpectedList.add(postOrderExpected[i][j]);
            }
            testCases.add(Arguments.of(tree.root, inOrderExpectedList, preOrderExpectedList, postOrderExpectedList));
        }
        return testCases.stream();
    }

    BinaryTreeTraversal traversal = new BinaryTreeTraversal();


    @ParameterizedTest(name = "Test case: {index} => root={0} inOrderExpectedList={1} preOrderExpectedList={2} postOrderExpected={3}")
    @MethodSource("generateTestCases")
    void traversalTest(TreeNode<Integer> root, List<Integer> inOrderExpected, List<Integer> preOrderExpected, List<Integer> postOrderExpected) {
        assertIterableEquals(inOrderExpected, traversal.inorderTraversal(root));
        assertIterableEquals(preOrderExpected, traversal.preOrderTraversal(root));
        assertIterableEquals(postOrderExpected, traversal.postOrderTraversal(root));

    }

    @ParameterizedTest(name = "Test case: {index} => root={0} inOrderExpectedList={1} preOrderExpectedList={2} postOrderExpected={3}")
    @MethodSource("generateTestCases")
    void traversalIterativeTest(TreeNode<Integer> root, List<Integer> inOrderExpected, List<Integer> preOrderExpected, List<Integer> postOrderExpected) {
        assertIterableEquals(inOrderExpected, traversal.inorderTraversalIterative(root));
        assertIterableEquals(preOrderExpected, traversal.preOrderTraversalIterative(root));
        assertIterableEquals(postOrderExpected, traversal.postOrderTraversalIterative(root));
    }


}
