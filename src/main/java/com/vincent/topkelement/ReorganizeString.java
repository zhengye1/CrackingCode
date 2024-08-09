package com.vincent.topkelement;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode 767 - Medium
 * Given a string, <i>str</i>, rearrange it so that any two adjacent characters are not the same.
 * If such a reorganization of the characters is possible, output any possible valid arrangement.
 * Otherwise, return an empty string.
 */
public class ReorganizeString {
    public String reorganizeString(String s) {
        if (s == null || s.isEmpty() || s.length() == 1)
            return s;
        int[] frequencyMap = new int[26];
        for (char c : s.toCharArray()) {
            frequencyMap[c - 'a']++;
        }
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < frequencyMap.length; i++) {
            if (frequencyMap[i] > 0) {
                maxHeap.offer(new int[] {i, frequencyMap[i]});
            }
        }
        // because the frequency more than half which means no way
        if (maxHeap.peek()[1] > (s.length() + 1) / 2)
            return "";

        // using prev to get the last character
        // so when we add we guarantee the next one is not adjacent
        int[] prev = null;
        char[] result = new char[s.length()];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            // get the top
            int[] current = maxHeap.poll();
            result[index] = (char)(current[0] + 'a');
            index++;
            current[1]--;
            if (prev != null && prev[1] > 0) {
                maxHeap.offer(prev);
            }
            prev = current;
        }
        return new String(result);
    }
}
