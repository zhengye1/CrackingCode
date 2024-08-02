package com.vincent.slowfast;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircularArrayLoopTest {
    int[][] input = {
        {-2, -3, -9},
        {-5, -4, -3, -2, -1},
        {-1, -2, -3, -4, -5},
        {2, 1, -1, -2},
        {-1, -2, -3, -4, -5, 6},
        {1, 2, -3, 3, 4, 7, 1},
        {2, 2, 2, 7, 2, -1, 2, -1, -1}
    };

    CircularArrayLoop circularArrayLoop = new CircularArrayLoop();

    @Test
    void testCase1(){
        int testCase = 0;
        assertFalse(circularArrayLoop.circularArrayLoop(input[testCase]));
    }

    @Test
    void testCase2(){
        int testCase = 1;
        assertTrue(circularArrayLoop.circularArrayLoop(input[testCase]));
    }

    @Test
    void testCase3(){
        int testCase = 2;
        assertFalse(circularArrayLoop.circularArrayLoop(input[testCase]));
    }

    @Test
    void testCase4(){
        int testCase = 3;
        assertFalse(circularArrayLoop.circularArrayLoop(input[testCase]));
    }

    @Test
    void testCase5(){
        int testCase = 4;
        assertFalse(circularArrayLoop.circularArrayLoop(input[testCase]));
    }

    @Test
    void testCase6(){
        int testCase = 5;
        assertTrue(circularArrayLoop.circularArrayLoop(input[testCase]));
    }

    @Test
    void testCase7(){
        int testCase = 6;
        assertTrue(circularArrayLoop.circularArrayLoop(input[testCase]));
    }
}
