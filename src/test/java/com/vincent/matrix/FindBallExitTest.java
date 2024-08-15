package com.vincent.matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindBallExitTest {
    FindExitColumn findExitColumn = new FindExitColumn();
    static int[][][] input = {
            {{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}},
            {{1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1}, {-1, -1, 1, -1, -1, 1, -1, -1, 1, -1, -1, 1}, {1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1}, {-1, -1, -1, 1, 1, -1, -1, -1, -1, 1, 1, -1}},
            {{-1, -1, -1, -1}, {1, 1, 1, 1}, {-1, -1, -1, -1}, {1, 1, 1, 1}},
            {{1}},
            {{-1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1}}
    };
    static int[][] expected = {
            {1, -1, -1, -1, -1},
            {0, -1, -1, -1, -1, -1, 6, -1, -1, -1, -1, -1},
            {-1, 1, 2, 3},
            {-1},
            {-1, -1, -1, -1, 0}
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            int[][] deepCopy = new int[input[i].length][input[i][0].length];
            int[] expectedCopy = new int[expected[i].length];
            for (int r = 0; r < input[i].length; r++) {
                System.arraycopy(input[i][r], 0, deepCopy[r], 0, input[i][0].length);
            }
            System.arraycopy(expected[i], 0, expectedCopy, 0, expected[i].length);


            testCases.add(Arguments.of(deepCopy, expectedCopy));
        }
        return testCases.stream();
    }
    @ParameterizedTest(name = "Test case: {index} => grids={0}, expected={1}")
    @MethodSource("generateTestCases")
    void findExitColumNTest(int[][] grids, int[] expected) {
        assertArrayEquals(expected, findExitColumn.findBall(grids));
    }
}
