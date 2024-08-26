package com.vincent.graph.topologicalsort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlienDictionaryTest {
    static String[][] words = {
        {"alpha", "bravo", "charlie", "delta"},
        {"apple", "app"},
        {"martian"},
        {"jupyter", "ascending"},
        {"passengers", "to", "the", "unknown"}
    };
    static String[] order = {
        "abcdefghijklmnopqrstuvwxyz",
        "abcdefghijklmnopqrstuvwxyz",
        "mabcdefghijklnopqrstuvwxyz",
        "jabcdefghiklmnopqrstuvwxyz",
        "ptuhabcdefghijklmnoqrsvwxyz"
    };

    static boolean[] expected = {
        true, false, true, true, false
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            testCases.add(Arguments.of(words[i], order[i], expected[i]));
        }
        return testCases.stream();
    }

    AlienDictionary dictionary = new AlienDictionary();

    @ParameterizedTest(name = "Test case: {index} => words={0} order={1} expected={2}")
    @MethodSource("generateTestCases")
    void verifyAlienDictionaryTest(String[] words, String order, boolean expected){
        assertEquals(expected, dictionary.isAlienSorted(words, order));
    }



}
