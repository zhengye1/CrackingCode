package com.vincent.modifybinarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FirstBadVersionTest {
    static int[] testCaseVersions = new int[]{38, 13, 29, 40, 23};
    static int[] firstBadVersionArray = new int[]{28, 10, 10, 28, 19};
    static int[][] expected = {
        {28, 6},
        {10, 4},
        {10, 5},
        {28, 5},
        {19, 4}
    };
    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(testCaseVersions[i], firstBadVersionArray[i], expected[i]));
        }
        return testCases.stream();
    }

    FirstBadVersion firstBadVersion = new FirstBadVersion();
    @ParameterizedTest(name = "Test case: {index} => version={0}, badVersion={1} expect={2}")
    @MethodSource("generateTestCases")
    void firstBadVersionTest(int version, int badVersion, int[] expected) {
        firstBadVersion.setBadVersion(badVersion);
        assertArrayEquals(expected, firstBadVersion.firstBadVersion(version));
    }

    @ParameterizedTest(name = "Test case: {index} => version={0}, badVersion={1} expect={2}")
    @MethodSource("generateTestCases")
    void firstBadVersionRecursiveTest(int version, int badVersion, int[] expected) {
        firstBadVersion.setBadVersion(badVersion);
        assertArrayEquals(expected, firstBadVersion.firstBadVersionRecursive(version));
    }
}
