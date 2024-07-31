package com.vincent.slowfast;

/**
 * Leetcode 287 Medium <br>
 * Given an array of positive number <i>nums</i> such as in the range [1, n] and there is n + 1 numbers in the array,
 * return the duplicate number, and it only has 1 duplicate <br>
 * Constraint: <br>
 * - 1 &lt;= n &lt; 10^3
 * - <i>nums.length</i> = n + 1
 * - 1 &lt;= <i>nums[i]</i> &lt;= n
 * All the integer unique except 1 duplicate, and it can happen more than once
 */
public class DuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

    // Traditional but need extra space
    public int findDuplicateUsingSpace(int[] nums) {
        boolean[] visited = new boolean[nums.length + 1];
        for (int num : nums) {
            if (!visited[num]) {
                visited[num] = true;
            } else {
                return num;
            }
        }
        return 0;
    }
}
