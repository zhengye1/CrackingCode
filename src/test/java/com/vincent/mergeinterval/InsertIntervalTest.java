package com.vincent.mergeinterval;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InsertIntervalTest {
    InsertInterval insertInterval = new InsertInterval();
    static int[][] newIntervals = {{5, 7}, {8, 9}, {10, 12}, {1, 3}, {1, 10}};

    static int[][][] existingIntervals =
        {{{1, 2}, {3, 5}, {6, 8}}, {{1, 3}, {5, 7}, {10, 12}}, {{8, 10}, {12, 15}}, {{5, 7}, {8, 9}}, {{3, 5}}};

    static int[][][] expected =
        {
            {{1, 2}, {3, 8}},
            {{1, 3}, {5, 7}, {8, 9}, {10, 12}},
            {{8, 15}},
            {{1, 3}, {5, 7}, {8, 9}},
            {{1, 10}}
        };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < existingIntervals.length; i++) {
            testCases.add(Arguments.of(existingIntervals[i], newIntervals[i], expected[i]));
        }
        return testCases.stream();
    }

    @ParameterizedTest(name = "Test case: {index} => existing={0}, newInterval={1}, expected={2}")
    @MethodSource("generateTestCases")
    void testInsertIntervalUpgrade(int[][] existing, int[] newInterval, int[][] expected) {
        assertArrayEquals(expected, insertInterval.insertIntervalUpgrade(existing, newInterval));
    }

    @ParameterizedTest(name = "Test case: {index} => existing={0}, newInterval={1}, expected={2}")
    @MethodSource("generateTestCases")
    void testInsertInterval(int[][] existing, int[] newInterval, int[][] expected) {
        assertArrayEquals(expected, insertInterval.insertInterval(existing, newInterval));
    }
}
