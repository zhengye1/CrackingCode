package com.vincent.modifybinarysearch;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * LeetCode 658 - Medium
 * Given a sorted array <i>num</i> , a <i>k</i> and a <i>target</i>,
 * return an output array with length <i>k</i> that store the element closed to <i>target</i>
 * Need O(log n) solution
 */
public class KClosestElement {
    public List<Integer> findClosestElements(int[] nums, int k, int target) {
        int left = 0, right = nums.length - k;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (target - nums[mid] > nums[mid + k] - target) {
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        final int L = left; // this should contain first closest element
        List<Integer> result = new ArrayList<>();
        for (int i = L, j = 0; i < nums.length && j < k; i++, j++) {
            result.add(nums[i]);
        }
        return result;
    }

}
