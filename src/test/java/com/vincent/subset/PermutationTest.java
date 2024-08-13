package com.vincent.subset;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class PermutationTest {
    static String[] inputWord = {"ab", "bad", "abcd"};
    static String[][] expected = {
        {"ab", "ba"},
        {"bad", "bda", "abd","adb", "dba", "dab"},
        {"abcd", "abdc", "acbd", "acdb", "adcb", "adbc", "bacd", "badc", "bcad", "bcda", "bdca", "bdac", "cbad", "cbda", "cabd", "cadb", "cdab", "cdba", "dbca", "dbac", "dcba", "dcab", "dacb", "dabc"}
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            List<String> innerList = new ArrayList<>(Arrays.asList(expected[i]));
            testCases.add(Arguments.of(inputWord[i], innerList));
        }
        return testCases.stream();
    }

    Permutation permutation = new Permutation();

    @ParameterizedTest(name = "Test case: {index} => inputWord={0}, expect={1}")
    @MethodSource("generateTestCases")
    void permutationTest(String inputWord, List<String> expected) {
        List<String> actual = permutation.permute(inputWord);
        expected.sort(Comparator.naturalOrder());
        actual.sort(Comparator.naturalOrder());
        assertIterableEquals(expected, actual);
    }

    static int[][] inputNumbers = {
        {1},
        {1, 2},
        {1, 2, 3},
        {1, 2, 3, 4}
    };
    static int[][][] expectNumbers = {
        {{1}},
        {{1, 2}, {2, 1}},
        {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3 , 2, 1}},
        {
            {1, 2, 3, 4}, {1, 2, 4, 3}, {1, 3, 2, 4}, {1, 3, 4, 2}, {1, 4, 2, 3}, {1, 4, 3, 2},
            {2, 1, 3, 4}, {2, 1, 4, 3}, {2, 3, 1, 4}, {2, 3, 4, 1}, {2, 4, 1, 3}, {2, 4, 3, 1},
            {3, 1, 2, 4}, {3, 1, 4, 2}, {3, 2, 1, 4}, {3, 2, 4, 1}, {3, 4, 1, 2}, {3, 4, 2, 1},
            {4, 1, 2, 3}, {4, 1, 3, 2}, {4, 2, 1, 3}, {4, 2, 3, 1}, {4, 3, 1, 2}, {4, 3, 2, 1}
        }
    };
    static Stream<Arguments> generateTestCasesWithNumber() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expectNumbers.length; i++) {
            List<List<Integer>> innerList = new ArrayList<>();
            for (int j = 0; j < expectNumbers[i].length; j++) {
                List<Integer> singleList = new ArrayList<>();
                for (int k = 0; k < expectNumbers[i][j].length; k++) {
                    singleList.add(expectNumbers[i][j][k]);
                }
                innerList.add(singleList);
            }
            testCases.add(Arguments.of(inputNumbers[i], innerList));
        }
        return testCases.stream();
    }

    @ParameterizedTest(name = "Test case: {index} => inputNumber={0}, expect={1}")
    @MethodSource("generateTestCasesWithNumber")
    void permutationNumberTest(int[] inputNumber, List<List<Integer>> expected) {
        List<List<Integer>> actual = permutation.permute(inputNumber);
        for (List<Integer> subsetValue : actual) {
            Collections.sort(subsetValue);
        }
        for (List<Integer> subsetValue : expected) {
            Collections.sort(subsetValue);
        }
        // 将List转换为Set来比较
        Set<List<Integer>> expectedSet = new HashSet<>(expected);
        Set<List<Integer>> actualSet = new HashSet<>(actual);
        assertEquals(expectedSet, actualSet);
    }
}
