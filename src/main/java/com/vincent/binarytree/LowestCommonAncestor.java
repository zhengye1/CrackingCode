package com.vincent.binarytree;

import com.vincent.util.TreeNode;

/**
 * LeetCode 236/235 - Medium <br>
 * LeetCode 235 is Binary Search Tree <br>
 * LeetCode 236 is Binary Tree <br>
 */
public class LowestCommonAncestor {
    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null || root == p || root == q) return root;
        TreeNode<Integer> left = lowestCommonAncestor(root.left, p, q);
        TreeNode<Integer> right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
