package com.vincent.cyclicsort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstMissingPositiveTest {
    static int[][] input = {
            {1, 2, 3, 4},
            {-1, 3, 5, 7, 1},
            {1, 5, 4, 3, 2},
            {-1, 0, 2, 1, 4},
            {1, 4, 3},
            {1, 2, 0},
            {3, 4, -1, 1},
            {7, 8, 9, 11, 12},
            {9,6,4,2,3,5,7,0,1},
            {2, 1}
    };
    static int[] expected = {
            5, 2, 6, 3, 2, 3, 2, 1, 8, 3
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            int[] deepCopy = new int[input[i].length];
            System.arraycopy(input[i], 0, deepCopy, 0, input[i].length);
            testCases.add(Arguments.of(deepCopy, expected[i]));
        }
        return testCases.stream();
    }
    FirstMissingPositive firstMissingPositive = new FirstMissingPositive();

    @ParameterizedTest(name = "Test case: {index} => nums={0}, expected={1}")
    @MethodSource("generateTestCases")
    void firstMissingPositiveTestChangeNumber(int[] input, int expected) {
        assertEquals(expected, firstMissingPositive.firstMissingPositive(input));
    }

    @ParameterizedTest(name = "Test case: {index} => nums={0}, expected={1}")
    @MethodSource("generateTestCases")
    void firstMissingPositiveTestWithSwap(int[] input, int expected) {
        assertEquals(expected, firstMissingPositive.firstMissingPositiveSwap(input));
    }
}
