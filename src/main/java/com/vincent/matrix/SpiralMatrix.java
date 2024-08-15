package com.vincent.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 54 - Medium
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r = 0, c = -1, direction = 1;
        int rows = matrix.length, cols = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        while (rows > 0 && cols > 0) {
            // traversal column
            for (int cIndex = 0; cIndex < cols; cIndex++) {
                c += direction;
                result.add(matrix[r][c]);
            }
            rows--; // clean up the current row
            for (int rIndex = 0; rIndex < rows; rIndex++) {
                r += direction;
                result.add(matrix[r][c]);
            }
            cols--;
            direction *= -1;
        }
        return result;
    }
}
