package com.vincnet.slidewindow;

import com.vincent.slidewindow.MinimumWindowSubstring;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumWindowSubstringTest {
    static String[] s =
        {"PATTERN", "LIFE", "ABRACADABRA", "STRIKER", "DFFDFDFVD", "ADOBEBANCCODE", "ABAACBBA", "ABAACBAEBC",
            "ABAACBAB", "ABDFGDCKAB"};
    static String[] t = {"TN", "I", "ABC", "RK", "VDD", "ACB", "ABC", "ABCC", "ABCC", "ABCD"};
    static String[] output = {"TERN", "I", "BRAC", "RIK", "DFVD", "BANC", "ACB", "CBAEBC", "", "DCKAB"};

    static Stream<Arguments> generateTestCases() {
        // create the arguments using str1, str2, output and add it to stream
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            testCases.add(Arguments.of(s[i], t[i], output[i]));
        }
        return testCases.stream();
    }

    MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();

    @ParameterizedTest(name = "{index} => str1={0}, str2={1}, expected={2}")
    @MethodSource("generateTestCases")
    void testMinimumSubstring(String str1, String str2, String expected) {
        assertEquals(expected, minimumWindowSubstring.minWindow(str1, str2));
    }
}
