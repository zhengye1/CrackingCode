package com.vincent.slidewindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindLongestSubstringTest {
   static String[] inputs = {
        "abcabcbb",
        "pwwkew",
        "bbbbb",
        "ababababa",
        "",
        "ABCDEFGHI",
        "ABCDEDCBA",
        "AAAABBBBCCCCDDDD"
    };
    static int[] expected = {
        3,3,1,2,0,9,5,2
    };
    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            testCases.add(Arguments.of(inputs[i],expected[i]));
        }
        return testCases.stream();
    }

    FindLongestSubstring longestSubstring = new FindLongestSubstring();

    @ParameterizedTest(name = "Test case: {index} => input={0}, expected={1}")
    @MethodSource("generateTestCases")
    void testFindLongestSubstring(String input, int expected) {
        assertEquals(expected, longestSubstring.lengthOfLongestSubstring(input));
    }

}
