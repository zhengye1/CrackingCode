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

public class LevelOrderTraversalTest {
    static List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
        Arrays.asList(new TreeNode<>(100), new TreeNode<>(50), new TreeNode<>(200), new TreeNode<>(25),
            new TreeNode<>(75), new TreeNode<>(350)),
        Arrays.asList(new TreeNode<>(25), new TreeNode<>(50), null, new TreeNode<>(100), new TreeNode<>(200),
            new TreeNode<>(350)),
        Arrays.asList(new TreeNode<>(350), null, new TreeNode<>(100), null, new TreeNode<>(50), new TreeNode<>(25)),
        Arrays.asList(new TreeNode<>(100)), null);

    static List<List<List<Integer>>> expected = List.of(List.of(List.of(100), List.of(50, 200), List.of(25, 75, 350)),
        List.of(List.of(25), List.of(50), List.of(100, 200), List.of(350)),
        List.of(List.of(350), List.of(100), List.of(50), List.of(25)), List.of(List.of(100)), List.of());

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < listOfTrees.size(); i++) {
            TreeNode<Integer> root;
            if (listOfTrees.get(i) != null){
                Tree<Integer> tree = new Tree<>(listOfTrees.get(i));
                root = tree.root;
            }else{
                root = null;
            }

            testCases.add(Arguments.of(root, expected.get(i)));
        }
        return testCases.stream();
    }

    LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();

    @ParameterizedTest(name = "Test case: {index} => root={0} expected={1}")
    @MethodSource("generateTestCases")
    void levelOrderTraversalRecursionTest(TreeNode<Integer> root, List<List<Integer>> expected) {
        assertIterableEquals(expected, levelOrderTraversal.levelOrderRecursion(root));
    }

    @ParameterizedTest(name = "Test case: {index} => root={0} expected={1}")
    @MethodSource("generateTestCases")
    void levelOrderTraversalIterativeTest(TreeNode<Integer> root, List<List<Integer>> expected) {
        assertIterableEquals(expected, levelOrderTraversal.levelOrderIterative(root));
    }
}
