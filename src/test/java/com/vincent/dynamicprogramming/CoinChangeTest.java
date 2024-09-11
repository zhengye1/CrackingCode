package com.vincent.dynamicprogramming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinChangeTest {
    static int[][] coins = {{2, 3, 4, 5}, {1, 4, 6, 9}, {6, 7, 8}, {1, 2, 3, 4, 5}, {14, 15, 18, 20}};
    static int[] total = {7, 11, 27, 41, 52};
    static int[] expected = {2, 3, 4, 9, 3};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(coins[i], total[i], expected[i]));
        }
        return testCases.stream();
    }

    CoinChange coinChange = new CoinChange();

    @ParameterizedTest(name = "Test case: {index} => coins={0} total={1} expected={2}")
    @MethodSource("generateTestCases")
    void coinChangeTest2D(int[] coins, int total, int expected) {
        assertEquals(expected, coinChange.coinChange(coins, total));
    }

    @ParameterizedTest(name = "Test case: {index} => coins={0} total={1} expected={2}")
    @MethodSource("generateTestCases")
    void coinChangeTest1D(int[] coins, int total, int expected) {
        assertEquals(expected, coinChange.coinChange1D(coins, total));
    }
}
