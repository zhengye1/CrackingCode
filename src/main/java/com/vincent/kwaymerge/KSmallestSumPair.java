package com.vincent.kwaymerge;

import java.util.*;

/**
 * LeetCode 373 Medium
 */
public class KSmallestSumPair {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> pairs = new ArrayList<>();
        int listLength = nums1.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // min with k and length 1 because you just need k smallest sums pair... to save the memory
        for (int i = 0; i < Math.min(k, listLength); i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        int counter = 1;

        while (!minHeap.isEmpty() && counter <= k) {
            int[] pair = minHeap.poll();
            int i = pair[1];
            int j = pair[2];
            pairs.add(List.of(nums1[i], nums2[j]));
            int nextElement = j + 1;

            if (nums2.length > nextElement) {
                minHeap.offer(new int[]{nums1[i] + nums2[nextElement], i, nextElement});
            }
            counter++;
        }
        return pairs;
    }
}
