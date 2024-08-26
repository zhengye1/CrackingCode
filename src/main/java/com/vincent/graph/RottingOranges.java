package com.vincent.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 994 - Medium
 */
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 2) queue.offer(new int[]{row, col});
                else if (grid[row][col] == 1) freshCount++;
            }
        }

        if (freshCount == 0) return 0;
        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasInfect = false;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        freshCount--;
                        hasInfect = true;
                    }
                }
            }
            if (hasInfect) minutes++;
        }

        return freshCount == 0 ? minutes : -1;
    }
}
