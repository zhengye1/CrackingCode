package com.vincent.arrays;

/**
 * LeetCode 238 - Medium
 * Return an array that each element is the product of all other values
 * Solve in linear time
 */
public class ProductOfArrayExceptItself {
    public int[] productExceptItself(int[] nums) {
        int[] result = new int[nums.length];
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }
        return result;
    }
}
