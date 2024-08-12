package com.vincent.modifybinarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class KClosetElementTest{
    KClosestElement kClosestElement = new KClosestElement();
    static int[][]inputs={
        {1, 2, 3, 4, 5, 6, 7},
        {1, 2, 3, 4, 5},
        {1, 2, 4, 5, 6},
        {1, 2, 3, 4, 5, 10}
    };
    static int[] k = {4, 4, 2, 3};
    static int[] target = {4, 3, 10, -5};
    static int[][] expected = {
        {2, 3, 4, 5},
        {1, 2, 3, 4},
        {5, 6},
        {1, 2, 3}
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            List<Integer> expectedList = new ArrayList<>();
            for (int num : expected[i]){
                expectedList.add(num);
            }
            testCases.add(Arguments.of(inputs[i], k[i], target[i], expectedList));
        }
        return testCases.stream();
    }

    @ParameterizedTest(name = "Test case: {index} => input={0}, k={1} target={2} expect={3}")
    @MethodSource("generateTestCases")
    void kClosestElementTest(int[] input, int k, int target, List<Integer> expected) {
        assertIterableEquals(expected, kClosestElement.findClosestElements(input, k, target));
    }
}
