package com.vincent.array;

import com.vincent.arrays.MaximumSubarray;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSubarrayTest {
    static int[][] input =
        {{1, 2, 3, 4, 5}, {-2, 1, -3, 4, -1, 2, 1, -5, 4}, {-1, -2, -3, -4}, {5, -2, 3, 4, -1, 6, -2},
            {0, -3, 1, 1, -2, 2, 3}};

    static int[] expected = {15, 6, -1, 15, 5};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(input[i], expected[i]));
        }
        return testCases.stream();
    }

    MaximumSubarray maximumSubarray = new MaximumSubarray();

    @ParameterizedTest(name = "Test case: {index} => nums={0},expected={1}")
    @MethodSource("generateTestCases")
    void maximumSubarrayTest(int[] nums, int expected) {
        assertEquals(expected, maximumSubarray.maxSubArray(nums));
    }

}
