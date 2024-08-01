package com.vincent.slidewindow;

/**
 * LeetCode 3 Medium <br>
 * Given a string, <i>str</i>, return the length of the longest substring without repeating characters. <br>
 * Constraint: <br>
 * - 1 &lt;= str.length &lt;= 5 * 10^4 <br>
 * - <i>str</i> consists of English letters, digits, symbols and spaces.
 */
public class FindLongestSubstring {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int lengthOfLongestSubstring(String str) {
        int[] charIndex = new int[128]; // use to store the last seen for the character
        for(int i = 0; i < 128; i++) {
            charIndex[i] = -1;
        }
        int start = 0;
        int maxLength = 0;
        int sLen = str.length();
        for (int end = 0; end < sLen; end++) {
            start = Math.max(start, charIndex[str.charAt(end)] + 1); // move the start to the right of the last seen character
            maxLength = Math.max(maxLength, end - start + 1); // update the max length
            charIndex[str.charAt(end)] = end; // update the last seen character
        }
        return maxLength;
    }

}
