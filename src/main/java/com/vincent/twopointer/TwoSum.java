package com.vincent.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode question also can use two pointer
 * Given an array of integers <i>nums</i> and an <i>integer</i> target, return <i>indices</i> of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
public class TwoSum {

    /**
     * Traditional solution, using hashmap to store it
     * Time : O(n)
     * Space: O(n)
     **/
    public int[] twoSumTraditional(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

    /**
     * Two pointer solutions
     * @param nums number array
     * @param target the target want to hit
     * @return <br>indices</br> if found the value, otherwise just empty
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{left, right};
            }
            for (int j = left + 1; j < right; j++) {
                if (nums[left] + nums[j] == target) {
                    return new int[]{left, j};
                }
                if (nums[j] + nums[right] == target) {
                    return new int[]{j, right};
                }
            }
            right--;
        }
        return new int[0];
    }
}
