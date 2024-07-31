package com.vincnet.slidewindow;

import com.vincent.slidewindow.SlidingWindowMaximum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SlidingWindowMaximumTest {
    SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
    int[] windowSizes = {3, 3, 3, 3, 2, 4, 3, 2, 3, 6};
    int[][] numLists =
        {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {1, 5, 8, 10, 10, 10, 12, 14, 15, 19, 19, 19, 17, 14, 13, 12, 12, 12, 14, 18, 22, 26, 26, 26, 28, 29, 30},
            {10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67}, {4, 5, 6, 1, 2, 3}, {9, 5, 3, 1, 6, 3},
            {2, 4, 6, 8, 10, 12, 14, 16}, {-1, -1, -2, -4, -6, -7}, {4, 4, 4, 4, 4, 4}};

    @Test
    void testCase1() {
        int testCase = 0;
        assertArrayEquals(new int[] {3, 4, 5, 6, 7, 8, 9, 10},
            slidingWindowMaximum.maxSlidingWindow(numLists[testCase], windowSizes[testCase]));
    }

    @Test
    void testCase2() {
        int testCase = 1;
        assertArrayEquals(new int[] {10, 9, 8, 7, 6, 5, 4, 3},
            slidingWindowMaximum.maxSlidingWindow(numLists[testCase], windowSizes[testCase]));
    }

    @Test
    void testCase3() {
        int testCase = 2;
        assertArrayEquals(new int[] {10, 10, 10, 10, 10, 10, 10, 10},
            slidingWindowMaximum.maxSlidingWindow(numLists[testCase], windowSizes[testCase]));
    }

    @Test
    void testCase4() {
        int testCase = 3;
        assertArrayEquals(
            new int[] {8, 10, 10, 10, 12, 14, 15, 19, 19, 19, 19, 19, 17, 14, 13, 12, 14, 18, 22, 26, 26, 26, 28, 29, 30},
            slidingWindowMaximum.maxSlidingWindow(numLists[testCase], windowSizes[testCase]));
    }

    @Test
    void testCase5() {
        int testCase = 4;
        assertArrayEquals(new int[] {10, 9, 9, 23, 23, 34, 56, 67, 67, -1, -4, -2, 9, 10, 34, 67},
            slidingWindowMaximum.maxSlidingWindow(numLists[testCase], windowSizes[testCase]));
    }

    @Test
    void testCase6() {
        int testCase = 5;
        assertArrayEquals(new int[] {6, 6, 6},
            slidingWindowMaximum.maxSlidingWindow(numLists[testCase], windowSizes[testCase]));
    }

    @Test
    void testCase7() {
        int testCase = 6;
        assertArrayEquals(new int[] {9, 5, 6, 6},
            slidingWindowMaximum.maxSlidingWindow(numLists[testCase], windowSizes[testCase]));
    }

    @Test
    void testCase8() {
        int testCase = 7;
        assertArrayEquals(new int[] {4, 6, 8, 10, 12, 14, 16},
            slidingWindowMaximum.maxSlidingWindow(numLists[testCase], windowSizes[testCase]));
    }

    @Test
    void testCase9() {
        int testCase = 8;
        assertArrayEquals(new int[] {-1, -1, -2, -4},
            slidingWindowMaximum.maxSlidingWindow(numLists[testCase], windowSizes[testCase]));
    }

    @Test
    void testCase10() {
        int testCase = 9;
        assertArrayEquals(new int[] {4},
            slidingWindowMaximum.maxSlidingWindow(numLists[testCase], windowSizes[testCase]));
    }
}
