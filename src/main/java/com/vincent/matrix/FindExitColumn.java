package com.vincent.matrix;

/**
 * LeetCode 1706
 * Given a matrix, if 1 then the ball fall on right, if -1 then the ball fall on the left
 * find each ball where it fell to
 */
public class FindExitColumn {
    public int[] findBall(int[][] grid){
        int[] result = new int[grid[0].length];
        for (int ball = 0; ball < grid[0].length; ball++) {
            result[ball] = findExitColumn(grid, ball);
        }

        return result;
    }

    private int findExitColumn(int[][] grid, int startingCol) {
        int col = startingCol;
        int column = grid[0].length;
        for (int[] rows : grid) {
            int nextCol = col + rows[col]; // cuz grid[row][col] is either 1 or -1
            if (nextCol < 0 || nextCol >= column || rows[col] != rows[nextCol]) {
                // hit the edge and or not same direction
                return -1;
            }
            col = nextCol;
        }
        return col;
    }
}
