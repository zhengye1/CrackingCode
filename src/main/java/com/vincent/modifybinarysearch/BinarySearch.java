package com.vincent.modifybinarysearch;

/**
 * LeetCode 704 - Easy
 */
public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        int left = 0, right  = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public int binarySearchRecursive(int[] nums, int target) {
        return binarySearchRecursiveHelper(nums, 0, nums.length - 1, target);
    }
    public int binarySearchRecursiveHelper(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        if (target < nums[mid]) return binarySearchRecursiveHelper(nums, 0, mid - 1, target);
        else return binarySearchRecursiveHelper(nums, mid + 1, right, target);
    }
}
