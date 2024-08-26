package com.vincent.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 200 - Medium
 */
public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    dfs(grid, row, col);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') return;
        grid[row][col] = '0'; // change current one to 0
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }


    public int numIslandsIterative(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    processIsland(grid, row, col);
                }
            }
        }
        return count;
    }

    private void processIsland(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = '0';
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            // add all direction
            if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                grid[r - 1][c] = '0';
                queue.offer(new int[]{r - 1, c});
            }
            if (r + 1 < rows && grid[r + 1][c] == '1') {
                grid[r + 1][c] = '0';
                queue.offer(new int[]{r + 1, c});
            }
            if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                grid[r][c - 1] = '0';
                queue.offer(new int[]{r, c - 1});
            }
            if (c + 1 < cols && grid[r][c + 1] == '1') {
                grid[r][c + 1] = '0';
                queue.offer(new int[]{r, c + 1});
            }
        }
    }
}
