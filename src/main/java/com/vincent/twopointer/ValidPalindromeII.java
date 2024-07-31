package com.vincent.twopointer;

/**
 * LeetCode #680 Easy
 * Write a function that takes a string as input
 * and checks whether it can be a valid palindrome by removing <b>at most one</b> character from it.
 * Constraint:
 * - 1 &lt;= string.length &lt;= 10^3
 * - String only contains letter
 */
public class ValidPalindromeII {
    /**
     * This is O(n) operation, the worst case will be looped the whole string
     * which at most n/2, but if found 1 time that character doesn't work
     * need O((n - 1)/2) for checking left + 1 to the end is palindrome (if yes no need other end)
     * if not then another O((n - 1)/2) which at worst O(n - 1)
     * in total just O(n)
     * @param s - input String
     * @return the string can be removed at most 1 character and still palindrome
     */
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                // compare left or right is palindrome
                return isPalindromeHelper(s, start + 1, end) || isPalindromeHelper(s, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isPalindromeHelper(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
