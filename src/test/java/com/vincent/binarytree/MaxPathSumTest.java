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

public class MaxPathSumTest {
    static List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
        Arrays.asList(new TreeNode<>(-8), new TreeNode<>(2), new TreeNode<>(17), new TreeNode<>(1), new TreeNode<>(4), new TreeNode<>(19), new TreeNode<>(5)),
        Arrays.asList(new TreeNode<>(7), new TreeNode<>(3), new TreeNode<>(4), new TreeNode<>(-1), new TreeNode<>(-3)),
        Arrays.asList(new TreeNode<>(-10), new TreeNode<>(9), new TreeNode<>(20), new TreeNode<>(30), new TreeNode<>(16), new TreeNode<>(15), new TreeNode<>(7)),
        Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(3)),
        Arrays.asList(new TreeNode<>(0)),
        Arrays.asList(new TreeNode<>(-10), new TreeNode<>(9), new TreeNode<>(20), null, null, new TreeNode<>(15), new TreeNode<>(7)),
        Arrays.asList(new TreeNode<>(1), new TreeNode<>(-3), new TreeNode<>(3),  new TreeNode<>(5), null, null, new TreeNode<>(-5))
    );

    static int[] expected = {
        41, 14, 64, 6, 0,42, 6
    };
    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < listOfTrees.size(); i++) {
            Tree<Integer> tree = new Tree<>(listOfTrees.get(i));
            testCases.add(Arguments.of(tree.root, expected[i]));
        }
        return testCases.stream();
    }
    MaxPathSum maxPathSum = new MaxPathSum();
    @ParameterizedTest(name = "Test case: {index} => root={0} expected={1}")
    @MethodSource("generateTestCases")
    void maxPathSumTest(TreeNode<Integer> root, int expected) {
        assertEquals(expected, maxPathSum.maxPathSum(root));
    }
}
