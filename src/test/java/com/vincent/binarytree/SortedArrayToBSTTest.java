package com.vincent.binarytree;

import com.vincent.util.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortedArrayToBSTTest {
    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        int[][] nums = {
                {11, 22, 33, 44, 55, 66, 77, 88},
                {25, 50, 75, 100, 125, 350},
                {1, 2, 3},
                {1, 2, 3, 4},
                {-10, -3, 0, 5, 9},
                {1, 3}
        };

        for (int[] num : nums) {
            testCases.add(Arguments.of(num));
        }
        return testCases.stream();
    }

    SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
    BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();
    @ParameterizedTest(name = "Test case: {index} => nums={0}")
    @MethodSource("generateTestCases")
    void sortedArrayToBSTTest(int[] nums) {
        TreeNode<Integer> actual = sortedArrayToBST.sortedArrayToBST(nums);

        // is balance?
        assertTrue(isBalanced(actual), "Tree is not balanced");
        // is valid BST?
        assertTrue(isValidBST(actual, Integer.MIN_VALUE, Integer.MAX_VALUE), "Tree is not valid BST");

        // in order traversal is same as the input
        assertArrayEquals(nums, binaryTreeTraversal.inorderTraversal(actual).stream().mapToInt(i -> i).toArray());
    }

    private boolean isBalanced(TreeNode<Integer> node) {
        return checkHeight(node) != -1;
    }

    private int checkHeight(TreeNode<Integer> node) {
        if (node == null) return 0;
        int leftHeight = checkHeight(node.left);
        int rightHeight = checkHeight(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private boolean isValidBST(TreeNode<Integer> node, int min, int max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return isValidBST(node.left, min, node.data) && isValidBST(node.right, node.data, max);
    }
}
