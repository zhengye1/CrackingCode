package com.vincent.kwaymerge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KSmallestInMListTest {

    static List<List<List<Integer>>> lists =
        Arrays.asList(Arrays.asList(Arrays.asList(2, 6, 8), Arrays.asList(3, 6, 10), Arrays.asList(5, 8, 11)),
            Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5), Arrays.asList(6, 7, 8, 15),
                Arrays.asList(10, 11, 12, 13), Arrays.asList(5, 10)),
            Arrays.asList(Arrays.asList(), Arrays.asList(), Arrays.asList()),
            Arrays.asList(Arrays.asList(1, 1, 3, 8), Arrays.asList(5, 5, 7, 9), Arrays.asList(3, 5, 8, 12)),
            Arrays.asList(Arrays.asList(5, 8, 9, 17), Arrays.asList(), Arrays.asList(8, 17, 23, 24)));

    static int[] k = {5, 50, 7, 4, 8};

    static int[] expected = {6, 15, 0, 3, 24};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(lists.get(i), k[i], expected[i]));
        }
        return testCases.stream();
    }

    KSmallestNumberInMSortedList kSmallestNumberInMSortedList = new KSmallestNumberInMSortedList();

    @ParameterizedTest(name = "Test case: {index} => lists={0}, k={1}, expected={2}")
    @MethodSource("generateTestCases")
    void testKSmallestNumberInMSortedList(List<List<Integer>> lists, int k, int expected) {
        assertEquals(expected, kSmallestNumberInMSortedList.kSmallestNumber(lists, k));
    }
}
