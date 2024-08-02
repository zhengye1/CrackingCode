package com.vincent.slowfast;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HappyNumberTest {
    int[] testCase = {1, 5, 19, 25, 7};
    HappyNumber happyNumber = new HappyNumber();

    @Test
    void testCase1() {
        assertTrue(happyNumber.isHappy(testCase[0]));
    }

    @Test
    void testCase2() {
        assertFalse(happyNumber.isHappy(testCase[1]));
    }

    @Test
    void testCase3() {
        assertTrue(happyNumber.isHappy(testCase[2]));
    }

    @Test
    void testCase4() {
        assertFalse(happyNumber.isHappy(testCase[3]));
    }

    @Test
    void testCase5() {
        assertTrue(happyNumber.isHappy(testCase[4]));
    }
}
