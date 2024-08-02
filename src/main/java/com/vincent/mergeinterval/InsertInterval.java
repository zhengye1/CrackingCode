package com.vincent.mergeinterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 57 - Medium <br>
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).<br>
 * You may assume that the intervals were initially sorted according to their start times. <br>
 */
public class InsertInterval {
    /**
     * No so good since it is O(n log n ) solution
     *
     * @param existingIntervals
     * @param newInterval
     * @return
     */
    public int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
        int[][] newIntervals = new int[existingIntervals.length + 1][2];
        // add the interval first
        for (int i = 0; i < existingIntervals.length; i++) {
            newIntervals[i] = existingIntervals[i];
        }
        newIntervals[existingIntervals.length] = newInterval;
        // move the interval to the proper location first
        for (int i = newIntervals.length - 1; i > 0; i--) {
            if (newIntervals[i][0] < newIntervals[i - 1][0]) {
                //move the interval forward
                int[] temp = newIntervals[i];
                newIntervals[i] = newIntervals[i - 1];
                newIntervals[i - 1] = temp;
            }
        }
        // merge the overlap
        int[][] output = new int[newIntervals.length][2];
        output[0] = newIntervals[0]; // copy the first interval to the output
        int outputIndex = 0;
        for (int i = 1; i < newIntervals.length; i++) {
            if (newIntervals[i][0] <= output[outputIndex][1]) {
                if (newIntervals[i][1] >= output[outputIndex][1]) {
                    output[outputIndex][1] = newIntervals[i][1];
                }
            } else {
                // don't forget to add it to the new list
                outputIndex++;
                output[outputIndex] = newIntervals[i];
            }
        }

        return Arrays.copyOf(output, outputIndex + 1);
    }

    /**
     * O(n) time and O(n) space solutions but runtime is slow...
     *
     * @param existingIntervals
     * @param newInterval
     * @return
     */
    public int[][] insertIntervalUpgrade(int[][] existingIntervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int i = 0;
        int n = existingIntervals.length;
        List<int[]> outputList = new ArrayList<>();
        while (i < n && existingIntervals[i][0] < newStart) {
            outputList.add(existingIntervals[i]);
            i += 1;
        }
        if (outputList.isEmpty() || outputList.getLast()[1] < newStart) {
            outputList.add(newInterval);
        } else {
            outputList.getLast()[1] = Math.max(outputList.getLast()[1], newEnd);
        }
        while (i < n) {
            int[] ei = existingIntervals[i];
            int start = ei[0];
            int end = ei[1];
            if (outputList.getLast()[1] < start) {
                outputList.add(ei);
            } else {
                outputList.getLast()[1] = Math.max(outputList.getLast()[1], end);
            }
            i += 1;
        }
        return outputList.toArray(new int[0][0]);
    }

}
