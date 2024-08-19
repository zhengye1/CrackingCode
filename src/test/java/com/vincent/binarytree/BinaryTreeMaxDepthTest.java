package com.vincent.binarytree;

import com.vincent.util.Tree;
import com.vincent.util.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeMaxDepthTest {
    static Object[][] input = {
            {3, 9, 20, null, null, 15, 7},
            {1, null, 2}
    };
    static int[] expected = {3, 2};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            List<TreeNode<Integer>> listofNodes = new ArrayList<>();
            for (int j = 0; j < input[i].length; j++) {
                if(input[i][j] != null) {
                    listofNodes.add(new TreeNode<>((int)input[i][j]));
                }else{
                    listofNodes.add(null);
                }
            }
            Tree<Integer> tree = new Tree<>(listofNodes);

            testCases.add(Arguments.of(tree.root, expected[i]));
        }
        return testCases.stream();
    }
    BinaryTreeMaxDepth binaryTreeMaxDepth = new BinaryTreeMaxDepth();
    @ParameterizedTest(name = "Test case: {index} => root={0} expected={1}")
    @MethodSource("generateTestCases")
    void binaryTreeMaxDepthTest(TreeNode<Integer> root, int expected) {
        assertEquals(expected, binaryTreeMaxDepth.maxDepth(root));
    }
}
