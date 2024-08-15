package com.vincent.array;

import com.vincent.arrays.RotateArray;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotateArrayTest {
    static int[][] input = {
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5},
            {2, 2, 2, 2},
            {1, 2, 3, 4, 5, 6},
            {1},
            {1,2,3,4,5,6,7},
            {-1,-100,3,99}
    };
    static int[] k = {2, 7, 3, 0, 5,3, 2};
    static int[][] expected = {
            {4, 5, 1, 2, 3},
            {4, 5, 1, 2, 3},
            {2, 2, 2, 2},
            {1, 2, 3, 4, 5, 6},
            {1},
            {5,6,7,1,2,3,4},
            {3,99,-1,-100}
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            int[] deepCopy = new int[input[i].length];
            System.arraycopy(input[i], 0, deepCopy, 0, input[i].length);
            testCases.add(Arguments.of(deepCopy, k[i], expected[i]));
        }
        return testCases.stream();
    }

    RotateArray rotateArray = new RotateArray();

    @ParameterizedTest(name = "Test case: {index} => nums={0},k ={1} expected={2}")
    @MethodSource("generateTestCases")
    void rotateArrayTestWithCopy(int[] nums, int k, int[] expected) {
        rotateArray.rotate(nums, k);
        assertArrayEquals(expected, nums);
    }

    @ParameterizedTest(name = "Test case: {index} => nums={0},k ={1} expected={2}")
    @MethodSource("generateTestCases")
    void rotateArrayTestWithReverse(int[] nums, int k, int[] expected) {
        rotateArray.rotateReverse(nums, k);
        assertArrayEquals(expected, nums);
    }
}
