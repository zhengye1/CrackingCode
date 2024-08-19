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

public class DiameterOfTreeTest {
    static List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
        Arrays.asList(new TreeNode<>(2), new TreeNode<>(1), new TreeNode<>(4),
            new TreeNode<>(3), new TreeNode<>(5), new TreeNode<>(6), new TreeNode<>(7)),
        Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(3),
            new TreeNode<>(4), new TreeNode<>(5), new TreeNode<>(6), new TreeNode<>(7),
            new TreeNode<>(8), new TreeNode<>(9)),
        Arrays.asList(new TreeNode<>(45), new TreeNode<>(32), new TreeNode<>(23),
            new TreeNode<>(21), new TreeNode<>(19), new TreeNode<>(18), new TreeNode<>(1)),
        Arrays.asList(new TreeNode<>(5), new TreeNode<>(3), new TreeNode<>(4),
            new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(6), new TreeNode<>(7),
            new TreeNode<>(8), new TreeNode<>(9)),
        Arrays.asList(new TreeNode<>(9), new TreeNode<>(7), null, null, new TreeNode<>(1),
            new TreeNode<>(8), new TreeNode<>(10), null, new TreeNode<>(12)));

    static int[] expected = {
        4, 5, 4, 5, 4
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < listOfTrees.size(); i++) {
            Tree<Integer> tree = new Tree<>(listOfTrees.get(i));
            testCases.add(Arguments.of(tree.root, expected[i]));
        }
        return testCases.stream();
    }


    DiameterOfTree diameterOfTree = new DiameterOfTree();
    @ParameterizedTest(name = "Test case: {index} => root={0} expected={1}")
    @MethodSource("generateTestCases")
    void diameterOfTreeTest(TreeNode<Integer> root, int expected) {
        assertEquals(expected, diameterOfTree.diameterOfBinaryTree(root));
    }
}
