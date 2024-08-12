package com.vincent.topkelement;

import com.vincent.util.Point;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TopKFrequentTest {
    static int[][] inputs = {
            {1, 3, 5, 12, 11, 12, 11, 12, 5},
            {1, 3, 5, 14, 18, 14, 5},
            {2, 3, 4, 5, 6, 7, 7},
            {9, 8, 7, 6, 6, 5, 4, 3, 2, 1},
            {2, 4, 3, 2, 3, 4, 5, 4, 4, 4},
            {2, 3}
    };
    static int[] inputK = {3, 2, 1, 1, 3, 4, 2};
    static int[][] expected = {
            new int[] {5 ,11, 12},
            new int[]{5, 14},
            new int[] {7},
            new int[] {6},
            new int[]{2, 3, 4},
            new int[]{2, 3}
    };
    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(inputs[i], inputK[i], expected[i]));
        }
        return testCases.stream();
    }
    TopKFrequentElement topKFrequentElement = new TopKFrequentElement();
    @ParameterizedTest(name = "Test case: {index} => nums={0}, k={1} expect={2}")
    @MethodSource("generateTestCases")
    void topKFrequentTest(int[] nums, int k ,int[] expected) {
        Arrays.sort(expected);
        int[] actual = topKFrequentElement.topKFrequent(nums, k);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
}
