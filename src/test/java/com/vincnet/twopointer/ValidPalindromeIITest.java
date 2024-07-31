package com.vincnet.twopointer;

import com.vincent.twopointer.ValidPalindromeII;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidPalindromeIITest {
    String[] testString = new String[]{
            "aba",
            "abca",
            "abc",
            "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"
    };
    ValidPalindromeII validPalindromeII =  new ValidPalindromeII();

    @Test
    void testCase1(){
        assertTrue(validPalindromeII.isPalindrome(testString[0]));
    }

    @Test
    void testCase2(){
        assertTrue(validPalindromeII.isPalindrome(testString[1]));
    }

    @Test
    void testCase3(){
        assertFalse(validPalindromeII.isPalindrome(testString[2]));
    }

    @Test
    void testCase4(){
        assertTrue(validPalindromeII.isPalindrome(testString[3]));
    }
}
