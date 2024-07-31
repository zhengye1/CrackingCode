package com.vincent.twopointer;

import java.util.Arrays;

/**
 * Given an array of integers, <i>nums</i>, and an integer value, <i>target</i>,
 * determine if there are any three integers in <i>nums</i> whose sum is equal to the <i>target</i>,
 * that is, <i>nums[i] + nums[j] + nums[k] == target</i>. Return <i>TRUE</i> if three such integers exist in the array.
 * Otherwise, return <i>FALSE</i>.
 */
public class ThreeSum {
    public boolean threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            int newTarget = target - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int tempTwoSum = nums[left] + nums[right];
                if (newTarget == tempTwoSum) return true;
                if (newTarget < tempTwoSum) right--;
                if (newTarget > tempTwoSum) left++ ;
            }
        }
        return false;
    }
}
