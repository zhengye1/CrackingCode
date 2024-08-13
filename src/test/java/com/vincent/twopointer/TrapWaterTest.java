package com.vincent.twopointer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrapWaterTest {
    static int[][] heights = {
            {0, 2, 0, 1, 0, 3},
            {3, 0, 2, 0, 4},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0},
            {4, 2, 0, 3, 2, 5},
            {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
    };
    static int[] expected = {
            5, 7, 0, 0, 9, 6
    };


    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(heights[i], expected[i]));
        }
        return testCases.stream();
    }

    TrapWater trapWater = new TrapWater();
    @ParameterizedTest(name = "Test case: {index} => height={0} expect={1}")
    @MethodSource("generateTestCases")
    void trapWaterTest(int[] height, int expected) {
        assertEquals(expected, trapWater.trap(height));
    }

}
