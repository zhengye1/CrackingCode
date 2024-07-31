package com.vincnet.twopointer;

import com.vincent.twopointer.ThreeSum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThreeSumTest{
    ThreeSum threeSum = new ThreeSum();
    int[][] numsList = {{3, 7, 1, 2, 8, 4, 5},
            {-1, 2, 1, -4, 5, -3},
            {2, 3, 4, 1, 7, 9},
            {1, -1, 0},
            {2, 4, 2, 7, 6, 3, 1}};

    int[] testList = {10, 7, 20, -1, 8};

    @Test
    void testCase1(){
        assertTrue(threeSum.threeSum(numsList[0],testList[0]));
    }
    @Test
    void testCase2(){
        assertFalse(threeSum.threeSum(numsList[1],testList[1]));
    }
    @Test
    void testCase3(){
        assertTrue(threeSum.threeSum(numsList[2],testList[2]));
    }
    @Test
    void testCase4(){
        assertFalse(threeSum.threeSum(numsList[3],testList[3]));
    }
    @Test
    void testCase5(){
        assertTrue(threeSum.threeSum(numsList[4],testList[4]));
    }
}
