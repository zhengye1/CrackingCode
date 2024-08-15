package com.vincent.cyclicsort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class FindFirstKMissingPositiveTest {
    static int[][] input = {
            {1,2,3,4,5},
            {1, -1, 2},
            {-4, 6},
            {0,-5,1,3,5,4},
            {1,-1,-3,8}
    };

    static int[] k = {
            6, 2, 4,3,4
    };

    static int[][] expected = {
            {6,7,8,9,10,11},
            {3,4},
            {1,2,3,4},
            {2,6,7},
            {2,3,4,5}
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            int[] deepCopy = new int[input[i].length];
            System.arraycopy(input[i], 0, deepCopy, 0, input[i].length);
            List<Integer> lst = new ArrayList<>();
            for (int j = 0; j < expected[i].length; j++) {
                lst.add(expected[i][j]);
            }
            testCases.add(Arguments.of(deepCopy, k[i], lst));
        }
        return testCases.stream();
    }

    FindFirstKMissingPositive findFirstKMissingPositive = new FindFirstKMissingPositive();
    @ParameterizedTest(name = "Test case: {index} => nums={0}, k={1} expected={2}")
    @MethodSource("generateTestCases")
    void findFirstKMissingPositiveTest(int[] input, int k, List<Integer> expected) {
        assertIterableEquals(expected, findFirstKMissingPositive.findFirstKMissingPositives(input, k));
    }
}
