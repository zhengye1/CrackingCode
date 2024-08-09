package com.vincent.topkelement;

import com.vincent.slidewindow.FindLongestSubstring;
import com.vincent.util.LinkedList;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReorganizeStringTest {
    static String[] inputs = {"programming", "hello", "fofjjb", "abbacdde", "aba", "awesome", "aaab", "aab"};
    static String[] expected = {"rgmrgmpiano", "loelh", "fjofjb", "abdabdce", "aba", "eomewas", "", "aba"};


    FindLongestSubstring findLongestSubstring = new FindLongestSubstring(); // that using the to test the result
    ReorganizeString reorganizeString = new ReorganizeString();

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(inputs[i], expected[i]));
        }
        return testCases.stream();
    }

    @ParameterizedTest(name = "Test case: {index} => inputs={0}, expect={1}")
    @MethodSource("generateTestCases")
    void testReorganizedString(String input, String expect){
        char[] expectedChar = expect.toCharArray();
        String actual = reorganizeString.reorganizeString(input);
        char[] actualChar = actual.toCharArray();
        Arrays.sort(expectedChar);
        Arrays.sort(actualChar);
        assertArrayEquals(expectedChar, actualChar);
    }
}
