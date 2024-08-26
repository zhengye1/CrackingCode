package com.vincent.graph;

import com.vincent.util.Tree;
import com.vincent.util.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfIslandTest {
    static char[][] grid1 = {
            {'1', '1', '1'},
            {'0', '1', '0'},
            {'1', '0', '0'},
            {'1', '0', '1'}
    };

    static char[][] grid2 = {
            {'1', '1', '1', '1', '0'},
            {'1', '0', '0', '0', '1'},
            {'1', '0', '0', '1', '1'},
            {'0', '1', '0', '1', '0'},
            {'1', '1', '0', '1', '1'}
    };

    static char[][] grid3 = {
            {'1', '1', '1', '1', '0'},
            {'1', '0', '0', '0', '1'},
            {'1', '1', '1', '1', '1'},
            {'0', '1', '0', '1', '0'},
            {'1', '1', '0', '1', '1'}
    };

    static char[][] grid4 = {
            {'1', '0', '1', '0', '1'},
            {'0', '1', '0', '1', '0'},
            {'1', '0', '1', '0', '1'},
            {'0', '1', '0', '1', '0'},
            {'1', '0', '1', '0', '1'}
    };

    static char[][] grid5 = {
            {'1', '0', '1'},
            {'0', '0', '0'},
            {'1', '0', '1'}
    };

    // Combine all grids into a 3D array
    static char[][][] inputs = {grid1, grid2, grid3, grid4, grid5};
    static int[] expected = {3, 3, 1, 13, 4};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            testCases.add(Arguments.of(inputs[i], expected[i]));
        }
        return testCases.stream();
    }
    NumberOfIsland numberOfIsland = new NumberOfIsland();

    @ParameterizedTest(name = "Test case: {index} => grid={0} expected={1}")
    @MethodSource("generateTestCases")
    void numberOfIslandTest(char[][] grid, int expected) {
        char[][] copy = new char[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            copy[i] = new char[grid[i].length];
            System.arraycopy(grid[i], 0, copy[i], 0, grid[i].length);
        }
        assertEquals(expected, numberOfIsland.numIslands(copy));
    }


    @ParameterizedTest(name = "Test case: {index} => grid={0} expected={1}")
    @MethodSource("generateTestCases")
    void numberOfIslandBFSTest(char[][] grid, int expected) {
        char[][] copy = new char[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            copy[i] = new char[grid[i].length];
            System.arraycopy(grid[i], 0, copy[i], 0, grid[i].length);
        }
        assertEquals(expected, numberOfIsland.numIslandsIterative(copy));
    }
}
