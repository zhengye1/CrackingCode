package com.vincent.twoheaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode 295 Hard
 * Given a list of operation, it can always return the medium of the stream
 */
public class MedianOfStream {
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public MedianOfStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void insertNum(int num) {
        // always insert to max heap first
        maxHeap.offer(num);

        if (!minHeap.isEmpty() && !maxHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
        }

        // check the size
        if (minHeap.size() > maxHeap.size() + 1){
            maxHeap.offer(minHeap.poll());
        }

        if (maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        int size = maxHeap.size() + minHeap.size();
        if (size % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek()) * 1.0 / 2;
        } else {
            return (maxHeap.size() > minHeap.size())? maxHeap.peek() : minHeap.peek();
        }
    }

}
