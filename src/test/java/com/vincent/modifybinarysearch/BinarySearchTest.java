package com.vincent.modifybinarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {
    static int[][] numsLists = {
            {},
            {0, 1},
            {1, 2, 3},
            {-1, 0, 3, 5, 9, 12},
            {-100, -67, -55, -50, -49, -40, -33, -22, -10, -5}
    };

    static int[] targetList = {12, 1, 3, 9, -22};
    static int[] expected = {-1, 1, 2, 4, 7};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(numsLists[i], targetList[i], expected[i]));
        }
        return testCases.stream();
    }

    BinarySearch binarySearch = new BinarySearch();
    @ParameterizedTest(name = "Test case: {index} => nums={0}, target={1} expect={2}")
    @MethodSource("generateTestCases")
    void binarySearchTest(int[] nums, int target,int expected){
        assertEquals(expected, binarySearch.binarySearch(nums, target));
    }


    @ParameterizedTest(name = "Test case: {index} => nums={0}, target={1} expect={2}")
    @MethodSource("generateTestCases")
    void binarySearchRecursiveTest(int[] nums, int target,int expected){
        assertEquals(expected, binarySearch.binarySearchRecursive(nums, target));
    }
}
