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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FlatttenBinaryTreeTest {
    static List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
        Arrays.asList(new TreeNode<>(3), new TreeNode<>(2), new TreeNode<>(17), new TreeNode<>(1), new TreeNode<>(4),
            new TreeNode<>(19), new TreeNode<>(5)),
        Arrays.asList(new TreeNode<>(7), new TreeNode<>(6), new TreeNode<>(5), new TreeNode<>(4), new TreeNode<>(3),
            new TreeNode<>(2), null, new TreeNode<>(1)),
        Arrays.asList(new TreeNode<>(5), new TreeNode<>(4), new TreeNode<>(6), new TreeNode<>(3), new TreeNode<>(2),
            new TreeNode<>(7), new TreeNode<>(8), new TreeNode<>(1), new TreeNode<>(9)),
        Arrays.asList(new TreeNode<>(5), new TreeNode<>(2), new TreeNode<>(1), new TreeNode<>(6), new TreeNode<>(10),
            new TreeNode<>(11), new TreeNode<>(44)),
        Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(5), new TreeNode<>(3), new TreeNode<>(4),
            new TreeNode<>(6)),
        Arrays.asList(new TreeNode<>(-1), new TreeNode<>(-2), null, new TreeNode<>(-5), new TreeNode<>(1),
            new TreeNode<>(2), null, new TreeNode<>(-6)));
    static int[][] expected =
        {{3, 2, 1, 4, 17, 19, 5}, {7, 6, 4, 1, 3, 5, 2}, {5, 4, 3, 1, 9, 2, 6, 7, 8}, {5, 2, 6, 10, 1, 11, 44},
            {1, 2, 3, 4, 5, 6}, {-1, -2, -5, 2, 1, -6}};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < listOfTrees.size(); i++) {
            Tree<Integer> tree = new Tree<>(listOfTrees.get(i));
            testCases.add(Arguments.of(tree.root, expected[i]));
        }
        return testCases.stream();
    }

    FlattenBinaryTree flattenBinaryTree = new FlattenBinaryTree();

    @ParameterizedTest(name = "Test case: {index} => root={0} expected={1}")
    @MethodSource("generateTestCases")
    void flattenBinaryTreeTest(TreeNode<Integer> root, int[] expected) {
        flattenBinaryTree.flatten(root);
        TreeNode<Integer> copy = root;
        while (copy != null) {
            assertNull(copy.left);
            copy = copy.right;
        }

        // now make sure the traversal is correct
        BinaryTreeTraversal treeTraversal = new BinaryTreeTraversal();
        assertArrayEquals(expected,
            treeTraversal.preOrderTraversal(root).stream().mapToInt(Integer::intValue).toArray());
    }

}
