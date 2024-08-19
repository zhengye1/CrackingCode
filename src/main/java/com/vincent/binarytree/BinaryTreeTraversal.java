package com.vincent.binarytree;

import com.vincent.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode 94 - InOreder <br>
 * LeetCode 144 - PreOrder <br>
 * LeetCode 145 - PostOrder
 * Recursive is easy.. but now think about the iteration one?
 */
public class BinaryTreeTraversal {
    public List<Integer> inorderTraversal(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalHelper(root, list);
        return list;
    }

    private void inorderTraversalHelper(TreeNode<Integer> root, List<Integer> list) {
        if (root == null) return;
        inorderTraversalHelper(root.left, list);
        list.add(root.data);
        inorderTraversalHelper(root.right, list);
    }

    // inorder is left -> root -> right
    // hint using deque ...
    public List<Integer> inorderTraversalIterative(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode<Integer> pop = stack.pop();
            list.add(pop.data);
            root = pop.right;
        }
        return list;
    }

    public List<Integer> preOrderTraversal(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        preOrderTraversalHelper(root, list);
        return list;
    }

    private void preOrderTraversalHelper(TreeNode<Integer> root, List<Integer> list) {
        if (root == null) return;
        list.add(root.data);
        preOrderTraversalHelper(root.left, list);
        preOrderTraversalHelper(root.right, list);
    }

    public List<Integer> preOrderTraversalIterative(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.data);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }

    public List<Integer> postOrderTraversal(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        postOrderTraversalHelper(root, list);
        return list;
    }

    private void postOrderTraversalHelper(TreeNode<Integer> root, List<Integer> list) {
        if (root == null) return;
        postOrderTraversalHelper(root.left, list);
        postOrderTraversalHelper(root.right, list);
        list.add(root.data);
    }

    public List<Integer> postOrderTraversalIterative(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
        TreeNode<Integer> prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || root.right == prev) {
                list.add(root.data);
                stack.pop();
                prev = root; // 记录访问过的节点
                root = null; // 防止再次进入左子树
            } else {
                root = root.right; // 处理右子树
            }
        }
        return list;
    }
}
