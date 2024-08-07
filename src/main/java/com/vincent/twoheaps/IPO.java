package com.vincent.twoheaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode 502 - Hard
 * Given profits and capital of N projects.
 * Pick a project that has the highest profit but the least capital to make maximum profit.
 */
public class IPO {
    /**
     * Time complexity : O(n log n) and Space complexity : O(n)
     * @param c - initial capital
     * @param k - k projects
     * @param capitals - each i indicates the capital required to start the project
     * @param profits - each i indicates the profit for the project
     * @return
     */
    public int maximumCapital(int c, int k, int[] capitals, int[] profits) {
        Queue<int[]> capitalsHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Queue<Integer> profitHeap = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
        for (int i = 0; i < capitals.length; i++){
            capitalsHeap.offer(new int[] {i, capitals[i]});
        }
        int currentCapital = c;
        int numberOfProject = 0;

        while (numberOfProject < k){
            while (!capitalsHeap.isEmpty() && capitalsHeap.peek()[1] <= currentCapital){
                int[] capital = capitalsHeap.poll();
                profitHeap.offer(profits[capital[0]]);
            }
            if (profitHeap.isEmpty()) break;
            currentCapital += profitHeap.poll();
            numberOfProject++;
        }

        return currentCapital;
    }
}
