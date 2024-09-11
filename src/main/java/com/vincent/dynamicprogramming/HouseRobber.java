package com.vincent.dynamicprogramming;

import com.vincent.util.TreeNode;

/**
 * LeetCode 198, 213, 337 - Medium
 */
public class HouseRobber {
    // LeetCode 198, cannot rob the adjacent
    // try O(1) space
    public int robI(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        return robLinear(nums, 0, nums.length - 1);
    }

    // LeetCode 213, cannot rob the adjacent, the beginning and last consider adjacent
    public int robII(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int n = nums.length;
        return Math.max(robLinear(nums, 0, n - 2), robLinear(nums, 1, n - 1));
    }

    private int robLinear(int[] nums, int start, int end) {
        int stateMaximum = 0, lastStateMaximum= 0;
        for (int i = start; i <= end; i++){
            int current = Math.max(stateMaximum , lastStateMaximum + nums[i]);
            lastStateMaximum = stateMaximum;
            stateMaximum = current;
        }
        return stateMaximum;
    }

    // LeetCode 337, cannot rob the child but can rob the grandchild
    public int robIII(TreeNode<Integer> node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return node.data;
        int[] result = dfs(node);
        return Math.max(result[0], result[1]);
    }
    private int[] dfs(TreeNode<Integer> node) {
        if (node == null) return new int[]{0, 0};
        int[] leftSide = dfs(node.left);
        int[] rightSide = dfs(node.right);
        // [includeRoot, excludeRoot]
        int includeRoot = node.data + leftSide[1] + rightSide[1];
        int excludeRoot = Math.max(leftSide[0], leftSide[1]) + Math.max(rightSide[0], rightSide[1]);
        return new int[]{includeRoot, excludeRoot};
    }
}
