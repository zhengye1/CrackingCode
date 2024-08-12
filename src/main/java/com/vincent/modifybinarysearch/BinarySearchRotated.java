package com.vincent.modifybinarysearch;

/**
 * LeetCode 33 - Medium
 * Given a distinct array and target, the array was rotated in arbitrary times, find the index for the target
 * In O(log n) time
 */
public class BinarySearchRotated {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            if (nums[low] <= nums[mid]){
                // which means left side is sorted
                if (nums[low] <= target && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }else{
                if (nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    public int searchRecursive(int[] nums, int target) {
        return searchRecursiveHelper(nums, 0, nums.length - 1, target);
    }

    public int searchRecursiveHelper(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        if (nums[left] < nums[mid]){
            if (nums[left] <= target && target < nums[mid]) return searchRecursiveHelper(nums, left, mid - 1, target);
            else return searchRecursiveHelper(nums, mid + 1, right, target);
        }else{
            if (nums[mid] < target && target <= nums[right]) return searchRecursiveHelper(nums, mid + 1, right, target);
            else return searchRecursiveHelper(nums, left, mid - 1, target);
        }

    }

}
