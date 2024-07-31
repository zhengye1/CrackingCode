package com.vincent.slidewindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 239. Sliding Window Maximum - Hard <br>
 * Given an integer list <i>nums</i>, find all the maximum values in all the contiguous  subarrays of size <i>k</i>. <br>
 * Constraint: <br>
 * - 1 &lt;= <i>nums.length</i> &lt;= 10^5 <br>
 * - -10^4 &lt;= <i>nums[i] </i> &lt;= 10^4 <br>
 * - 1 &lt;= <i>k</i> &lt;= <i>nums.length</i>; <br>
 * Hint: <br>
 * - Use a queue to store the index of the maximum value in each window <br>
 * - Maintain the queue in decreasing order of the value of the index <br>
 * - Remove the index from the queue if it is out of the current window <br>
 */
public class SlidingWindowMaximum {
    // worst case : O(n * w) but general still O(n)
    // Space: O(w) since we only need to store the index of the max value in the current window
    public int[] maxSlidingWindow(int[] nums, int w) {
        // Need a queue to ensure each window contains the index of max value in that index
        if (w == 1)
            return nums; // since windows size 1, which means just itself

        Deque<Integer> currentWindow = new ArrayDeque<>(); // store index of the max value in the current window
        int[] output = new int[nums.length - w + 1];
        // handle the first window
        for (int i = 0; i < w; i++) {
            cleanUp(i, currentWindow, nums);
            currentWindow.add(i); // add the index of the current value to the queue
        }
        output[0] = nums[currentWindow.getFirst()];
        // Begin to slide
        for (int i = w; i < nums.length; i++) {
            cleanUp(i, currentWindow, nums); // clean up the queue
            if (!currentWindow.isEmpty() && currentWindow.getFirst() + w <= i)
                currentWindow.removeFirst();
            currentWindow.add(i); // add the index of the current value to the queue
            output[i - w + 1] = nums[currentWindow.getFirst()];
        }
            return output;
    }

    private void cleanUp(int currentIndex, Deque<Integer> currentWindow, int[] nums) {
        while (!currentWindow.isEmpty() && nums[currentIndex] >= nums[currentWindow.getLast()]) {
            currentWindow.removeLast();
        }
    }
}
