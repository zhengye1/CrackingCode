package com.vincent.twopointer;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class ThreeSumListTest {
    ThreeSumList solution = new ThreeSumList();

    @Test
    void testCase1() {
        List<List<Integer>> result = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        // create the expected list
        List<List<Integer>> expected = List.of(List.of(-1, -1, 2), List.of(-1, 0, 1));
        assertIterableEquals(expected, result);
    }

    @Test
    void testCase2() {
        List<List<Integer>> result = solution.threeSum(new int[]{0, 1, 1});
        assert (result.isEmpty());
    }

    @Test
    void testCase3() {
        List<List<Integer>> result = solution.threeSum(new int[]{0, 0, 0});
        List<List<Integer>> expected = List.of(List.of(0, 0, 0));
        assert (expected.size() == result.size());
        for (List<Integer> iterator : result) {
            assert (iterator.equals(expected.getFirst()));
        }
    }
}
