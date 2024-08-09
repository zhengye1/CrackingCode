package com.vincent.kwaymerge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KSmallestElementMatrixTest {
    KSmallestElementInMatrix kSmallestElementInMatrix = new KSmallestElementInMatrix();
    static int[][][] matrix = {
        {{1,3,5},
            {6,7,12},
            {11,14,14}},

        {{2, 6, 8},
            {3, 7, 10},
            {5, 8, 11}},

        {{1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}},

        {{5}},

        {{2, 5, 7, 9, 10},
            {4, 6, 8, 12, 14},
            {11, 13, 16, 18, 20},
            {15, 17, 21, 24, 26},
            {19, 22, 23, 25, 28}},

        {{3, 5, 7, 9, 11, 13},
            {6, 8, 10, 12, 14, 16},
            {15, 17, 19, 21, 23, 25},
            {18, 20, 22, 24, 26, 28},
            {27, 29, 31, 33, 35, 37},
            {30, 32, 34, 36, 38, 40}}};

    static int [] k = {3, 4, 1, 10, 15};
    static int [] expected = {5, 6, 1, 5, 17};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(matrix[i], k[i], expected[i]));
        }
        return testCases.stream();
    }

    @ParameterizedTest(name = "Test case: {index} => matrix={0}, k={1},expected={2}")
    @MethodSource("generateTestCases")
    void testKSmallestElementInMatrix(int[][] matrix, int k, int expected) {
        assertEquals(expected, kSmallestElementInMatrix.kthSmallest(matrix, k));
    }
}
