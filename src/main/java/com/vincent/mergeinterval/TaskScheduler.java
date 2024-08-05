package com.vincent.mergeinterval;

import java.util.*;

/**
 * LeetCode 621 - Medium
 * Given a character array <i>tasks</i>, which each character represent a unique task
 * and a positive integer <i>n</i> that represents the cooling period between any two identical tasks.
 * Each task required one unit to perform and the CPU must wait for at least <i>n</i> units of time
 * before it can repeat the same task. During the cooling period, the CPU can perform other task or remain idle. <br>
 * Constraint: <br>
 * - 1 &lt;= <i>task.length</i> &lt;= 1000
 * - 0 &lt;= <i>n</i> &lt;= 100
 * - <i>tasks</i> consists of upper English letter
 */
public class TaskScheduler {
    /**
     * This solution was O(n log n) due to java sort method for the map
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // adding each frequency in
        for (Character c : tasks) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> sortedFrequency = new ArrayList<>(frequencyMap.entrySet());
        sortedFrequency.sort(Map.Entry.comparingByValue(Comparator.naturalOrder()));

        int maxFrequency = sortedFrequency.getLast().getValue();
        sortedFrequency.removeLast();

        // for example, have 3 'A' and n is 2, which means A () () A () () A, 4  idle time which is (3 - 1) * 2 = 4
        int idleTime = (maxFrequency - 1) * n;

        while(!sortedFrequency.isEmpty() && idleTime > 0) {
            idleTime -= Math.min(maxFrequency - 1, sortedFrequency.getLast().getValue());
            sortedFrequency.removeLast();
        }

        idleTime = Math.max(0, idleTime);
        return idleTime + tasks.length;
    }

    /** This solution is the O(n) solution
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastIntervalLinearTime(char[] tasks, int n) {
        // initialize the character array
        int[] frequency = new int[26];
        for (Character c : tasks) {
            frequency[c - 'A']++;
        }

        // find the highest frequency task
        int max = 0;
        for (int i : frequency) {
            max = Math.max(max, i);
        }

        // find how many tasks have the highest frequency
        int total = 0;
        for (int i : frequency) {
            total += (max == i) ? 1 : 0;
        }

        // max - 1 means highest frequency group the last job don't need cooling period
        // n + 1 means each job need n cooling period + 1 time unit for task
        return Math.max(tasks.length, (max - 1) * (n + 1) + total);
    }
}
