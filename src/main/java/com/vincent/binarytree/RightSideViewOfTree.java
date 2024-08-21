package com.vincent.binarytree;

import com.vincent.util.TreeNode;

import java.util.*;

/**
 * LeetCode 199 - Medium
 */
public class RightSideViewOfTree {
    public List<Integer> rightSideViewDFS(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode<Integer> root, int level, List<Integer> result) {
        if (root == null) return;
        if (level == result.size()) result.add(root.data);
        dfs(root.right, level + 1, result);
        dfs(root.left, level + 1, result);
    }

    public List<Integer> rightSideViewBFS(TreeNode<Integer> root) {
        // thinking about the level order traversal
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode<Integer>> queue = new LinkedList<>();
        queue.push(root); //
        while (!queue.isEmpty()) {
            TreeNode<Integer> rightSide = null;
            int stackLen = queue.size();
            for (int i = 0; i < stackLen; i++) {
                TreeNode<Integer> node = queue.removeFirst();
                if (node != null) {
                    rightSide = node;
                    queue.addLast(node.left);
                    queue.addLast(node.right);
                }
            }
            if (rightSide != null) result.add(rightSide.data);
        }
        return result;
    }
}
