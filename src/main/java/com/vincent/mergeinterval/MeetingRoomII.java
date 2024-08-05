package com.vincent.mergeinterval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.PriorityQueue;

/**
 * LeetCode 253 Medium
 * Given an input array of meeting time interval <i>intervals</i>,
 * where each interval has a start time and end time.
 * Your task is find the minimum number of meeting room to run all the meetings. <br>
 * Constraint: <br>
 * - <i>intervals.length</i> between [1, 10000] <br>
 * - <i>start</i> &lt; <i>end</i> and range between [0, 10000000] <br>
 * Time Complexity: O(n log n) and Space is O(n)
 */
public class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        // sort the intervals using starting time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Using min heap and sort by end time
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for (int[] interval : intervals) {
            // compare the current interval start time is after the end time on the root
            // which means the root one can re-use for this interval
            if (!minHeap.isEmpty() && interval[0] >= minHeap.peek()[1]) {
                minHeap.poll();
            }
            minHeap.offer(interval);
        }

        return minHeap.size();
    }
}
