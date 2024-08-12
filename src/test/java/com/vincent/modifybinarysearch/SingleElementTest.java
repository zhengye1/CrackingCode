package com.vincent.modifybinarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleElementTest {
    static int[][] inputs = {
        {1, 2, 2, 3, 3, 4, 4},
        {1, 1, 2, 2, 3, 4, 4, 5, 5},
        {1, 1, 2, 3, 3},
        {1, 1, 2},
        {0, 2, 2, 3, 3, 4, 4, 5, 5}
    };
    static int[] expected = {
        1, 3, 2, 2, 0
    };
    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(inputs[i], expected[i]));
        }
        return testCases.stream();
    }

    SingleElement singleElement = new SingleElement();

    @ParameterizedTest(name = "Test case: {index} => input={0}, expect={1}")
    @MethodSource("generateTestCases")
    void singleElementTest(int[] input, int expected) {
        assertEquals(expected, singleElement.singleNonDuplicate(input));
    }
}
