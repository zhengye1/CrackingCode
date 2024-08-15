package com.vincent.matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class SpiralMatrixTest {
    static int[][][] input = {
            {{1}},
            {{6}, {2}},
            {{2, 14, 8}, {12, 7, 14}},
            {{3, 1, 1}, {15, 12, 13}, {4, 14, 12}, {10, 5, 11}},
            {{10, 1, 14, 11, 14}, {13, 4, 8, 2, 13}, {10, 19, 1, 6, 8}, {20, 10, 8, 2, 12}, {15, 6, 8, 8, 18}}
    };

    static int[][] expected = {
            {1},
            {6,2},
            {2, 14, 8, 14, 7, 12},
            {3, 1, 1, 13, 12, 11, 5, 10, 4, 15, 12, 14},
            {10, 1, 14, 11, 14, 13, 8, 12, 18, 8, 8, 6, 15, 20, 10, 13, 4, 8, 2, 6, 2, 8, 10, 19, 1}
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            int[][] deepCopy = new int[input[i].length][input[i][0].length];
            List<Integer> resultList = new ArrayList<>();
            for (int r = 0; r < input[i].length; r++) {
                System.arraycopy(input[i][r], 0, deepCopy[r], 0, input[i][0].length);
            }
            for (int j = 0; j < expected[i].length; j++){
                resultList.add(expected[i][j]);
            }

            testCases.add(Arguments.of(deepCopy, resultList));
        }
        return testCases.stream();
    }
    SpiralMatrix spiralMatrix = new SpiralMatrix();
    @ParameterizedTest(name = "Test case: {index} => matrix={0}, expected={1}")
    @MethodSource("generateTestCases")
    void spiralMatrixTest(int[][] matrix, List<Integer> expected) {
        assertIterableEquals(expected, spiralMatrix.spiralOrder(matrix));
    }

}
