package com.vincent.topkelement;

import java.util.*;

/**
 * LeetCode 347 Medium
 * Given an array of integers, <i>arr</i>>, and an integer, <i>k</i>, return the <i>k</i>
 * most frequent elements.
 * Need at most O(n log n)
 */
public class TopKFrequentElement {
    /**
     * LeetCode version is integer array, we also can make it as List of Integer
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        // [element, frequency]
        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        Map<Integer, Integer> map = new HashMap<>();
        // record the frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // loop the entry
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (i < k) {
                minHeap.offer(entry);
            } else {
                int freq = entry.getValue();
                if (freq > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
            i++;
        }

        int[] result = new int[Math.min(k, minHeap.size())];

        for (i = 0; i < result.length ; i++) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }

    public List<Integer> topKFrequentList(int[] arr, int k){
        int[] results = topKFrequent(arr, k);
        List<Integer> list = new ArrayList<>();
        for (int result:results) {
            list.add(result);
        }
        return list;
    }
}
