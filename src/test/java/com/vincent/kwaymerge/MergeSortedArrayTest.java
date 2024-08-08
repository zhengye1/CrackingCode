package com.vincent.kwaymerge;

import com.vincent.util.LinkedList;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortedArrayTest {
    static int[] m = {9, 2, 3, 1, 8};
    static int[] n = {6, 1, 4, 2, 1};
    static int[][] nums1 = {
        {23, 33, 35, 41, 44, 47, 56, 91, 105, 0, 0, 0, 0, 0, 0},
        {1, 2, 0},
        {1, 1, 1, 0, 0, 0, 0},
        {6, 0, 0},
        {12, 34, 45, 56, 67, 78, 89, 99, 0}
    };
    static int[][] nums2 = {
        {32, 49, 50, 51, 61, 99},
        {7},
        {1, 2, 3, 4},
        {-45, -99},
        {100}
    };

    static int[][] expected = {
        {23, 32, 33, 35, 41, 44, 47, 49, 50, 51, 56, 61, 91, 99, 105},
        {1, 2, 7},
        {1, 1, 1, 1, 2, 3, 4},
        {-45, -99, 6},
        {12, 34, 45, 56, 67, 78, 89, 99, 100}
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(nums1[i], m[i], nums2[i], n[i], expected[i]));
        }
        return testCases.stream();
    }

    MergeSortedArray mergeSortedArray = new MergeSortedArray();
    @ParameterizedTest(name = "Test case: {index} => nums1={0}, m={1}, nums2={2}, n={3}, expected={4}")
    @MethodSource("generateTestCases")
    void testMergeSortedArray(int[] nums1, int m, int[] nums2, int n, int[] expected){
        mergeSortedArray.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }
}
