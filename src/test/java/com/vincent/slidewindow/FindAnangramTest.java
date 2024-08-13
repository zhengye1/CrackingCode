package com.vincent.slidewindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class FindAnangramTest {
    FindAnagram findAnagram = new FindAnagram();

    static String[] s = {
            "cbaebabacd",
            "abab",
            "af",
            "abcdefg",
            "aaabbbccc",
            "abc"
    };
    static String[] p = {
            "abc",
            "ab",
            "a",
            "hij",
            "abc",
            "abcd"
    };
    static int[][] expected = {
            {0, 6},
            {0, 1, 2},
            {0},
            {},
            {},
            {}
    };
    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            List<Integer> expcetedList = new ArrayList<>();
            for (int j = 0; j < expected[i].length; j++) {
                expcetedList.add(expected[i][j]);
            }
            testCases.add(Arguments.of(s[i], p[i], expcetedList));
        }
        return testCases.stream();
    }

    @ParameterizedTest(name = "Test case: {index} => s={0}, p={1} expected={2}")
    @MethodSource("generateTestCases")
    void findAnagramTest(String s, String p, List<Integer> expected) {
        assertIterableEquals(expected, findAnagram.findAnagrams(s, p));
    }



}
