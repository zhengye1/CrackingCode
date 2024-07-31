package com.vincnet.twopointer;

import com.vincent.twopointer.SortColor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortColorsTest {
    SortColor sortColor = new SortColor();
    int[][] inputs = {
            {0, 1, 0},
            {1, 1, 0, 2},
            {2, 1, 1, 0, 0},
            {2, 2, 2, 0, 1, 0},
            {2, 1, 1, 0, 1, 0, 2}
    };

    @Test
    void testCase1() {
        assertArrayEquals(new int[]{0, 0, 1}, sortColor.sortColors(inputs[0]));
    }

    @Test
    void testCase2() {
        assertArrayEquals(new int[]{0, 1, 1, 2}, sortColor.sortColors(inputs[1]));
    }

    @Test
    void testCase3() {
        assertArrayEquals(new int[]{0, 0, 1, 1, 2}, sortColor.sortColors(inputs[2]));
    }

    @Test
    void testCase4() {
        assertArrayEquals(new int[]{0, 0, 1, 2, 2, 2}, sortColor.sortColors(inputs[3]));
    }

    @Test
    void testCase5() {
        assertArrayEquals(new int[]{0, 0, 1, 1, 1, 2, 2}, sortColor.sortColors(inputs[4]));
    }
}
