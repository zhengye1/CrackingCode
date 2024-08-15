package com.vincent.cyclicsort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissingNumberTest {
    static int[][] input = {
            {4, 0, 3, 1},
            {8, 3, 5, 2, 4, 6, 0, 1},
            {1, 2, 3, 4, 6, 7, 8, 9, 10, 0},
            {0},
            {1, 2, 3, 0, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 23}
    };
    static int[] expected = {
            2, 7, 5, 1, 22
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

    MissingNumber missingNumber = new MissingNumber();

    @ParameterizedTest(name = "Test case: {index} => nums={0}, expected={1}")
    @MethodSource("generateTestCases")
    void missingNumberTestWithSum(int[] nums, int expected) {
        assertEquals(expected, missingNumber.missingNumberEasySolution(nums));
    }

    @ParameterizedTest(name = "Test case: {index} => nums={0}, expected={1}")
    @MethodSource("generateTestCases")
    void missingNumberTestWithSwap(int[] nums,int expected) {
        assertEquals(expected, missingNumber.missingNumber(nums));
    }


}
