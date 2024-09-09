package com.vincent.arrays;

/**
 * LeetCode 27 - Easy
 */
public class RemoveValueFromArray {
    public int removeElement(int[] nums, int val) {
        int arraysLength = nums.length;
        int hit = 0;
        for (int i = 0; i < arraysLength;) {
            if (nums[i] == val) {
                hit++;
                nums[i] = nums[--arraysLength];
            }else{
                i++;
            }
        }
        return nums.length - hit;
    }
}
