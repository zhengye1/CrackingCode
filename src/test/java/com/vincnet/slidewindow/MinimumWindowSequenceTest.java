package com.vincnet.slidewindow;

import com.vincent.slidewindow.MinimumWindowSequence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumWindowSequenceTest {
    MinimumWindowSequence minimumWindowSequence = new MinimumWindowSequence();
    static String[] str1 = {"abcdedeaqdweq", "fgrqsqsnodwmxzkzxwqegkndaa", "zxcvnhss", "alpha", "beta", "asbbfbdkfgebfbd"};
    static String[] str2 = {"adeq", "kzed", "css", "la", "ab", "bfd"};
    static String[] output = {"aqdweq", "kzxwqegknd", "cvnhss", "lpha", "", "bfbd"};

    static Stream<Arguments> generateTestCases(){
        // create the arguments using str1, str2, output and add it to stream
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < str1.length; i++) {
            testCases.add(Arguments.of(str1[i], str2[i], output[i]));
        }
        return testCases.stream();

    }
    @ParameterizedTest(name = "{index} => str1={0}, str2={1}, expected={2}")
    @MethodSource("generateTestCases")
    void testMinimumWindowSequence(String str1 , String str2, String expected) {
        assertEquals(expected, minimumWindowSequence.minWindow(str1, str2));
    }
}
