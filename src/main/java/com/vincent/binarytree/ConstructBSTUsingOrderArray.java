package com.vincent.binarytree;

import com.vincent.util.TreeNode;

/**
 * LeetCode 105 - Medium <br>
 * Construct the BST by using preorder and inorder
 * LeetCode 106 - Medium
 * Construct the BST by using inorder and postorder
 */
public class ConstructBSTUsingOrderArray {
    int pIndex ;
    int inIndex ;
    int postIndex;
    public TreeNode<Integer> buildTreePreOrderInOrder(int[] preorder, int[] inorder) {
        pIndex = 0;
        inIndex = 0;
        return buildPreOrderInOrderTreeHelper(preorder, inorder, (long) Integer.MAX_VALUE + 1);
    }
    private TreeNode<Integer> buildPreOrderInOrderTreeHelper(int[] preorder, int[] inorder, long stop) {
        if (pIndex == preorder.length) return null;
        if (inorder[inIndex] == stop){
            inIndex++;
            return null;
        }
        int rootVal = preorder[pIndex++];
        TreeNode<Integer> root = new TreeNode<>(rootVal);
        root.left = buildPreOrderInOrderTreeHelper(preorder, inorder, rootVal);
        root.right = buildPreOrderInOrderTreeHelper(preorder, inorder, stop);
        return root;
    }

    public TreeNode<Integer> buildTreePostOrderInOrder(int[] postorder, int[] inorder) {
        postIndex = postorder.length - 1;
        return buildTreePostOrderInOrderHelper(postorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode<Integer> buildTreePostOrderInOrderHelper(int[] postorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        int rootVal = postorder[postIndex--];
        TreeNode<Integer> root = new TreeNode<>(rootVal);
        // find the proper index in the inorder
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                inIndex = i;
                break;
            }
        }

        root.right = buildTreePostOrderInOrderHelper(postorder, inorder, inIndex + 1, inEnd);
        root.left = buildTreePostOrderInOrderHelper(postorder, inorder, inStart, inIndex - 1);
        return root;
    }

}
