package com.vincent.matrix;

import java.util.Arrays;

/**
 * LeetCode 73 - Medium
 */
public class MatrixSetZero {
    public void setZeroes(int[][] matrix) {
        // construct two array for marking
        int[] columnMarks = new int[matrix[0].length];
        int[] rowMarks = new int[matrix.length];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    columnMarks[c] = 1; // use 1 to mark
                    rowMarks[r] = 1;
                }
            }
        }

        for (int c = 0; c < columnMarks.length; c++) {
            if (columnMarks[c] == 1) {
                for (int r = 0; r < matrix.length; r++) {
                    matrix[r][c] = 0;
                }
            }
        }

        for (int r = 0; r < rowMarks.length; r++) {
            if (rowMarks[r] == 1) {
                Arrays.fill(matrix[r], 0);
            }
        }
    }

    public int[][] setZerosWithReturn(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        boolean firstRowZero = false; // to check first row contains zero

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (matrix[r][c] == 0) {
                    // we push the first row to 0 on column i
                    matrix[0][c] = 0;
                    // we push the first column on the row to 0 except don't touch the first row
                    if (r > 0) {
                        matrix[r][0] = 0;
                    }else{
                        firstRowZero = true;
                    }
                }
            }
        }
        // traverse the thing again
        for (int r = 1; r < row; r++) {
            for (int c = 1; c < column; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        // if[0,0] is 0 then each row 0 is 0
        if (matrix[0][0] == 0) {
            for (int r = 0; r < row; r++) {
               matrix[r][0] = 0;
            }
        }

        if (firstRowZero) {
            for (int c = 0; c < column; c++) {
                matrix[0][c] = 0;
            }
        }

        return matrix;
    }
}
