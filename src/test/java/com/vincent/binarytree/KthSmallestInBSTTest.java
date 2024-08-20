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

public class KthSmallestInBSTTest {
    static List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
            Arrays.asList(new TreeNode<>(2), new TreeNode<>(1), new TreeNode<>(3)),
            Arrays.asList(new TreeNode<>(3), new TreeNode<>(1), new TreeNode<>(4), null, null, null, new TreeNode<>(10), null),
            Arrays.asList(new TreeNode<>(23), new TreeNode<>(21), new TreeNode<>(24), null, new TreeNode<>(22), null, null),
            Arrays.asList(new TreeNode<>(10), new TreeNode<>(8)),
            Arrays.asList(new TreeNode<>(10), null, new TreeNode<>(18))
    );
    static int[] k = {2, 1, 3, 1, 2};
    static int[] expected = {2, 1, 23, 8, 18};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < listOfTrees.size(); i++) {
            Tree<Integer> tree = new Tree<>(listOfTrees.get(i));
            testCases.add(Arguments.of(tree.root,k[i], expected[i]));
        }
        return testCases.stream();
    }
    KthSmallestInBST kthSmallestInBST = new KthSmallestInBST();
    @ParameterizedTest(name = "Test case: {index} => root={0} k={1} expected={2}")
    @MethodSource("generateTestCases")
    void kthSmallestInBSTTst(TreeNode<Integer> root, int k, int expected) {
        assertEquals(expected, kthSmallestInBST.kthSmallest(root, k));
    }
}
