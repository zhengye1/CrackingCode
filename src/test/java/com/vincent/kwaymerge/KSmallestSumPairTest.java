package com.vincent.kwaymerge;

import com.vincent.util.LinkedList;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class KSmallestSumPairTest {
    static int[][]list1 = {{2, 8, 9},
        {1, 2, 300},
        {1, 1, 2},
        {4, 6},
        {4, 7, 9},
        {1, 1, 2},
    };

    static int[][]list2 = {
        {1, 3, 6},
        {1, 11, 20, 35, 300},
        {1, 2, 3},
        {2, 3},
        {4, 7, 9},
        {1}
    };
    static int[] k = {9, 30, 1, 2, 5, 4, 10000};

    static int[][][] expected = {
        {{2, 1}, {2, 3}, {2, 6}, {8, 1}, {9, 1}, {8, 3}, {9, 3},{8, 6}, {9, 6}},
        {{1, 1}, {2, 1}, {1, 11}, {2, 11}, {1, 20}, {2, 20}, {1, 35}, {2, 35}, {1, 300}, {300, 1}, {2, 300}, {300, 11}, {300, 20}, {300, 35}, {300, 300}},
        {{1, 1}},
        {{4, 2}, {4, 3}},
        {{4, 4}, {7, 4}, {4, 7}, {9, 4}, {4, 9}},
        {{1, 1}, {1, 1}, {2, 1}}
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(list1[i], list2[i], k[i], expected[i]));
        }
        return testCases.stream();
    }

    KSmallestSumPair kSmallestSumPair = new KSmallestSumPair();
    @ParameterizedTest(name = "Test case: {index} => list1={0}, list2={1}, k={2}, expected={3}")
    @MethodSource("generateTestCases")
    void testSmallestSumPair(int[] list1, int[] list2, int k, int[][] expected){
        List<List<Integer>> actual = kSmallestSumPair.kSmallestPairs(list1, list2, k);
        List<List<Integer>> expectedList = new ArrayList<>();
        for (int[] ints : expected) {
            expectedList.add(List.of(ints[0], ints[1]));
        }
        assertIterableEquals(expectedList, actual);

    }
}
