package com.vincent.modifybinarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchRotatedIITest {
    static int[][] inputs = {
        {2,5,6,0,0,1,2},
        {2,5,6,0,0,1,2},
        {1},
        {2}
    };
    static int[] target = {
        0, 3, 1, 3
    };
    static boolean[] expected = {
        true, false, true, false
    };

    BinarySearchRotatedII binarySearchRotatedII = new BinarySearchRotatedII();

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(inputs[i], target[i], expected[i]));
        }
        return testCases.stream();
    }


    @ParameterizedTest(name = "Test case: {index} => input={0}, target={1} expect={2}")
    @MethodSource("generateTestCases")
    void binarySearchRotatedIITest(int[] input, int target, boolean expected) {
        assertEquals(expected, binarySearchRotatedII.search(input, target));
    }
}
