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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SymmetricTreeTest {
    static List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
        Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(2),
            new TreeNode<>(3), new TreeNode<>(4), new TreeNode<>(4), new TreeNode<>(3)),
        Arrays.asList(new TreeNode<>(18), new TreeNode<>(21), new TreeNode<>(21),
            new TreeNode<>(47), new TreeNode<>(20), new TreeNode<>(21), new TreeNode<>(47)),
        Arrays.asList(new TreeNode<>(25), new TreeNode<>(4), new TreeNode<>(67),
            new TreeNode<>(2), new TreeNode<>(3), new TreeNode<>(3), new TreeNode<>(2)),
        Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(2),
            new TreeNode<>(3), null, null, new TreeNode<>(3)),
        Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(2), null,
            new TreeNode<>(3), new TreeNode<>(3), null, new TreeNode<>(4),
            new TreeNode<>(5), new TreeNode<>(5), new TreeNode<>(4)));
    static boolean[] expected = {true, false, false, true, true};


    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < listOfTrees.size(); i++) {
            Tree<Integer> tree = new Tree<>(listOfTrees.get(i));
            testCases.add(Arguments.of(tree.root, expected[i]));
        }
        return testCases.stream();
    }

    SymmetricTree symmetricTree = new SymmetricTree();

    @ParameterizedTest(name = "Test case: {index} => root={0} expected={1}")
    @MethodSource("generateTestCases")
    void testSymmetricTreeRecursive(TreeNode<Integer> root, boolean expected) {
        assertEquals(expected, symmetricTree.isSymmetricRecursive(root));
    }


    @ParameterizedTest(name = "Test case: {index} => root={0} expected={1}")
    @MethodSource("generateTestCases")
    void testSymmetricTreeIterative(TreeNode<Integer> root, boolean expected) {
        assertEquals(expected, symmetricTree.isSymmetricIterative(root));
    }
}
