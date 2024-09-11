package com.vincent.dynamicprogramming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnapsackTest {


    static int[][] weights = {
        { 1, 2, 3, 5 },
        { 4 },
        { 2 },
        { 3, 6, 10, 7, 2 },
        { 3, 6, 10, 7, 2, 12, 15, 10, 13, 20 },
        {63,  55,  47,  83,  61,  82,   6,  34,   9,  38,   6,  69,  17,
            50,   7, 100, 101,   4,  41,  28, 119,  78,  98,  38,  75,  35,
            8,  10,  16,  93,  34,  23,  51,  79, 118,  86,  85, 109,  88,
            72,  99,  36,  21,  80,  42,  44,  62,   7,  54,   7,   6,   0,
            65,  25,  44,  86,  76,  18,  11,  10, 104,  17,  36,  91,  78,
            88,  79, 103,   1,   4,  34,  94,  73,  21,   8,   9,  79,  25,
            106,  76,  39,  78,   1,  92, 104,  84,  40, 100, 116,  84,  23,
            79, 109,  79,  71,  72, 116,  90,  79,  26}
    };
    static int[][] values = {
        { 1, 5, 4, 8 },
        { 2 },
        { 3 },
        { 12, 10, 15, 17, 13 },
        { 12, 10, 15, 17, 13, 12, 30, 15, 18, 20 },
        {35,  47,   8, 103,  83,  71,  11, 107,   9,  34,  41,  54,  73,
            72, 108, 100,  46,  27,  79,  98,  49,  63,  41, 116,  57,  86,
            51,  47,  88, 118,  65,   0,  64,  11,  45,  47,  36,  50, 114,
            90, 105,  55,  93,  12,  73,  96,  50,  27,  36,  97,  12,  21,
            107,  34, 106,  37,  84,  38, 110,  60,  34, 104,  92,  56,  94,
            109,  81,  17,  24, 106,  50,  68,  90,  73,  46,  99,   5,   5,
            22,  27,  58,  24,  20,  80,  37,   1,  16,  39,  26,  32,  12,
            47,  22,  28,  50,  95,   6, 105, 101,  20}
    };

    static int[] capacity = { 6, 3, 3, 10, 20, 1000 };

    static int[] expected = {10, 0, 3, 30, 55, 2879};

    Knapsack knapsack = new Knapsack();
    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < weights.length; i++) {
            testCases.add(Arguments.of(weights[i], values[i], capacity[i],  expected[i]));
        }
        return testCases.stream();
    }

    @ParameterizedTest(name = "Test case: {index} => weights={0} values={1} capacity={2} expected={3}")
    @MethodSource("generateTestCases")
    void knapsack2DTest(int[] weights, int[] values, int capacity, int expected) {
        assertEquals(expected, knapsack.knapsack(capacity, values, weights));
    }

    @ParameterizedTest(name = "Test case: {index} => weights={0} values={1} capacity={2} expected={3}")
    @MethodSource("generateTestCases")
    void knapsack1DTest(int[] weights, int[] values, int capacity, int expected) {
        assertEquals(expected, knapsack.knapsack1D(capacity, values, weights));
    }
}
