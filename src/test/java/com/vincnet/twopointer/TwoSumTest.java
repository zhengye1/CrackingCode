package com.vincnet.twopointer;

import com.vincent.twopointer.TwoSum;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TwoSumTest {
    private final TwoSum solution = new TwoSum();

    @Test
    void testCase1() {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;
        assert (Arrays.equals(new int[] {0, 1}, solution.twoSum(nums, target)));
    }

    @Test
    void testCase2() {
        int[] nums = new int[] {3, 2, 4};
        int target = 6;
        assert (Arrays.equals(new int[] {1, 2}, solution.twoSum(nums, target)));
    }

    @Test
    void testCase3() {
        int[] nums = new int[] {3, 3};
        int target = 6;
        assert (Arrays.equals(new int[] {0, 1}, solution.twoSum(nums, target)));
    }
}
