package com.vincent.binarytree;

import com.vincent.util.TreeNode;

/**
 * LeetCode 230 - Medium
 * First thought was traversal all the node and using maxHeap... <br>
 * but if BST is insert/delete multiple time and call multiple time for the kthSmall then that is not a good solution
 */
public class KthSmallestInBST {
    public int kthSmallest(TreeNode<Integer> root, int k) {
        int[] count = {k};
        return kthSmallestHelper(root, count);
    }

    private int kthSmallestHelper(TreeNode<Integer> root, int[] count) {
        if (root == null) return -1;

        int left = kthSmallestHelper(root.left, count);
        if (left != -1) return left;
        count[0]--;
        if (count[0] == 0) return root.data;
        return kthSmallestHelper(root.right, count);
    }
}
