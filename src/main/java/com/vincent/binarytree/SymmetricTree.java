package com.vincent.binarytree;

import com.vincent.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * LeetCode 101 - Easy
 * Recursive and iterative
 */
public class SymmetricTree {
    public boolean isSymmetricIterative(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> queue = new LinkedList<>();
        if (root == null) return true;
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode<Integer> left = queue.poll();
            TreeNode<Integer> right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (!Objects.equals(left.data, right.data)) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    public boolean isSymmetricRecursive(TreeNode<Integer> root) {
        if (root == null) return true;
        return isSymmetricRecursiveHelper(root.left, root.right);
    }


    private boolean isSymmetricRecursiveHelper(TreeNode<Integer> left, TreeNode<Integer> right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (!Objects.equals(left.data, right.data)) return false;
        return isSymmetricRecursiveHelper(left.left, right.right) && isSymmetricRecursiveHelper(right.left, left.right);
    }
}
