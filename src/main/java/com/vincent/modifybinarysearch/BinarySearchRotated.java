package com.vincent.modifybinarysearch;

/**
 * LeetCode 33 - Medium
 * Given an array and target, the array was rotated in arbitrary times, find the index for the target
 * In O(log n) time
 */
public class BinarySearchRotated {
    public int search(int[] nums, int k) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == k) return mid;
            if (nums[mid] > nums[low]){
                // which means left side is sorted
                if (nums[mid] > k)
                    high = mid - 1;

            }else{
                if (nums[mid] < k)
                    low = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        new BinarySearchRotated().search(new int[]{176, 188, 199, 200 , 1, 2, 3}, 199);
    }
}
