package com.vincent.binarytree;

import com.vincent.util.TreeNode;

/**
 * LeetCode 543 Easy
 */
public class DiameterOfTree {
    public int diameterOfBinaryTree(TreeNode<Integer> root) {
        if (root == null)
            return -1;
        return process(root)[1];
    }

    private int[] process(TreeNode<Integer> root) {
        if (root == null)
            return null;
        int[] left = process(root.left);
        int[] right = process(root.right);
        int height = 0;
        int diameter = 0;
        if (left != null) {
            height = left[0] + 1;
            diameter = left[0] + 1;
        }
        if (right != null) {
            height = Math.max(diameter, right[0] + 1);
            diameter += right[0] + 1;
        }
        if (left != null) {
            diameter = Math.max(diameter, left[1]);
        }
        if (right != null) {
            diameter = Math.max(diameter, right[1]);
        }
        return new int[] {height, diameter};
    }

}
