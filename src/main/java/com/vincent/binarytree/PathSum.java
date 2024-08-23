package com.vincent.binarytree;

import com.vincent.util.Tree;
import com.vincent.util.TreeNode;

import java.util.*;

/**
 * LeetCode - Path Sum have 4 question <br>
 * - Path Sum - 112 Easy, just return true or false if target sum can found from root to leaf <br>
 * - Path Sum II - 113 Medium, List all the root to leaf that path sum equals to target sum <br>
 * - Path Sum III - 437 Medium, find the number of path sum that equals to target <br>
 * - Path Sum IV - 666 Medium , check on the LeetCode<br>
 */
public class PathSum {
    /**
     * LeetCode 112 - Easy
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean pathSumI(TreeNode<Integer> root, int targetSum) {
        if (root == null)
            return false;
        return pathSumIHelper(root, root.data, targetSum);
    }

    private boolean pathSumIHelper(TreeNode<Integer> root, int currentSum, int targetSum) {
        if (currentSum == targetSum && root.left == null && root.right == null) {
            return true;
        }

        boolean valid = false;
        if (root.left != null) {
            valid = pathSumIHelper(root.left, currentSum + root.left.data, targetSum);
        }
        if (root.right != null) {
            valid = valid || pathSumIHelper(root.right, currentSum + root.right.data, targetSum);
        }
        return valid;
    }

    List<List<Integer>> result;
    List<Integer> path;

    /**
     * Path Sum II, return all the list path
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSumII(TreeNode<Integer> root, int targetSum) {
        result = new LinkedList<>();
        path = new LinkedList<>();
        recur(root, targetSum);
        return result;
    }

    private void recur(TreeNode<Integer> root, int targetSum) {
        if (root == null)
            return;
        path.add(root.data);
        targetSum -= root.data;
        if (targetSum == 0 && root.left == null && root.right == null) {
            result.add(new LinkedList<>(path));
        }

        recur(root.left, targetSum);
        recur(root.right, targetSum);
        path.removeLast();
    }

    int count = 0;
    int k;
    Map<Long, Integer> map = new HashMap<>();

    /**
     * LeetCode 437 - Medium
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSumIII(TreeNode<Integer> root, int targetSum) {
        k = targetSum;
        preOrder(root, 0L);
        return count;
    }

    private void preOrder(TreeNode<Integer> root, long currSum) {
        if (root == null)
            return;

        // current prefix sum
        currSum += root.data;

        // here is the sum we're looking for
        if (currSum == k) {
            count++;
        }

        // number of times the curr_sum − k has occurred already,
        // determines the number of times a path with sum k
        // has occurred upto the current node
        count += map.getOrDefault(currSum - k, 0);

        // add the current sum into hashmap
        // to use it during the child nodes processing
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        preOrder(root.left, currSum);
        preOrder(root.right, currSum);

        // remove the current sum from the hashmap
        // in order not to use it during
        // the parallel subtree processing
        map.put(currSum, map.get(currSum) - 1);
    }
}
