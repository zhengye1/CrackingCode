package com.vincent.twopointer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainerWithMostWaterTest {
    static int[][] heights = {
            {1,8,6,2,5,4,8,3,7},
            {1, 1},
            {2,8,6,3,5,4,7},
            {1, 5},
            {7, 7, 2}
    };
    static int[] expected = {
            49, 1, 35, 1, 7
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(heights[i], expected[i]));
        }
        return testCases.stream();
    }
    ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

    @ParameterizedTest(name = "Test case: {index} => heights={0}, expected={1}")
    @MethodSource("generateTestCases")
    void maxAreaTest(int[] heights, int expected) {
        assertEquals(expected, containerWithMostWater.maxArea(heights));
    }
}
