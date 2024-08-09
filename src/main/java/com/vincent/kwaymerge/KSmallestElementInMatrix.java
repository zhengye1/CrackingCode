package com.vincent.kwaymerge;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode 378 - Medium
 * Find the <i>kth</i> smallest in (n x n) matrix, which each row and column of the matrix is sorted in ascending order <br>
 * Constraint: <br>
 * - Square Matrix <br>
 * - range for <i>n</i> is [1, 100] <br>
 * - range for <i>k</i> is [1, n^2] <br>
 * - range for value in matrix [-10000, 10000]
 */
public class KSmallestElementInMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int n = matrix.length;
        if (k >= n * n)
            return matrix[n - 1][n - 1]; // since that use the last
        for (int i = 0; i < Math.min(n, k); i++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }

        int numbersChecked = 0;
        int smallestElement = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            smallestElement = curr[0];
            int rowIndex = curr[1];
            int colIndex = curr[2];
            numbersChecked++;

            if (numbersChecked == k) {
                break;
            }
            if (colIndex + 1 < matrix[rowIndex].length) {
                minHeap.offer(new int[]{matrix[rowIndex][colIndex + 1], rowIndex, colIndex + 1});
            }
        }
        return smallestElement;
    }



}
