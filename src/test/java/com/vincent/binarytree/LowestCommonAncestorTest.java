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

public class LowestCommonAncestorTest {
    static List<List<TreeNode<Integer>>> inputTrees = Arrays.asList(
        Arrays.asList(new TreeNode<>(100), new TreeNode<>(50), new TreeNode<>(200), new TreeNode<>(25),
            new TreeNode<>(75), new TreeNode<>(350)),
        Arrays.asList(new TreeNode<>(100), new TreeNode<>(200), new TreeNode<>(75), new TreeNode<>(50),
            new TreeNode<>(25), new TreeNode<>(350)),
        Arrays.asList(new TreeNode<>(350), new TreeNode<>(100), new TreeNode<>(75), new TreeNode<>(50),
            new TreeNode<>(200), new TreeNode<>(25)),
        Arrays.asList(new TreeNode<>(100), new TreeNode<>(50), new TreeNode<>(200), new TreeNode<>(25),
            new TreeNode<>(75), new TreeNode<>(350)),
        Arrays.asList(new TreeNode<>(25), new TreeNode<>(50), new TreeNode<>(75), new TreeNode<>(100),
            new TreeNode<>(200), new TreeNode<>(350)));

    static int[][] inputNodes = {{25, 75}, {50, 350}, {100, 200}, {50, 25}, {350, 200}};
    static int[] expectedNodes = {50, 100, 100, 50, 25};
    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < inputTrees.size(); i++) {
            Tree<Integer> tree = new Tree<>(inputTrees.get(i));
            testCases.add(Arguments.of(tree.root, tree.find(inputNodes[i][0]), tree.find(inputNodes[i][1]), tree.find(expectedNodes[i])));
        }
        return testCases.stream();
    }

    LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
    @ParameterizedTest(name = "Test case: {index} => root={0} p={1} q={2} expected={3}")
    @MethodSource("generateTestCases")
    void lowestCommonAncestorTest(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q, TreeNode<Integer> expected) {
        assertEquals(expected, lowestCommonAncestor.lowestCommonAncestor(root, p, q));
    }
}
