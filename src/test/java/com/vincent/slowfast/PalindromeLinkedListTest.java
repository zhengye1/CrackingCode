package com.vincent.slowfast;

import com.vincent.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeLinkedListTest {
    PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
    int[][] input={
        {2, 4, 6, 4, 2},
        {0, 3, 5, 5, 0},
        {9, 27, 4, 4, 27, 9},
        {5, 4, 7, 9, 4, 5},
        {5, 10, 15, 20, 15, 10, 5}
    };
    LinkedList<Integer> linkedList;

    @BeforeEach
    void setup(){
        linkedList = new LinkedList<>();
    }

    @Test
    void testCase1(){
        int testCase = 0;
        linkedList.createLinkedList(input[testCase]);
        assertTrue(palindromeLinkedList.isPalindrome(linkedList.head));
    }

    @Test
    void testCase2(){
        int testCase = 1;
        linkedList.createLinkedList(input[testCase]);
        assertFalse(palindromeLinkedList.isPalindrome(linkedList.head));
    }

    @Test
    void testCase3(){
        int testCase = 2;
        linkedList.createLinkedList(input[testCase]);
        assertTrue(palindromeLinkedList.isPalindrome(linkedList.head));
    }

    @Test
    void testCase4(){
        int testCase = 3;
        linkedList.createLinkedList(input[testCase]);
        assertFalse(palindromeLinkedList.isPalindrome(linkedList.head));
    }
    @Test
    void testCase5(){
        int testCase = 4;
        linkedList.createLinkedList(input[testCase]);
        assertTrue(palindromeLinkedList.isPalindrome(linkedList.head));
    }

}
