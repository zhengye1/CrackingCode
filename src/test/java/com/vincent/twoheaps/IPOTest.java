package com.vincent.twoheaps;

import com.vincent.util.LinkedList;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPOTest {
    static int[] c = { 0, 1, 1, 2, 1, 7, 2 };
    static int[] k = { 1, 2, 2, 3, 3, 2, 4 };
    static int[][] capitals = {
        {1, 1, 2},
        {1, 2, 2, 3},
        {1, 2, 2, 3},
        {1, 3, 4, 5, 6},
        {1, 2, 3, 4},
        {6, 7, 8, 10},
        {2, 3, 5, 6, 8, 12}
    };
   static int[][] profits = {
        {1, 2, 3},
        {2, 4, 6, 8},
        {2, 4, 6, 5},
        {1, 2, 3, 4, 5},
        {1, 3, 5, 7},
        {4, 8, 12, 14},
        {1, 2, 5, 6, 8, 9}
    };

   static int[] expected = {0, 11, 9, 9, 12, 29, 18};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(c[i], k[i], capitals[i], profits[i], expected[i]));
        }
        return testCases.stream();
    }

    IPO ipo = new IPO();

    @ParameterizedTest(name = "Test case: {index} => c={0}, k={1}, capitals={2}, profits={3}, expected={4}")
    @MethodSource("generateTestCases")
    void testIPO(int c, int k, int[] capitals, int[] profits, int expected) {
        assertEquals(expected, ipo.maximumCapital(c, k, capitals, profits));
    }

}
