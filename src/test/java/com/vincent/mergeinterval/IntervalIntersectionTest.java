package com.vincent.mergeinterval;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class IntervalIntersectionTest {
    static int[][][] inputIntervalLista = {{{1, 2}}, {{1, 4}, {5, 6}, {9, 15}}, {{3, 6}, {8, 16}, {17, 25}},
        {{4, 7}, {9, 16}, {17, 28}, {39, 50}, {55, 66}, {70, 89}}, {{1, 3}, {5, 6}, {7, 8}, {12, 15}}};

    static int[][][] inputIntervalListb = {{{1, 2}}, {{2, 4}, {5, 7}, {9, 15}}, {{2, 3}, {10, 15}, {18, 23}},
        {{3, 6}, {7, 8}, {9, 10}, {14, 19}, {23, 33}, {35, 40}, {45, 59}, {60, 64}, {68, 76}}, {{2, 4}, {7, 10}}};

    static int[][][] expected = {{{1, 2}}, {{2, 4}, {5, 6}, {9, 15}}, {{3, 3}, {10, 15}, {18, 23}},
        {{4, 6}, {7, 7}, {9, 10}, {14, 16}, {17, 19}, {23, 28}, {39, 40}, {45, 50}, {55, 59}, {60, 64}, {70, 76}},
        {{2, 3}, {7, 8}}};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < inputIntervalLista.length; i++) {
            testCases.add(Arguments.of(inputIntervalLista[i], inputIntervalListb[i], expected[i]));
        }
        return testCases.stream();
    }

    IntervalIntersection intervalIntersection = new IntervalIntersection();

    @ParameterizedTest(name = "Test case: {index} => inputIntervalLista={0}, inputIntervalListb={1}, expected={2}")
    @MethodSource("generateTestCases")
    void testIntervalIntersection(int[][] inputIntervalLista, int[][] inputIntervalListb, int[][] expected) {
        assertArrayEquals(expected, intervalIntersection.intervalIntersection(inputIntervalLista, inputIntervalListb));
    }
}
