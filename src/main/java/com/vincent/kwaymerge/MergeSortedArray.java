package com.vincent.kwaymerge;

/**
 * LeetCode #88 Merge Sorted Array - Easy
 * Given two sorted array,  merge <i>nums2</i> to <i>nums1</i>,
 * <i>m</i> is the number of data element in <i>nums1</i> and <i>n</i> is the number of data element in <i>nums2</i>
 * <i>m + n</i> is the length on <i>nums1</i>
 */
public class MergeSortedArray {
    /**
     * LeetCode version is not sorted, and must change nums1
     * Need O(n + m) solution
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0)
                break; // second list already traversed
            if (p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[p] = nums1[p1--]; // p1-- means get assign the value in p1 first then decrese it
            }else{
                nums1[p] = nums2[p2--];
            }
        }
    }
}
