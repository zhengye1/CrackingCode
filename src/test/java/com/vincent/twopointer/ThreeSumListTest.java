package com.vincent.twopointer;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class ThreeSumListTest {
    ThreeSumList solution = new ThreeSumList();

    @Test
    void testCase1() {
        List<List<Integer>> result = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        // create the expected list
        List<List<Integer>> expected = List.of(List.of(-1, -1, 2), List.of(-1, 0, 1));


        assert (expected.size() == result.size());
        List<Integer> list1 = expected.get(0);
        List<Integer> list2 = expected.get(1);
        for (List<Integer> iterator : result) {
            Collections.sort(iterator);
            assert (iterator.equals(list1) || iterator.equals(list2));
        }
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
