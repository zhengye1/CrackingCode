package com.vincent.dynamicprogramming;

/**
 * LeetCode 542
 */
public class UpgradeMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int maxValue = rows + cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] != 0) {
                    mat[i][j] = maxValue;
                    // compare top and left
                    if (i > 0)
                        mat[i][j] = Math.min(mat[i][j], mat[i - 1][j] + 1);
                    if (j > 0)
                        mat[i][j] = Math.min(mat[i][j], mat[i][j - 1] + 1);
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    // compare top and left
                    if (i < rows - 1)
                        mat[i][j] = Math.min(mat[i][j], mat[i + 1][j] + 1);
                    if (j < cols - 1)
                        mat[i][j] = Math.min(mat[i][j], mat[i][j + 1] + 1);
                }
            }
        }
        return mat;
    }
}
