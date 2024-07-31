package com.vincent.twopointer;

/**
 * LeetCode question 75, Difficulty: Medium <br>
 * Given an array combines 0 (red), 1(white), 2(blue) <br>
 * Sort them in red, white and blue order <br>
 * Constraint: 1 &lt; <i>colors.length</i> &lt; 300 and <i>colors[i]</i> only contains 0, 1, 2
 */
public class SortColor {
    // for example , [2,0,2,1,1,0]
    // start = 0, current = 0, end = 5, value for current 2, swap with the end   -> [0, 0, 2, 1, 1, 2], decrement the end
    // start = 0, current = 0, end = 4, value for current 2, swap with the start -> [0, 0, 2, 1, 1, 2], increment start and current
    // start = 1, current = 1, end = 4, value for current 2, swap with the start -> [0, 0, 2, 1, 1, 2], increment start and current
    // start = 2, current = 2, end = 4, value for current 2, swap with the end   -> [0, 0, 2, 1, 1, 2], decrement the end
    // start = 2, current = 2, end = 3, value for current 2, swap with the end   -> [0, 0, 1, 1, 2, 2], decrement the end
    // start = 2, current = 2, end = 2, value for current 2, swap with the end   -> [0, 0, 1, 1, 2, 2]
    // start = 2, current = 2, end = 1, exit
    public int[] sortColors(int[] colors) {
        int start = 0;
        int end = colors.length - 1;
        int current = 0;
        while (current <= end){
            if (colors[current] == 0) {
                int temp = colors[current];
                colors[current] = colors[start];
                colors[start] = temp;
                current++;
                start++;
            }else if (colors[current] == 1){
                current++;
            }else{
                int temp = colors[current];
                colors[current] = colors[end];
                colors[end] = temp;
                end--;
            }
        }
        return colors; // LeetCode question is void
    }

}
