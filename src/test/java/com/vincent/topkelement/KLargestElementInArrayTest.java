package com.vincent.topkelement;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KLargestElementInArrayTest {
    static  int[][] inputs = {
            {1, 5, 12, 2, 11, 9, 7, 30, 20},
            {5, 2, 9, -3, 7},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 4, 6, 0, 2},
            {3, 5, 2, 3, 8, 5, 3}
    };

    static int[] K = {3, 1, 9, 1, 4};
    static int[] expected  = {12, 9, 1, 6, 3};

    KLargestElementInArray kLargestElementInArray = new KLargestElementInArray();

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(inputs[i], K[i], expected[i]));
        }
        return testCases.stream();
    }

    @ParameterizedTest(name = "Test case: {index} => inputs={0}, k={1} expect={2}")
    @MethodSource("generateTestCases")
    void kLargestElementInArrayTest(int[] inputs, int k, int expected) {
        assertEquals(expected, kLargestElementInArray.findKthLargest(inputs, k));
    }


}
