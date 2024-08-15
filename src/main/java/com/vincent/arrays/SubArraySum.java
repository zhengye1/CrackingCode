package com.vincent.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 560 - Medium
 * Given an array <i>nums</i> and integer <i>k</i>, return the total number of subarray who sum equals to <i>k</i>. <br>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
