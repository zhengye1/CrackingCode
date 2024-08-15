package com.vincent.matrix;

/**
 * LeetCode 240 - Medium / LeetCode 74 - Medium <br>
 * LeetCode 240 has following: <br>
 * Integers in each row are sorted in ascending from left to right. <br>
 * Integers in each column are sorted in ascending from top to bottom. <br>
 * LeetCode 74 has following: <br>
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix[0].length - 1;
        int y = 0;


        // we search from top right, use (y, x) to represent row and column
        while (x >= 0 && y < matrix.length) {
            if (matrix[y][x] == target) {
                return true;
            }
            if (matrix[y][x] < target) {
                y++;
            }else{
                x--;
            }
        }
        return false;
    }
}
