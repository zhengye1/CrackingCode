package com.vincent.twopointer;

/**
 * LeetCode 42 - Hard
 */
public class TrapWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int left_max = height[left], right_max = height[right];
        int water = 0;
        while (left < right) {
            if (left_max < right_max) {
                left++;
                if (height[left] < left_max){
                    // 出现了凹槽能蓄水，能蓄多少就看left_max跟height[left]有多少
                    water += left_max - height[left];
                }else{
                    left_max = height[left];
                }
            }else{
                right--;
                if (height[right] < right_max){
                    //同理右边
                    water += right_max - height[right];
                }else{
                    right_max = height[right];
                }
            }
        }
        return water;
    }
}
