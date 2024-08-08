package com.vincent.kwaymerge;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an <i>m</i> number of sorted list in ascending order and an integer <i>k</i>, return the kth smallest number
 * if no element in the list, return 0;
 * if k is greater than total number of the list, return the greatest
 */
public class KSmallestNumberInMSortedList {
    public int kSmallestNumber(List<List<Integer>> lists, int k) {
        // find how many list
        int numberOfList = lists.size();
        // first one contains the value, second one tell me where the value, the last one need is index for that element
        // since list cannot use remove operation
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < numberOfList; i++) {
            if (!lists.get(i).isEmpty()) {
                minHeap.offer(new int[] {lists.get(i).getFirst(), i, 0});
            }
        }
        if (minHeap.isEmpty())
            return 0;

        int i = 0;
        int returnVal;
        do {
            // pop it first
            int[] pair = minHeap.poll();
            returnVal = pair[0];
            int index =pair[2];

            // checking the size
            if (lists.get(pair[1]).size() != index + 1){
                minHeap.offer(new int[]{lists.get(pair[1]).get(pair[2] + 1), pair[1], pair[2] + 1});
            }
            i++;
        } while (i != k && !minHeap.isEmpty());
        return returnVal;
    }
}
