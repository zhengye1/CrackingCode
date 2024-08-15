package com.vincent.matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MatrixSetZeroTest {
    static int[][][] input = {
            {{1, 1, 0}, {1, 0, 1}, {1, 1, 1}},
            {{1, 1, 1, 1, 1}, {0, 0, 1, 1, 1}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 1}},
            {{3, 5, 2, 0}, {1, 0, 4, 6}, {7, 3, 2, 4}},
            {{1, 2, 3, 4}, {4, 5, 6, 7}, {8, 9, 4, 6}},
            {{2, 6, 5, 4, 9, 1}, {7, 2, 0, 0, 5, 4}, {1, 1, 1, 1, 0, 1}, {9, 8, 2, 0, 1, 3}, {7, 8, 6, 5, 4, 3}, {9, 8, 1, 2, 5, 6}}
    };

    static int[][][] expected = {
            {{0, 0, 0}, {0, 0, 0}, {1, 0, 0}},
            {{0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}},
            {{0, 0, 0, 0}, {0, 0, 0, 0}, {7, 0, 2, 0}},
            {{1, 2, 3, 4}, {4, 5, 6, 7}, {8, 9, 4, 6}},
            {{2, 6, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {7, 8, 0, 0, 0, 3}, {9, 8, 0, 0, 0, 6}}
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            int[][] deepCopy = new int[input[i].length][input[i][0].length];
            for(int r = 0; r < input[i].length; r++) {
                System.arraycopy(input[i][r], 0, deepCopy[r], 0, input[i][0].length);
            }
            int[][] deepCopyExpected = new int[expected[i].length][expected[i][0].length];
            for(int r = 0; r < expected[i].length; r++) {
                System.arraycopy(expected[i][r], 0, deepCopyExpected[r], 0, expected[i][0].length);
            }
            System.arraycopy(expected[i], 0, deepCopyExpected, 0, expected[i].length);
            testCases.add(Arguments.of(deepCopy, deepCopyExpected));
        }
        return testCases.stream();
    }

    MatrixSetZero matrixSetZero = new MatrixSetZero();

    @ParameterizedTest(name = "Test case: {index} => matrix={0}, expected={1}")
    @MethodSource("generateTestCases")
    void setMatrixSetZeroTest(int[][] matrix, int[][] expected) {
        matrixSetZero.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    @ParameterizedTest(name = "Test case: {index} => matrix={0}, expected={1}")
    @MethodSource("generateTestCases")
    void setMatrixSetZeroTestWithReturn(int[][] matrix, int[][] expected) {
        assertArrayEquals(expected, matrixSetZero.setZerosWithReturn(matrix));
    }


}
