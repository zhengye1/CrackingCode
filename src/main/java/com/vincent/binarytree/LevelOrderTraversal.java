package com.vincent.binarytree;

import com.vincent.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode 102 - Medium
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrderIterative(TreeNode<Integer> root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> iterativeResult = new ArrayList<>();
        Deque<TreeNode<Integer>> currentQueue = new LinkedList<>();
        currentQueue.offer(root);
        while (!currentQueue.isEmpty()) {
            int levelSize = currentQueue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode<Integer> node = currentQueue.poll();
                levelNodes.add(node.data);
                if (node.left != null) {
                    currentQueue.offer(node.left);
                }
                if (node.right != null) {
                    currentQueue.offer(node.right);
                }
            }
            iterativeResult.add(levelNodes);
        }
        return iterativeResult;
    }



    public List<List<Integer>> levelOrderRecursion(TreeNode<Integer> root) {
        List<List<Integer>> recursionResult = new ArrayList<>();
        level(root, 0, recursionResult);
        return recursionResult;
    }

    private void level(TreeNode<Integer> root, int level, List<List<Integer>> result) {
        if (root == null)
            return;
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.data);
        if (root.left != null){
            level(root.left, level + 1, result);
        }
        if (root.right != null){
            level(root.right, level + 1, result);
        }
    }
}
