package com.vincent.twopointer;

/**
 * LeetCode 283 - Easy
 * Given an array, need to move all the zero to the end and keep the order
 * Try to minimize the step as possible
 */
public class MoveZero {
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }
        for(int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
