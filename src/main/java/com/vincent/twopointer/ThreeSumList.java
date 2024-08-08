package com.vincent.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode #15, same requirement as <i>ThreeSum</i> but it needs to return the index
 */
public class ThreeSumList {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int target = -nums[i];
                int head = i + 1, tail = len - 1;
                while (tail > head) {
                    if (nums[head] + nums[tail] == target) {
                        ret.add(List.of(nums[i], nums[head], nums[tail]));
                        while (tail > i && nums[tail] == nums[tail - 1]) tail--;
                        tail--;
                        while (head < i && nums[head] == nums[head++]) head++;
                        head++;
                    } else if (nums[head] + nums[tail] > target) {
                        tail--;
                    } else {
                        head++;
                    }
                }
            }
        }
        return ret;
    }
}
