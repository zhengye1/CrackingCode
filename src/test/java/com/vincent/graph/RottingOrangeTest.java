package com.vincent.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RottingOrangeTest {
    static int[][] grid1 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
    };
    static int[][] grid2 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };
    static int[][] grid3 = {
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}
    };
    static int[][] grid4 = {
            {2, 2, 2},
            {2, 1, 2},
            {2, 2, 2}
    };
    static int[][] grid5 = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
    };

    static int[][][] inputs = {grid1, grid2, grid3, grid4, grid5};
    static int[] expected = {-1, 0, 0, 1, 4};
    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            testCases.add(Arguments.of(inputs[i], expected[i]));
        }
        return testCases.stream();
    }

    RottingOranges rottingOranges = new RottingOranges();

    @ParameterizedTest(name = "Test case: {index} => grid={0} expected={1}")
    @MethodSource("generateTestCases")
    void rottingOrangesTest(int[][] grid, int expected) {
        assertEquals(expected, rottingOranges.orangesRotting(grid));
    }
}
