package com.vincent.twopointer;

/**
 * LeetCode 11 - Medium
 * Given integer array <i>height</i>, find the max area
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, minHeight * (right - left));
            if (height[left] <= height[right]) {
                while (left < right && height[left] <= minHeight) left++;

            } else {
                while (left < right && height[right] <= minHeight) right--;
            }
        }
        return maxArea;
    }
}
