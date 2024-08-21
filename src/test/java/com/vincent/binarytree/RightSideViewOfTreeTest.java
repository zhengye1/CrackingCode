package com.vincent.binarytree;

import com.vincent.util.Tree;
import com.vincent.util.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class RightSideViewOfTreeTest {
    static List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
            Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(3), null, null, new TreeNode<>(4), new TreeNode<>(5)),
            Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), null, new TreeNode<>(3), null, new TreeNode<>(4)),
            Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(3), new TreeNode<>(4), new TreeNode<>(5), new TreeNode<>(6), new TreeNode<>(7), new TreeNode<>(8)),
            Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(3), new TreeNode<>(4), new TreeNode<>(5), new TreeNode<>(6), null, new TreeNode<>(8)),
            Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), null, new TreeNode<>(3), new TreeNode<>(4))
    );

    static List<List<Integer>> expected = Arrays.asList(
            List.of(1, 3, 5),
            List.of(1, 2, 3, 4),
            List.of(1, 3, 7, 8),
            List.of(1, 3, 6, 8),
            List.of(1, 2, 4)
    );

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < listOfTrees.size(); i++) {
            TreeNode<Integer> root;
            if (listOfTrees.get(i) != null) {
                Tree<Integer> tree = new Tree<>(listOfTrees.get(i));
                root = tree.root;
            } else {
                root = null;
            }

            testCases.add(Arguments.of(root, expected.get(i)));
        }
        return testCases.stream();
    }

    RightSideViewOfTree rightSideViewOfTree = new RightSideViewOfTree();

    @ParameterizedTest(name = "Test case: {index} => root={0} expected={1}")
    @MethodSource("generateTestCases")
    void rightSideViewOfTreeRecursive(TreeNode<Integer> root, List<Integer> expected) {
        assertIterableEquals(expected, rightSideViewOfTree.rightSideViewDFS(root));
    }

    @ParameterizedTest(name = "Test case: {index} => root={0} expected={1}")
    @MethodSource("generateTestCases")
    void rightSideViewOfTreeIterative(TreeNode<Integer> root, List<Integer> expected) {
        assertIterableEquals(expected, rightSideViewOfTree.rightSideViewBFS(root));
    }
}
