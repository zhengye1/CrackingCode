package com.vincent.modifybinarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchRotatedTest {
    static int[][] inputs = new int[][] {
        {5, 6, 7, 1, 2, 3, 4},
        {40, 50, 60, 10, 20, 30},
        {47, 58, 69, 72, 83, 94, 12, 24, 35},
        {77, 82, 99, 105, 5, 13, 28, 41, 56, 63},
        {48, 52, 57, 62, 68, 72, 5, 7, 12, 17, 21, 28, 33, 37, 41}
    };
    static int[] target = new int[]{
        1, 50, 12, 56, 5
    };
    static int[] expected = new int[]{
        3, 1, 6,8,6
    };


    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(inputs[i], target[i], expected[i]));
        }
        return testCases.stream();
    }

    BinarySearchRotated binarySearchRotated = new BinarySearchRotated();

    @ParameterizedTest(name = "Test case: {index} => nums{0}, target={1} expect={2}")
    @MethodSource("generateTestCases")
    void testBinarySearchRotated(int[] inputs, int target, int expected) {
        assertEquals(expected, binarySearchRotated.search(inputs, target));
    }

    @ParameterizedTest(name = "Test case: {index} => nums{0}, target={1} expect={2}")
    @MethodSource("generateTestCases")
    void testBinarySearchRotatedRecursive(int[] inputs, int target, int expected) {
        assertEquals(expected, binarySearchRotated.searchRecursive(inputs, target));
    }
}
