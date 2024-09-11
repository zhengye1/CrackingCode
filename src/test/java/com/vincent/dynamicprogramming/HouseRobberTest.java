package com.vincent.dynamicprogramming;

import com.vincent.util.Tree;
import com.vincent.util.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HouseRobberTest {
    HouseRobber houseRobber = new HouseRobber();
    static int[][] inputRobber1 =
        {{0, 1, 2, 5}, {1, 2, 3, 1}, {4, 6, 3, 9, 3, 8, 3}, {1, 5, 7, 3, 7, 2, 3}, {2, 7, 9, 3, 1}};
    static int[] expectedRobber1 = {6, 4, 23, 18, 12};

    static Stream<Arguments> generateTestCasesRobber1() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < inputRobber1.length; i++) {
            testCases.add(Arguments.of(inputRobber1[i], expectedRobber1[i]));
        }
        return testCases.stream();
    }

    @ParameterizedTest(name = "Test case: {index} => input={0} expected={1}")
    @MethodSource("generateTestCasesRobber1")
    void houseRobberITest(int[] input, int expected) {
        assertEquals(expected, houseRobber.robI(input));
    }

    static int[][] inputRobber2 =
        {{2, 3, 2}, {1, 2, 3, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {7, 4, 1, 9, 3}, {}};
    static int[] expectedRobber2 = {3, 4, 63, 16, 0};

    static Stream<Arguments> generateTestCasesRobber2() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < inputRobber2.length; i++) {
            testCases.add(Arguments.of(inputRobber2[i], expectedRobber2[i]));
        }
        return testCases.stream();
    }

    @ParameterizedTest(name = "Test case: {index} => input={0} expected={1}")
    @MethodSource("generateTestCasesRobber2")
    void houseRobberIITest(int[] input, int expected) {
        assertEquals(expected, houseRobber.robII(input));
    }

    static List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
        Arrays.asList( new TreeNode<>(10), new TreeNode<>(9), new TreeNode<>(20), new TreeNode<>(15), new TreeNode<>(7)),
        Arrays.asList( new TreeNode<>(7), new TreeNode<>(9), new TreeNode<>(10), new TreeNode<>(15), new TreeNode<>(20)),
        Arrays.asList( new TreeNode<>(8), new TreeNode<>(2), new TreeNode<>(17), new TreeNode<>(1), new TreeNode<>(4), new TreeNode<>(19), new TreeNode<>(5)),
        Arrays.asList( new TreeNode<>(7), new TreeNode<>(3), new TreeNode<>(4), new TreeNode<>(1), new TreeNode<>(3)),
        Arrays.asList( new TreeNode<>(9), new TreeNode<>(5), new TreeNode<>(7), new TreeNode<>(1), new TreeNode<>(3)),
        Arrays.asList( new TreeNode<>(9), new TreeNode<>(7), null, null, new TreeNode<>(1), new TreeNode<>(8), new TreeNode<>(10), null, new TreeNode<>(12))
    );

    static int[] expectedRobber3  ={
        42, 45, 37, 11, 13, 31
    };

    static Stream<Arguments> generateTestCasesRobber3() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < listOfTrees.size(); i++) {
            Tree<Integer> tree = new Tree<>(listOfTrees.get(i));
            testCases.add(Arguments.of(tree.root, expectedRobber3[i]));
        }
        return testCases.stream();
    }
    @ParameterizedTest(name = "Test case: {index} => input={0} expected={1}")
    @MethodSource("generateTestCasesRobber3")
    void houseRobberIIITest(TreeNode<Integer> input, int expected) {
        assertEquals(expected, houseRobber.robIII(input));
    }
}
