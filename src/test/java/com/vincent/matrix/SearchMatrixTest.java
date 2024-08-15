package com.vincent.matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchMatrixTest {
    SearchMatrix searchMatrix = new SearchMatrix();
    static int[][][] input = {
        {{1,3,5,7},{10,11,16,20},{23,30,34,60}},
        {{1,3,5,7},{10,11,16,20},{23,30,34,60}},
        {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},
        {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}
    };
    static int[] target = {
        3, 13, 5, 20
    };
    static boolean[] expected = {
        true, false, true, false
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(input[i], target[i], expected[i]));
        }
        return testCases.stream();
    }

    @ParameterizedTest(name = "Test case: {index} => input={0},target={1} expected={2}")
    @MethodSource("generateTestCases")
    void searchMatrixTest(int[][] input, int target, boolean expected) {
        assertEquals(expected, searchMatrix.searchMatrix(input, target));
    }
}
