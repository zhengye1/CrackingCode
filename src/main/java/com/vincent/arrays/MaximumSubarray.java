package com.vincent.arrays;

/**
 * LeetCode 53 - Medium
 * Given an array, find the maximum sum of subarray
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
           sum = (sum > 0) ? sum + num : num;
           max = Math.max(max, sum);
        }
        return max;
    }
}
