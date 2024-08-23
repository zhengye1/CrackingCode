package com.vincent.binarytree;

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
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class PathSumTest {
    static List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
        Arrays.asList(new TreeNode<>(5), new TreeNode<>(4), new TreeNode<>(8), new TreeNode<>(11), null, new TreeNode<>(13), new TreeNode<>(4), new TreeNode<>(7), new TreeNode<>(2), null, null,  new TreeNode<>(5) , new TreeNode<>(1)),
        Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(3)),
        Arrays.asList(),
        Arrays.asList(new TreeNode<>(10), new TreeNode<>(5), new TreeNode<>(-3), new TreeNode<>(3), new TreeNode<>(2), null, new TreeNode<>(11), new TreeNode<>(3), new TreeNode<>(-2), null, new TreeNode<>(1)),
        Arrays.asList(new TreeNode<>(1)),
        Arrays.asList(new TreeNode<>(1), new TreeNode<>(2))
    );
   static  int[] targetSum = {
        22, 5, 0, 8, 1, 1
    };

   static boolean[] pathSumIExpected = {
       true, false, false, false, true, false
   };

   static List<List<List<Integer>>> pathSumIIExpected = Arrays.asList(
       Arrays.asList(Arrays.asList(5, 4, 11, 2), Arrays.asList(5, 8, 4, 5)),
       List.of(),
       List.of(),
       List.of(),
       List.of(List.of(1)),
       List.of()
   );

   static int[] pathSumIIIExpected = {
       3, 0, 0,3,1,1
   };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < listOfTrees.size(); i++) {
            Tree<Integer> tree = new Tree<>(listOfTrees.get(i));
             testCases.add(Arguments.of(tree.root, targetSum[i], pathSumIExpected[i],pathSumIIExpected.get(i), pathSumIIIExpected[i]));
        }
        return testCases.stream();
    }

    PathSum pathSum = new PathSum();

    @ParameterizedTest(name = "Test case: {index} => root={0} targetSum={1} pathSumIExpected={2} pathSumIIExpected={3} pathSumIIIExpected={4}")
    @MethodSource("generateTestCases")
    void testPathSum(TreeNode<Integer> root, int targetSum, boolean pathSumIExpected, List<List<Integer>> pathSumIIExpected, int pathSumIIIExpected) {
        // test path sum 1
        assertEquals(pathSumIExpected, pathSum.pathSumI(root, targetSum));

        // test path sum 2
        assertIterableEquals(pathSumIIExpected, pathSum.pathSumII(root, targetSum));

        // test path sum 3
        assertEquals(pathSumIIIExpected, pathSum.pathSumIII(root, targetSum));
    }
}
