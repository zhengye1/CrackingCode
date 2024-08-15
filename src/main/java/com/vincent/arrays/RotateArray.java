package com.vincent.arrays;

/**
 * LeetCode 189 - Medium
 * Given an array and integer k, return the array that rotate k times in right
 */
public class RotateArray {
    /**
     * Copy solution
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] copy = new int[n << 1]; // create a 2n size array
        System.arraycopy(nums, 0, copy, 0, n); // copy the array from nums to copy with length n
        System.arraycopy(nums, 0, copy, n, n );  // fill the second half
        System.arraycopy(copy, n - k, nums, 0, n ); // copy the thing back to nums
    }

    /**
     * Using the reverse way to reverse thing
     * @param nums
     * @param k
     */
    public void rotateReverse(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        // reverse whole array
        reverse(nums, 0, n - 1);
        // reverse the first part
        reverse(nums, 0, k - 1);
        // reverse the second part
        reverse(nums, k, n - 1);

    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
