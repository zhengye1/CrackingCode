package com.vincent.dynamicprogramming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class UpgradeMatrixTest {
    static int[][][] mat =
        {{{0, 1}, {1, 1}}, {{0, 0, 1}, {0, 1, 1}, {1, 0, 1}}, {{0, 0, 0}, {0, 1, 0}, {1, 0, 1}},
            {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}, {{0, 1, 0, 1}, {1, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}};

    static int[][][] expected = {{{0, 1}, {1, 2}}, {{0, 0, 1}, {0, 1, 2}, {1, 0, 1}}, {{0, 0, 0}, {0, 1, 0}, {1, 0, 1}},
        {{0, 0, 0}, {0, 1, 0}, {1, 2, 1}}, {{0, 1, 0, 1}, {1, 2, 1, 0}, {0, 1, 2, 1}, {1, 0, 1, 2}}};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(mat[i], expected[i]));
        }
        return testCases.stream();
    }

    UpgradeMatrix upgradeMatrix = new UpgradeMatrix();
    @ParameterizedTest(name = "Test case: {index} => mat={0} expected={1}")
    @MethodSource("generateTestCases")
    void upgradeMatrixTest(int[][] mat, int[][] expected){
        assertArrayEquals(expected, upgradeMatrix.updateMatrix(mat));
    }
}
