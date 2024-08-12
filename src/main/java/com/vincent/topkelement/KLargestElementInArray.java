package com.vincent.topkelement;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode 215 - Medium
 * Given an array <i>nums</i> and integer <i>k</i>, find the kth largest element in the array
 * O(n) solution in time - bonus
 */
public class KLargestElementInArray {
    /**
     * This will be O(n log k)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++){
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++){
            if (nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
