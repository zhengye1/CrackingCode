package com.vincnet.slidewindow;

import com.vincent.slidewindow.BestTimeBuySellStock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxProfitTest {
    static int[][] inputs = {
        {7,1,5,3,6,4},
        {7,6,4,3,1},
        {4, 10, 11, 1, 6, 7},
        {14, 10, 11, 1, 6, 13},
        {2, 1, 4}
    };
    static int[] expected = {
        5, 0, 7, 12, 3
    };
    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            testCases.add(Arguments.of(inputs[i],expected[i]));
        }
        return testCases.stream();
    }

    BestTimeBuySellStock maxProfit = new BestTimeBuySellStock();

    @ParameterizedTest(name="Test case: {index} => prices={0}, expected={1}")
    @MethodSource("generateTestCases")
    void testMaxProfit(int[] prices, int expected){
        assertEquals(expected, maxProfit.maxProfit(prices));
    }
}
