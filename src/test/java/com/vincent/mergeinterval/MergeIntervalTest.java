package com.vincent.mergeinterval;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeIntervalTest {
    MergeInterval mergeInterval = new MergeInterval();
    static int[][][] inputs =
        {{{1, 5}, {3, 7}, {4, 6}}, {{1, 5}, {4, 6}, {6, 8}, {11, 15}}, {{3, 7}, {6, 8}, {10, 12}, {11, 15}}, {{1, 5}},
            {{1, 9}, {3, 8}, {4, 4}}, {{1, 2}, {3, 4}, {8, 8}}, {{1, 5}, {1, 3}}, {{1, 5}, {6, 9}},
            {{0, 0}, {1, 18}, {1, 3}}};

    static int[][][] expected =
        {{{1, 7}}, {{1, 8}, {11, 15}}, {{3, 8}, {10, 15}}, {{1, 5}}, {{1, 9}}, {{1, 2}, {3, 4}, {8, 8}}, {{1, 5}},
            {{1, 5}, {6, 9}}, {{0, 0}, {1, 18}}};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            testCases.add(Arguments.of(inputs[i], expected[i]));
        }
        return testCases.stream();
    }

    @ParameterizedTest(name = "Test case: {index} => input={0}, expected={1}")
    @MethodSource("generateTestCases")
    void testMergeInterval(int[][] input, int[][] expected) {
        assertArrayEquals(expected, mergeInterval.mergeIntervals(input));
    }
}
