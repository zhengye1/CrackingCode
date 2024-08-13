package com.vincent.subset;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubsetTest {
    static int[][] inputSets = {{}, {2, 5, 7}, {1, 2}, {1, 2, 3, 4}, {7, 3, 1, 5}};

    static int[][][] expected = {{{}}, {{}, {2}, {5}, {2, 5}, {7}, {2, 7}, {5, 7}, {2, 5, 7}}, {{}, {1}, {2}, {1, 2}},
        {{}, {1}, {2}, {1, 2}, {3}, {1, 3}, {2, 3}, {1, 2, 3}, {4}, {1, 4}, {2, 4}, {1, 2, 4}, {3, 4}, {1, 3, 4},
            {2, 3, 4}, {1, 2, 3, 4}},
        {{}, {7}, {3}, {3, 7}, {1}, {7, 1}, {3, 1}, {7, 3, 1}, {5}, {7, 5}, {3, 5}, {7, 3, 5}, {1, 5}, {7, 1, 5},
            {3, 1, 5}, {7, 3, 1, 5}}};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            List<List<Integer>> innerList = new ArrayList<>();
            for (int j = 0; j < expected[i].length; j++) {
                List<Integer> singleList = new ArrayList<>();
                for (int k = 0; k < expected[i][j].length; k++) {
                    singleList.add(expected[i][j][k]);
                }
                innerList.add(singleList);
            }
            testCases.add(Arguments.of(inputSets[i], innerList));
        }
        return testCases.stream();
    }

    Subset subset = new Subset();

    @ParameterizedTest(name = "Test case: {index} => inputSet={0}, expect={1}")
    @MethodSource("generateTestCases")
    void subsetTest(int[] nums, List<List<Integer>> expected) {
        List<List<Integer>> actual = subset.subsets(nums);
        // 对每个子集进行排序
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
