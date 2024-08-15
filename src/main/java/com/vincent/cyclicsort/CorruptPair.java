package com.vincent.cyclicsort;

/**
 * Given an array, all the element is between [1, n] except one number duplicate,
 * find the pair with missing number and duplicate number
 */
public class CorruptPair {
    public int[] findCorruptPairs(int[] nums) {
        int n = nums.length;
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            while (nums[i] != nums[nums[i] - 1]){
                int correctIndex = nums[i] - 1;
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1){
                result[0] = i + 1;
                result[1] = nums[i];
                return result;
            }
        }
        return result;
    }

}

