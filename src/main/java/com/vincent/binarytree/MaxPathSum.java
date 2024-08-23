package com.vincent.binarytree;

import com.vincent.util.TreeNode;

/**
 * LeetCode 124 - Hard
 */
public class MaxPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode<Integer> root) {
        maxContribute(root);
        return maxSum;
    }

    /**
     * This method will calculate for the root that max sum from root to children
     *  and meanwhile update the maxSum if current left + current + current right is maximum
     * @param root
     * @return
     */
    private int maxContribute(TreeNode<Integer> root) {
        if (root == null) return 0;
        int left = maxContribute(root.left);
        int right = maxContribute(root.right);
        int maxLeft = 0, maxRight = 0;
        if (left > 0) maxLeft = left;
        if (right > 0) maxRight = right;
        int currentPathSum = root.data + maxLeft + maxRight;
        maxSum = Math.max(maxSum, currentPathSum);
        return root.data + Math.max(maxLeft, maxRight);
    }
}
