package com.vincent.twoheaps;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MediumSlidingWindowTest {
    static int [][]arr = {{3, 1, 2, -1, 0, 5, 8}, {1, 2}, {4, 7, 2, 21}, {22, 23, 24, 56, 76, 43, 121 ,1 ,2 ,0 ,0 ,2 ,3 ,5}, {1, 1, 1, 1, 1}};
    static int[] k = {4, 1, 2, 5, 2};
    static double[][] expected = {
        {1.5, 0.5, 1.0, 2.5},
        {1.0, 2.0},
        {5.5, 4.5, 11.5},
        {24.0, 43.0, 56.0, 56.0, 43.0, 2.0, 1.0, 1.0, 2.0, 2.0},
        {1.0, 1.0, 1.0, 1.0}
    };


    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(arr[i], k[i], expected[i]));
        }
        return testCases.stream();
    }

    MediumSlidingWindow mediumSlidingWindow = new MediumSlidingWindow();
    @ParameterizedTest(name = "Test case: {index} => nums={0}, k={1}, expected={2}")
    @MethodSource("generateTestCases")
    void testMediumSlidingWindow(int[] nums, int k, double[] expected) {
        assertArrayEquals(expected, mediumSlidingWindow.medianSlidingWindow(nums, k));
    }
}
