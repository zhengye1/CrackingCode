package com.vincent.dynamicprogramming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonSequenceTest {
    static String[] firstStrings = { "qstw", "setter", "abcde", "partner", "freedom" };
    static String[] secondStrings = { "gofvn", "bat", "apple", "park", "redeem" };
    static int[] expected = {
        0, 1, 2, 3, 4
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(firstStrings[i], secondStrings[i], expected[i]));
        }
        return testCases.stream();
    }
    LongestCommonSequence longestCommonSequence = new LongestCommonSequence();

    @ParameterizedTest(name = "Test case: {index} => text1={0} text2={1} expected={2}")
    @MethodSource("generateTestCases")
    void longestCommonSequenceTest(String text1, String text2, int expected) {
        assertEquals(expected, longestCommonSequence.longestCommonSubsequence(text1, text2));
    }
}
