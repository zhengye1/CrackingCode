package com.vincent.subset;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 78 - Medium
 */
public class Subset {
    // it will have backtracking method later on
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (n != 0) {
            int subsetCount = (int)Math.pow(2, n);
            for (int i = 0; i < subsetCount; i++) {
                List<Integer> subset = new ArrayList<>();
                for (int j = 0; j < nums.length; j++) {
                    if (getBit(i, j) == 1) {
                        subset.add(nums[j]);
                    }
                }
                result.add(subset);
            }
        } else {
            result.add(new ArrayList<>());
        }
        return result;
    }

    private int getBit(int nums, int bit) {
        int temp = (1 << bit);
        temp = temp & nums;
        return (temp == 0) ? 0 : 1;
    }
}
