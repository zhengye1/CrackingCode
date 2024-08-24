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
        inIndex = postIndex = postorder.length - 1;
        return buildTreePostOrderInOrderHelper(postorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode<Integer> buildTreePostOrderInOrderHelper(int[] postorder, int[] inorder,int stop) {
        if (postIndex < 0) return null;
        if (inorder[inIndex] == stop){
            inIndex--;
            return null;
        }

        TreeNode<Integer> root = new TreeNode<>(postorder[postIndex--]);
        root.right = buildTreePostOrderInOrderHelper(postorder, inorder, root.data);
        root.left = buildTreePostOrderInOrderHelper(postorder, inorder, stop);
        return root;
    }

}
