package com.vincent.sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {
    static int[][] input =
    {
        {5, 1, 6, 2, 3, 4},
        {90,67,-89,11,12,34,-56,-100,47},
        {-231,-59,-20,-532,-659,486},
        {-1,5,3,4,0},
        {4,2,1,3},
        {44,89,12,90,111,341,5}
    };

    static int[][] expected = {
        {1, 2, 3, 4, 5, 6},
        {-100,-89,-56,11,12,34,47,67,90},
        {-659,-532,-231,-59,-20,486},
        {-1,0,3,4,5},
        {1, 2, 3, 4},
        {5,12,44,89,90,111,341}
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(input[i], expected[i]));
        }
        return testCases.stream();
    }

    MergeSort mergeSort = new MergeSort();
    @ParameterizedTest(name = "Test case: {index} => input={0} expected={1}")
    @MethodSource("generateTestCases")
    void mergeSortTest(int[] input, int[] expected) {
        mergeSort.mergeSort(input);
        assertArrayEquals(expected, input);
    }


}
