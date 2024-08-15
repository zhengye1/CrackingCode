package com.vincent.array;

import com.vincent.arrays.ProductOfArrayExceptItself;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductOfArrayExceptItselfTest {
    static int[][] input = {
        {1, 2, 3, 4},
        {2, 3, 4, 5},
        {1, 0, 3, 4},
        {5, 0, 2},
        {1, 1, 1, 1}
    };
    static int[][] expected = {
        {24, 12, 8, 6},
        {60, 40, 30, 24},
        {0 , 12,0,0},
        {0, 10, 0},
        {1, 1, 1, 1}
    };
    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(input[i], expected[i]));
        }
        return testCases.stream();
    }

    ProductOfArrayExceptItself productOfArrayExceptItself = new ProductOfArrayExceptItself();

    @ParameterizedTest(name = "Test case: {index} => input={0},expected={1}")
    @MethodSource("generateTestCases")
    void productOfArrayExceptItselfTest(int[] input,  int[] expected) {
        assertArrayEquals(expected, productOfArrayExceptItself.productExceptItself(input));
    }
}
