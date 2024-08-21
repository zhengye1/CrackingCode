package com.vincent.binarytree;

import com.vincent.util.TreeNode;

/**
 * LeetCode 105 - Medium <br>
 * Construct the BST by using preorder and inorder
 */
public class ConstructBSTUsingPreInOrder {
    int pIndex = 0;
    int inIndex = 0;
    public TreeNode<Integer> buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, (long) Integer.MAX_VALUE + 1);
    }
    private TreeNode<Integer> buildTreeHelper(int[] preorder, int[] inorder, long stop) {
        if (pIndex == preorder.length) return null;
        if (inorder[inIndex] == stop){
            inIndex++;
            return null;
        }
        int rootVal = preorder[pIndex++];
        TreeNode<Integer> root = new TreeNode<>(rootVal);
        root.left = buildTreeHelper(preorder, inorder, rootVal);
        root.right = buildTreeHelper(preorder, inorder, stop);
        return root;
    }

}
