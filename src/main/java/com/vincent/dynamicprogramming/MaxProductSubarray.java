package com.vincent.dynamicprogramming;

/**
 * LeetCode 152  - Medium
 */
public class MaxProductSubarray {
    public int maxProductDP(int[] nums) {
        // base case
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int lastMin = nums[0], lastMax = nums[0], result = nums[0];
        for (int i = 1; i < n; i++) {
            int minProduct = Math.min(nums[i], Math.min(nums[i] * lastMin, nums[i] * lastMax));
            int maxProduct = Math.max(nums[i], Math.max(nums[i] * lastMin, nums[i] * lastMax));
            lastMin = minProduct;
            lastMax = maxProduct;
            result = Math.max(result, maxProduct);
        }
        return result;
    }

    public int maxProductSubarray(int[] nums) {
        // base case
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int product = 1;
        int maxProduct = nums[0];
        for (int num : nums) {
            product *= num;
            maxProduct = Math.max(maxProduct, product);
            if (num == 0)
                product = 1;
        }
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            product *= nums[i];
            maxProduct = Math.max(maxProduct, product);
            if (nums[i] == 0) product = 1;
        }
        return maxProduct;
    }
}
