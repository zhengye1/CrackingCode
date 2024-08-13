package com.vincent.prefixsum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubArraySumTest {
    static int[][] input = {
        {1, 2, 3},
        {1, 1, 1},
        {1, 2, 3, 4, 5},
        {10, 2, -2, -20, 10},
        {-1, -1, 1, 1}
    };
    static int[] k = {
        3, 2, 9, -10, 0
    };
    static int[] expected = {
        2, 2, 2, 3, 2
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(input[i], k[i], expected[i]));
        }
        return testCases.stream();
    }

    SubArraySum subArraySum = new SubArraySum();

    @ParameterizedTest(name = "Test case: {index} => input={0}, k={1}, expected={2}")
    @MethodSource("generateTestCases")
    void subArraySumTest(int[] input, int k, int expected) {
        assertEquals(expected, subArraySum.subarraySum(input, k));
    }
}
