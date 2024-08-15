package com.vincent.cyclicsort;

/**
 * LeetCode 268 - Easy
 * Find the missing number from the array that each element is between [0, n]
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] == 0) return 1;
            else return 0;
        }

        // swap
        for (int i = 0; i< nums.length; i++) {
            // you might not get the correct number on correct current index
            // terminate the swap either current nums[i] greater than length
            // or nums[i] sit on the right index
            // if it not on the right index, make sure it is not the value that swap before!
            while (nums[i] < nums.length && nums[i] != i && nums[i] != nums[nums[i]]) {
                // swap with index and i
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }

        // after all the swap, the number should match properly
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }

    public int missingNumberEasySolution(int[] nums) {
        int n = nums.length;
        int nSum = (n * (n + 1)) >> 1; //calculate the total sum from 1 to n
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return nSum - sum;
    }
}
