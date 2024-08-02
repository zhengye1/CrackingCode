package com.vincent.slowfast;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuplicateNumberTest {
    DuplicateNumber duplicateNumber = new DuplicateNumber();

    int[][] input = {{1, 3, 4, 2, 2}, {3, 1, 3, 4, 2}, {3, 3, 3, 3, 3}, {2, 5, 8, 6, 8, 3, 9, 8, 1, 7}};

    @Test
    void testCase1() {
        int testCase = 0;
        assertEquals(2, duplicateNumber.findDuplicate(input[testCase]));
    }

    @Test
    void testCase2() {
        int testCase = 1;
        assertEquals(3, duplicateNumber.findDuplicate(input[testCase]));
    }

    @Test
    void testCase3() {
        int testCase = 2;
        assertEquals(3, duplicateNumber.findDuplicate(input[testCase]));
    }

    @Test
    void testCase4() {
        int testCase = 3;
        assertEquals(8, duplicateNumber.findDuplicate(input[testCase]));
    }

    @Test
    void testCase5() {
        int testCase = 0;
        assertEquals(2, duplicateNumber.findDuplicateUsingSpace(input[testCase]));
    }

    @Test
    void testCase6() {
        int testCase = 1;
        assertEquals(3, duplicateNumber.findDuplicateUsingSpace(input[testCase]));
    }

    @Test
    void testCase7() {
        int testCase = 2;
        assertEquals(3, duplicateNumber.findDuplicateUsingSpace(input[testCase]));
    }

    @Test
    void testCase8() {
        int testCase = 3;
        assertEquals(8, duplicateNumber.findDuplicateUsingSpace(input[testCase]));
    }

}
