package com.vincent.prefixtree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class SuggestSystemTest {
    static String[][] inputProducts = {
        {"mobile","mouse","moneypot","monitor","mousepad"},
        {"havana"},
        {"bags","baggage","banner","box","cloths"},
        {"havana"},
        {"razer","blade","knife","cutter","games"}
    };
    static String[] inputSearchWords = {
        "mouse", "havana", "bags", "tatiana", "games"
    };

    static List<List<List<String>>> expected = List.of(
        List.of(List.of("mobile", "moneypot", "monitor"), List.of("mobile", "moneypot", "monitor"), List.of("mouse", "mousepad"), List.of("mouse", "mousepad"), List.of("mouse", "mousepad")),
        List.of(List.of("havana"), List.of("havana"), List.of("havana"), List.of("havana"), List.of("havana"), List.of("havana")),
        List.of(List.of("baggage","bags","banner"), List.of("baggage","bags","banner"),List.of("baggage", "bags"), List.of("bags")),
        List.of(List.of(),List.of(),List.of(),List.of(),List.of(),List.of(), List.of()),
        List.of(List.of("games"), List.of("games"), List.of("games"),List.of("games"),List.of("games"))
    );


    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.size(); i++) {
            testCases.add(Arguments.of(inputProducts[i], inputSearchWords[i], expected.get(i)));
        }
        return testCases.stream();
    }
    SuggestSystem suggestSystem = new SuggestSystem();
    @ParameterizedTest(name = "Test case: {index} => products={0}, searchWord={1} expected={2}")
    @MethodSource("generateTestCases")
    void suggestSystemTestTrie(String[] products, String searchWord, List<List<String>> expected) {
        assertIterableEquals(expected, suggestSystem.suggestedProductsTrie(products, searchWord));
    }

    @ParameterizedTest(name = "Test case: {index} => products={0}, searchWord={1} expected={2}")
    @MethodSource("generateTestCases")
    void suggestSystemTestTwoPointer(String[] products, String searchWord, List<List<String>> expected) {
        assertIterableEquals(expected, suggestSystem.suggestedProductsPointer(products, searchWord));
    }


    @ParameterizedTest(name = "Test case: {index} => products={0}, searchWord={1} expected={2}")
    @MethodSource("generateTestCases")
    void suggestSystemTestTwoBinarySearch(String[] products, String searchWord, List<List<String>> expected) {
        assertIterableEquals(expected, suggestSystem.suggestProductPointerBinarySearch(products, searchWord));
    }
}
