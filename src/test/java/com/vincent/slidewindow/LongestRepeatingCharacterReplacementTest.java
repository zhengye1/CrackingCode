package com.vincent.slidewindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestRepeatingCharacterReplacementTest {
    LongestRepeatingCharacterReplacement repeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
    static List<String> inputStrings =
        Arrays.asList("aabccbb", "abbcb", "abccde", "abbcab", "bbbbbbbbb", "abab", "aababba");
    static List<Integer> k = Arrays.asList(2, 1, 1, 2, 4, 2, 1);
    static List<Integer> output = Arrays.asList(5, 4, 3, 5, 9, 4, 4);

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < inputStrings.size(); i++) {
            testCases.add(Arguments.of(inputStrings.get(i), k.get(i), output.get(i)));
        }
        return testCases.stream();
    }

    @ParameterizedTest(name = "{index} => s={0}, k={1}, expected={2}")
    @MethodSource("generateTestCases")
    void testLongestRepeatCharacterReplacement(String s, Integer k, int expected) {
        assertEquals(expected, repeatingCharacterReplacement.longestRepeatingCharacterReplacement(s, k));
    }
}
