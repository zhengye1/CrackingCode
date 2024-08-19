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

public class InvertBinaryTreeTest {
    static List<List<TreeNode<Integer>>> input = Arrays.asList(
            Arrays.asList(new TreeNode<>(100), new TreeNode<>(50), new TreeNode<>(200), new TreeNode<>(25), new TreeNode<>(75), new TreeNode<>(125), new TreeNode<>(350)),
            Arrays.asList(new TreeNode<>(100), new TreeNode<>(50), new TreeNode<>(200), new TreeNode<>(25), new TreeNode<>(110), new TreeNode<>(125), new TreeNode<>(350)),
            Arrays.asList(new TreeNode<>(100), new TreeNode<>(50), new TreeNode<>(200), new TreeNode<>(25), new TreeNode<>(75), new TreeNode<>(90), new TreeNode<>(350)),
            Arrays.asList(new TreeNode<>(100), new TreeNode<>(200), new TreeNode<>(300), new TreeNode<>(400), new TreeNode<>(500)),
            Arrays.asList(new TreeNode<>(350), new TreeNode<>(125), new TreeNode<>(100), new TreeNode<>(75), new TreeNode<>(50), new TreeNode<>(25)),
            Arrays.asList(new TreeNode<>(100)),
            Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), null, new TreeNode<>(3), null, new TreeNode<>(4)),
            Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(3), new TreeNode<>(4), null, null, new TreeNode<>(5)),
            Arrays.asList()
    );

    static List<List<TreeNode<Integer>>> expected = Arrays.asList(
            Arrays.asList(new TreeNode<>(100), new TreeNode<>(200), new TreeNode<>(50), new TreeNode<>(350), new TreeNode<>(125), new TreeNode<>(75), new TreeNode<>(25)),
            Arrays.asList(new TreeNode<>(100), new TreeNode<>(200), new TreeNode<>(50), new TreeNode<>(350), new TreeNode<>(125), new TreeNode<>(110), new TreeNode<>(25)),
            Arrays.asList(new TreeNode<>(100), new TreeNode<>(200), new TreeNode<>(50), new TreeNode<>(350), new TreeNode<>(90), new TreeNode<>(75), new TreeNode<>(25)),
            Arrays.asList(new TreeNode<>(100), new TreeNode<>(300), new TreeNode<>(200), null, null, new TreeNode<>(500), new TreeNode<>(400)),
            Arrays.asList(new TreeNode<>(350), new TreeNode<>(100), new TreeNode<>(125), null, new TreeNode<>(25), new TreeNode<>(50), new TreeNode<>(75)),
            Arrays.asList(new TreeNode<>(100)),
            Arrays.asList(new TreeNode<>(1), null, new TreeNode<>(2), null, new TreeNode<>(3), null, new TreeNode<>(4)),
            Arrays.asList(new TreeNode<>(1), new TreeNode<>(3), new TreeNode<>(2), new TreeNode<>(5), null, null, new TreeNode<>(4)),
            Arrays.asList()
    );
    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            Tree<Integer> tree = new Tree<>(input.get(i));
            Tree<Integer> expectedTree = new Tree<>(expected.get(i));

            testCases.add(Arguments.of(tree.root, expectedTree.root));
        }
        return testCases.stream();
    }

    InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
    @ParameterizedTest(name = "Test case: {index} => root={0} expected={1}")
    @MethodSource("generateTestCases")
    void invertBinaryTreeTest(TreeNode<Integer> root, TreeNode<Integer> expected) {
        assertEquals(expected, invertBinaryTree.invertTree(root));
    }


}
