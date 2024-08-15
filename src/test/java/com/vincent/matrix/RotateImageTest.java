package com.vincent.matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RotateImageTest {
    static int[][][] input = {
            {{1}},
            {{6, 9}, {2, 7}},
            {{2, 14, 8}, {12, 7, 14}, {3, 3, 7}},
            {{3, 1, 1, 7}, {15, 12, 13, 13}, {4, 14, 12, 4}, {10, 5, 11, 12}},
            {{10, 1, 14, 11, 14}, {13, 4, 8, 2, 13}, {10, 19, 1, 6, 8}, {20, 10, 8, 2, 12}, {15, 6, 8, 8, 18}}
    };

    static int[][][] expected ={
            {{1}},
            {{2, 6}, {7, 9}},
            {{3, 12, 2}, {3, 7, 14}, {7, 14, 8}},
            {{10, 4, 15, 3}, {5, 14, 12, 1}, {11, 12, 13, 1},{12, 4, 13, 7}},
            {{15, 20, 10, 13, 10}, {6, 10, 19, 4, 1}, {8, 8, 1, 8, 14}, {8, 2, 6, 2, 11}, {18, 12, 8, 13, 14}}
    };
    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            int[][] deepCopy = new int[input[i].length][input[i][0].length];
            int[][] expectedCopy = new int[expected[i].length][expected[i][0].length];
            for (int r = 0; r < input[i].length; r++) {
                System.arraycopy(input[i][r], 0, deepCopy[r], 0, input[i][0].length);
            }
            for (int j = 0; j < expected[i].length; j++){
                System.arraycopy(expected[i][j], 0, expectedCopy[j], 0, expected[i][0].length);
            }

            testCases.add(Arguments.of(deepCopy, expectedCopy));
        }
        return testCases.stream();
    }

    RotateImage rotateImage = new RotateImage();

    @ParameterizedTest(name = "Test case: {index} => matrix={0}, expected={1}")
    @MethodSource("generateTestCases")
    void rotateImageTest(int[][] matrix, int[][] expected){
        rotateImage.rotate(matrix);
        assertArrayEquals(expected, matrix);
    }
}
