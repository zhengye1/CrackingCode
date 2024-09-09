package com.vincent.array;

import com.vincent.arrays.RemoveDuplicateFromArray;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicateFromArrayTest {
    static int[][] nums = {
        {1, 1, 2},
        {0,0,1,1,1,2,2,3,3,4}
    };

    static int[][] expectedArray = {
        {1, 2},
        {0, 1,2, 3,4}
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expectedArray.length; i++) {
            testCases.add(Arguments.of(nums[i], expectedArray[i]));
        }
        return testCases.stream();
    }

    RemoveDuplicateFromArray removeDuplicateFromArray = new RemoveDuplicateFromArray();
    @ParameterizedTest(name = "Test case: {index} nums={0}, expectedArray={1}")
    @MethodSource("generateTestCases")
    void removeDuplicateFromArrayTest(int[] nums, int[] expectedArray) {
        assertEquals(expectedArray.length, removeDuplicateFromArray.removeDuplicates(nums));
        for (int i = 0; i < expectedArray.length; i++) {
            assertEquals(expectedArray[i], nums[i]);
        }

    }
}
