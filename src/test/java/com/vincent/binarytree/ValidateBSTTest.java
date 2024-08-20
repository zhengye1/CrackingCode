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

public class ValidateBSTTest {
    static List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
            Arrays.asList(new TreeNode<>(5), new TreeNode<>(3), new TreeNode<>(2), new TreeNode<>(6), new TreeNode<>(4)),
            Arrays.asList(new TreeNode<>(6), new TreeNode<>(2), new TreeNode<>(5), new TreeNode<>(4), new TreeNode<>(7)),
            Arrays.asList(new TreeNode<>(4), new TreeNode<>(2), new TreeNode<>(5), new TreeNode<>(1), new TreeNode<>(3)),
            Arrays.asList(new TreeNode<>(7), new TreeNode<>(2), new TreeNode<>(5), new TreeNode<>(4), new TreeNode<>(8)),
            Arrays.asList(new TreeNode<>(9), new TreeNode<>(5), new TreeNode<>(7), new TreeNode<>(1), new TreeNode<>(3)),
            Arrays.asList(new TreeNode<>(5), new TreeNode<>(3), new TreeNode<>(8), new TreeNode<>(2), new TreeNode<>(4), null, new TreeNode<>(9))
    );

    static boolean[] expected = {
            false, false, true, false, false, true
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < listOfTrees.size(); i++) {
            Tree<Integer> tree = new Tree<>(listOfTrees.get(i));
            testCases.add(Arguments.of(tree.root,expected[i]));
        }
        return testCases.stream();
    }
    ValidateBST validateBST = new ValidateBST();
    @ParameterizedTest(name = "Test case: {index} => root={0} expected={1}")
    @MethodSource("generateTestCases")
    void validateBSTTest(TreeNode<Integer> root, Boolean expected) {
        assertEquals(expected, validateBST.isValidBST(root));
    }
}
