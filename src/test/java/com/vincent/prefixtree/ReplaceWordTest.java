package com.vincent.prefixtree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReplaceWordTest {
    static List<List<String>> dictionary = Arrays.asList(Arrays.asList("wi", "wa", "w"),
        Arrays.asList("qui", "f", "la", "d"),
        Arrays.asList("oops", "there", "is", "no", "matching", "word", "in", "this", "sentence"),
        Arrays.asList("wa", "w", "a", "ty", "nint", "nin", "n", "feb", "februa", "f"),
        Arrays.asList("cool", "how", "sunday", "sun", "x"));
    static String[] sentence = {
        "where there is a will there is a way",
        "the quick brown fox jumps over the lazy dog",
        "oops there is no matching word in this sentence",
        "i was born on twenty ninth february",
        "i dont know where you are but i will find you eventually"
    };

    static String[] expected = {
        "w there is a w there is a w",
        "the qui brown f jumps over the la d",
        "oops there is no matching word in this sentence",
        "i w born on twenty n f",
        "i dont know where you are but i will find you eventually"
    };


    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(dictionary.get(i), sentence[i], expected[i]));
        }
        return testCases.stream();
    }
    ReplaceWord replaceWord = new ReplaceWord();

    @ParameterizedTest(name = "Test case: {index} => dictionary={0}, sentences={1} expected={2}")
    @MethodSource("generateTestCases")
    void replaceWordUsingTrie(List<String> dictionary, String sentence, String expected) {
        assertEquals(expected, replaceWord.replaceWordsTrie(dictionary, sentence));
    }

    @ParameterizedTest(name = "Test case: {index} => dictionary={0}, sentences={1} expected={2}")
    @MethodSource("generateTestCases")
    void replaceWordUsingStartsWith(List<String> dictionary, String sentence, String expected) {
        assertEquals(expected, replaceWord.replaceWordNonTrie(dictionary, sentence));
    }
}
