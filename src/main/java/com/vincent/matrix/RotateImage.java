package com.vincent.matrix;

/**
 * LeetCode 48 - Medium
 * Given a nxn matrix, rotate it clockwise without copy the matrix
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n / 2; row++) {
            for (int col = row; col < n - row - 1; col++) {
                // swap top-left with top-right
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][n - 1 - row];
                matrix[col][n - 1 - row] = temp;

                // swap top-left with bottom-right
                temp = matrix[row][col];
                matrix[row][col] = matrix[n - row - 1][n - col - 1];
                matrix[n - row - 1][n - col - 1] = temp;

                // swap top-left with bottom-left
                temp = matrix[row][col];
                matrix[row][col] = matrix[n - col - 1][row];
                matrix[n - col - 1][row] = temp;
            }
        }
    }
}
