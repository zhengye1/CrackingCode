package com.vincent.modifybinarysearch;

/**
 * LeetCode 540 - Medium
 * Given a array <i>nums</i>, all the number will repeat twice except one number, find that number
 */
public class SingleElement {
    public int singleNonDuplicate(int[] nums){
            int left = 0, right = nums.length - 1;
            while (left != right){
                int mid = (left + right) >> 1;
                if ((mid & 1)  == 1) mid--;
                if (nums[mid] != nums[mid + 1]) right = mid;
                else left = mid + 2;
            }
            return nums[left];
    }
}
