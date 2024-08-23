package com.vincent.binarytree;

import com.vincent.util.TreeNode;

/**
 * LeetCode 114 - Medium
 * Move all the child to the right
 */
public class FlattenBinaryTree {
    public void flatten(TreeNode<Integer> root) {
        TreeNode<Integer> current = root;
        TreeNode<Integer> last  = null;
        while (current != null) {
            if (current.left != null) {
                last = current.left;
                while (last.right != null){
                    last = last.right;
                }
                last.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}
