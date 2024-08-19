package com.vincent.binarytree;

import com.vincent.util.TreeNode;

/**
 * LeetCode 226 - Easy <br>
 * Hint: post order and reverse it
 */
public class InvertBinaryTree {
    public TreeNode<Integer> invertTree(TreeNode<Integer> root) {
        if (root == null) return null;
        TreeNode<Integer> left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }
}
