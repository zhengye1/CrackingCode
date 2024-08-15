package com.vincent.cyclicsort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CorruptPairTest {
   static int[][] input = {{3, 1, 2, 5, 2},
            {3, 1, 2, 3, 6, 4},
            {4, 1, 2, 1, 6, 3},
            {4, 3, 4, 5, 1},
            {5, 3, 5, 6, 2, 1},
            {3, 4, 2, 3}
   };

   static int[][] expected = {
           {4, 2},
           {5, 3},
           {5, 1},
           {2, 4},
           {4, 5},
           {1, 3}
   };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            int[] deepCopy = new int[input[i].length];
            System.arraycopy(input[i], 0, deepCopy, 0, input[i].length);
            testCases.add(Arguments.of(deepCopy, expected[i]));
        }
        return testCases.stream();
    }

    CorruptPair corruptPair = new CorruptPair();

    @ParameterizedTest(name = "Test case: {index} => nums={0}, expected={1}")
    @MethodSource("generateTestCases")
    void firstMissingPositiveTestChangeNumber(int[] input, int[] expected) {
        assertArrayEquals(expected, corruptPair.findCorruptPairs(input));
    }
}
