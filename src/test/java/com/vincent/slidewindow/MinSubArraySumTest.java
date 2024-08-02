package com.vincent.slidewindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MinSubArraySumTest {
    static int[] target = {7, 4, 11, 10, 5, 15, 6, 3};
    static int[][] inputArr = {{2, 3, 1, 2, 4, 3}, {1, 4, 4}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 2, 3, 4}, {1, 2, 1, 3},
        {5, 4, 9, 8, 11, 3, 7, 12, 15, 44}, {1, 2, 3, 1, 1, 4, 1}};

    static int[] expected = {2, 1, 0, 4, 3, 1, 3};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < inputArr.length; i++) {
            testCases.add(Arguments.of(inputArr[i], target[i], expected[i]));
        }
        return testCases.stream();
    }

    MinSubArraySum minSubArraySum = new MinSubArraySum();

    @ParameterizedTest(name = "Test case: {index} => inputArr={0}, target={1} expected={2}")
    @MethodSource("generateTestCases")
    void testMinSubArraySum(int[] inputArr, int target, int expected) {
        minSubArraySum.minSubArrayLen(target, inputArr);
    }
}
