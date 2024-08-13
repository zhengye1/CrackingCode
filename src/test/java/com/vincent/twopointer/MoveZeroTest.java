package com.vincent.twopointer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MoveZeroTest {
    static int[][] input = {
            {0, 1, 0, 3, 12},
            {0},
            {0, 0, 0, 0, 1},
            {4, 2, 4, 0, 0, 3, 0, 5, 1, 0}
    };

    static int[][] expected = {
            {1, 3, 12, 0, 0},
            {0},
            {1, 0, 0, 0,0},
            {4, 2, 4, 3, 5, 1, 0, 0, 0, 0}
    };


    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(input[i], expected[i]));
        }
        return testCases.stream();
    }

    MoveZero moveZero = new MoveZero();

    @ParameterizedTest(name = "Test case: {index} => input={0}, expected={1}")
    @MethodSource("generateTestCases")
    void moveZeroTest(int[] input, int[] expected) {
        moveZero.moveZeroes(input);
        assertArrayEquals(expected, input);
    }

}
