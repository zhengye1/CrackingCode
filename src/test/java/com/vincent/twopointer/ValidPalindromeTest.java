package com.vincent.twopointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidPalindromeTest {

    ValidPalindrome validPalindrome = new ValidPalindrome();

    @Test
    void testCase1(){
        assertFalse(validPalindrome.isPalindrome("RACEACAR"));
    }

    @Test
    void testCase2(){
        assertTrue(validPalindrome.isPalindrome("A"));
    }

    @Test
    void testCase3(){
        assertTrue(validPalindrome.isPalindrome("ABCDEFGFEDCBA"));
    }
    @Test
    void testCase4(){
        assertFalse(validPalindrome.isPalindrome("ABC"));
    }
    @Test
    void testCase5(){
        assertTrue(validPalindrome.isPalindrome("ABCBA"));
    }
    @Test
    void testCase6(){
        assertTrue(validPalindrome.isPalindrome("ABBA"));
    }
    @Test
    void testCaseLeetCode1(){
        assertTrue(validPalindrome.isPalindromeSpaceInclude("A man, a plan, a canal: Panama"));
    }
    @Test
    void testCaseLeetCode2(){
        assertFalse(validPalindrome.isPalindromeSpaceInclude("race a car"));
    }
    @Test
    void testCaseLeetCode3(){
        assertTrue(validPalindrome.isPalindromeSpaceInclude(" "));
    }
    @Test
    void testCaseLeetCode4(){
        assertTrue(validPalindrome.isPalindromeSpaceInclude("1"));
    }
    @Test
    void testCaseLeetCode5(){
        assertFalse(validPalindrome.isPalindromeSpaceInclude("1B"));
    }

    @Test
    void testCaseLeetCode6(){
        assertTrue(validPalindrome.isPalindromeSpaceInclude("Aa"));
    }

    @Test
    void testCaseLeetCode7(){
        assertTrue(validPalindrome.isPalindromeSpaceInclude("  ,"));
    }


}
