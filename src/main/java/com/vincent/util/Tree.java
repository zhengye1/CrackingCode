package com.vincent.util;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Tree<T> {
    public TreeNode<T> root;

    public Tree(List<TreeNode<T>> listOfNodes) {
        root = createBinaryTree(listOfNodes);
    }

    private TreeNode<T> createBinaryTree(List<TreeNode<T>> listOfNodes) {
        if (listOfNodes.isEmpty()) {
            return null;
        }

        // Create the root node of the binary tree
        TreeNode<T> root = new TreeNode<>(listOfNodes.get(0).data);

        // Create a queue and add the root node to it
        Queue<TreeNode<T>> q = new LinkedList<>();
        q.add(root);

        // Start iterating over the list of listOfNodes starting from the second node
        int i = 1;
        while (i < listOfNodes.size()) {
            // Get the next node from the queue
            TreeNode<T> curr = q.remove();

            // If the node is not null, create a new TreeNode object for its left child,
            // set it as the left child of the current node, and add it to the queue
            if (listOfNodes.get(i) != null) {
                curr.left = new TreeNode<>(listOfNodes.get(i).data);
                q.add(curr.left);
            }

            i++;

            // If there are more listOfNodes in the list and the next node is not null,
            // create a new TreeNode object for its right child, set it as the right child
            // of the current node, and add it to the queue
            if (i < listOfNodes.size() && listOfNodes.get(i) != null) {
                curr.right = new TreeNode<>(listOfNodes.get(i).data);
                q.add(curr.right);
            }

            i++;
        }

        // Return the root of the binary tree
        return root;
    }
    public TreeNode<T> find(T value) {
        return findRec(root, value);
    }
    public TreeNode<T> findRec(TreeNode<T> root, T value) {
        if (root == null || root.data.equals(value))
            return root;

        TreeNode<T> leftResult = findRec(root.left, value);
        if (leftResult != null)
            return leftResult;

        TreeNode<T> rightResult = findRec(root.right, value);
        if (rightResult != null)
            return rightResult;

        return null;
    }
}
