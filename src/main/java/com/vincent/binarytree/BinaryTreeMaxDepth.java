package com.vincent.binarytree;

import com.vincent.util.TreeNode;

/**
 * LeetCode 104
 */
public class BinaryTreeMaxDepth {
    public int maxDepth(TreeNode root) {
        return (root == null) ? 0 : 1 + Math.max(maxDepth(root.left) , maxDepth(root.right));
    }
}
