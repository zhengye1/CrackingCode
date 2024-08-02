package com.vincent.mergeinterval;

import java.util.Arrays;

/**
 * Leetcode 56 - Medium <br>
 * We are given an array of closed intervals, <i>intervals</i>,
 * where each interval has a start time and an end time.
 * The input array is sorted with respect to the start times of each interval. (Leetcode is unsorted)<br>
 * Constraint:
 * - 1 &lt;= <i>intervals.length</i> &lt;= 10^4
 * - <i>intervals[i].length</i> == 2
 * - 0 &lt;= <i>intervals[i][0]</i> &lt; <i>intervals[i][1]</i> &lt;= 10^5
 *
 */
public class MergeInterval {
    public int[][] mergeIntervals(int[][] intervals) {
        int[][] output = new int[intervals.length][2];
        output[0] = intervals[0]; // copy the first interval to the output
        int outputIndex = 0;
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] <= output[outputIndex][1]) {
                if (intervals[i][1] >= output[outputIndex][1]) {
                    output[outputIndex][1] = intervals[i][1];
                }
            }else{
                // don't forget to add it to the new list
                outputIndex++;
                output[outputIndex] = intervals[i];
            }
        }

        return Arrays.copyOf(output, outputIndex+1);
    }
}
