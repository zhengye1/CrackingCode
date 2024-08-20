package com.vincent.binarytree;

import com.vincent.util.TreeNode;

/**
 * LeetCode 108 - Medium Easy
 * Given a sorted array, construct a balanced BST, which means abs(left.height - right.height) &lt; = 1
 *
 */
public class SortedArrayToBST {
    public TreeNode<Integer> sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode<>(nums[0]);
        return constructBST(nums, 0, nums.length - 1);

    }

    private TreeNode<Integer> constructBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode<Integer> root = new TreeNode<>(nums[mid]);
        root.left = constructBST(nums, start, mid - 1);
        root.right = constructBST(nums, mid + 1, end);
        return root;
    }
}
