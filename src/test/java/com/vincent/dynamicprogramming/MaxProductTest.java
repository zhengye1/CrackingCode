package com.vincent.dynamicprogramming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxProductTest {
    static int[][] inputBits = {
        {-2, 0, -1},
        {2, 3, -2, 4},
        {2, -5, 3, 1, -4, 0, -10, 2},
        {1, 2, 3, 0, 4},
        {5, 4, 3, 10, 4, 1}
    };
    static int[] expected = {
        0, 6, 120, 6, 2400
    };
    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(inputBits[i], expected[i]));
        }
        return testCases.stream();
    }
    MaxProductSubarray maxProductSubarray = new MaxProductSubarray();

    @ParameterizedTest(name = "Test case: {index} => inputBits={0} expected={1}")
    @MethodSource("generateTestCases")
    void maxProductDPTest(int[] inputBits, int expected) {
        assertEquals(expected, maxProductSubarray.maxProductDP(inputBits));
    }

    @ParameterizedTest(name = "Test case: {index} => inputBits={0} expected={1}")
    @MethodSource("generateTestCases")
    void maxProductSubarrayTest(int[] inputBits, int expected) {
        assertEquals(expected, maxProductSubarray.maxProductSubarray(inputBits));
    }
}
