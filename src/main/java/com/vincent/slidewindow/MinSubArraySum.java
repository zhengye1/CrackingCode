package com.vincent.slidewindow;

/**
 * LeetCode 209 Medium <br>
 * Given a <i>target</i> and int array <i>nums</i>,
 * find the minimum length of a contiguous subarray of which the sum &gt;= target.
 * If there is no answer, return 0 instead.
 */
public class MinSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, minLength = nums.length + 1; // worst length will be the whole array
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;

        }
        return minLength == nums.length + 1 ? 0 : minLength;
    }
}