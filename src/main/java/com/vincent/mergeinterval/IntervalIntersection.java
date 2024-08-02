package com.vincent.mergeinterval;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 986 - Medium <br>
 * For two lists of closed intervals given as input, <i>intervalLista</i> and <i>intervalListb</i>,
 * where each interval has its own start and end time,
 * write a function that returns the intersection of the two interval lists.<br>
 * Constraint:
 * - length for both interval list is [0, 1000]
 * - start[i] and end[i] between [0, 10^9]
 * - end[i] &lt; start[i+1]
 */
public class IntervalIntersection {
    // Time Complexity: O(n + m)
    // Space Complexity: O(n)
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        int firstSize = firstList.length;
        int secondSize = secondList.length;
        List<int[]> result = new ArrayList<>();
        while (i < firstSize && j < secondSize) {
            int startTime = Math.max(firstList[i][0], secondList[j][0]);
            int endTime = Math.min(firstList[i][1], secondList[j][1]);
            if (startTime <= endTime) {
                result.add(new int[] {startTime, endTime});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[0][0]);
    }
}
