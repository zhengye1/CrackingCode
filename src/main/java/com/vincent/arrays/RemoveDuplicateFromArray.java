package com.vincent.arrays;

/**
 * LeetCode 26 - Easy
 */
public class RemoveDuplicateFromArray {
    public int removeDuplicates(int[] nums) {
        int notSameIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[notSameIndex]) {
                nums[++notSameIndex] = nums[i];
            }
        }
        return ++notSameIndex;
    }
}
