package com.vincent.binarytree;

import com.vincent.util.TreeNode;

/**
 * LeetCode 98 - Medium
 *
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode<Integer> root) {
        long[] prev = {Long.MIN_VALUE}; // using long because node value range is [-2^31, 2^31-1] which just int_min
        return isValidBSTHelper(root, prev);
    }

    private boolean isValidBSTHelper(TreeNode<Integer> root, long[] prev) {
        if (root == null) return true;
        if (!isValidBSTHelper(root.left, prev)) return false;
        if (root.data <= prev[0]) return false;
        prev[0] = root.data;
        return isValidBSTHelper(root.right, prev);
    }
}
