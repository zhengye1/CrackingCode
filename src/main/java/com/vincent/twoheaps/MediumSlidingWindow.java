package com.vincent.twoheaps;

import java.util.*;

/**
 * LeetCode 480 - Hard
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the median array for each window position.
 */
public class MediumSlidingWindow {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length - k + 1];

        // record the outgoing number which is not remove in the heap and its frequency
        Map<Integer, Integer> outgoingNum = new HashMap<>();

        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minHeap = new PriorityQueue<>();

        // adding first k element in to maxHeap
        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }

        // adding floor(k/2) element from maxHeap in to minHeap
        for (int i = 0; i < k / 2; i++) {
            minHeap.offer(maxHeap.poll());
        }

        // using balance factor to check do we need to balance two heap
        int balance = 0;
        int i = k; // we start from index k on the new open window;
        while (true) {
            // (k & 1) == 1 means k % 2 == 0, in java bit calculation is faster than modulus calculation
            if ((k & 1) == 1) {
                medians[i - k] = (double)maxHeap.peek(); // if k is odd, the median is the top of maxHeap
            } else {
                // if k is even, the median is the average of top of maxHeap and minHeap
                medians[i - k] = (double)(maxHeap.peek() + minHeap.peek()) * 0.5;
            }

            if (i >= nums.length)
                break;

            // find the outgoing number
            int outNum = nums[i - k];
            
            // find the incoming number;
            int inNum = nums[i];
            i++;

            balance -= (outNum <= maxHeap.peek()) ? 1 : -1;

            // record the frequency for the outgoingMap
            outgoingNum.put(outNum, outgoingNum.getOrDefault(outNum, 0) + 1);
            if (!maxHeap.isEmpty() && inNum <= maxHeap.peek()) {
                balance++; // if the incoming number is smaller than the top of maxHeap, add it to maxHeap
                maxHeap.offer(inNum);
            } else {
                balance--;
                minHeap.offer(inNum);
            }
            if (balance < 0) {
                maxHeap.offer(minHeap.poll());
            } else if (balance > 0) {
                minHeap.offer(maxHeap.poll());
            }

            balance = 0; // reset it

            //check the top in maxHeap and frequencyMap to make sure remove properly
            while (!maxHeap.isEmpty() && outgoingNum.containsKey(maxHeap.peek())
                && outgoingNum.get(maxHeap.peek()) > 0) {
                outgoingNum.put(maxHeap.peek(), outgoingNum.get(maxHeap.poll()) - 1);
            }

            // do the same thing for the minHeap
            while (!minHeap.isEmpty() && outgoingNum.containsKey(minHeap.peek())
                && outgoingNum.get(minHeap.peek()) > 0) {
                outgoingNum.put(minHeap.peek(), outgoingNum.get(minHeap.poll()) - 1);
            }
        }
        return medians;
    }

}
