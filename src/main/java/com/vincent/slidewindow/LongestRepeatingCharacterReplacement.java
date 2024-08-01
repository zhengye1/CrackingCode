package com.vincent.slidewindow;

/**
 * LeetCode 424 Medium
 * Given a string <i>s</i> and an integer <i>k</i>,
 * find the length of the longest substring in <i>s</i>,
 * where all characters are identical, after replacing,
 * at most, <i>k</i> characters with any other lowercase English character. <br>
 * Constraint: <br>
 * - 1 &lt;= <i>s.length</i> &lt;= 10^3 <br>
 * - <i>s</i> consists of only lowercase English letters. Leetcode version contains uppercase<br>
 * - 0 &lt;= <i>k</i> &lt;= <i>s.length</i>
 */
public class LongestRepeatingCharacterReplacement {
    // Time Complexity: O(n)
    // Space Complexity: O(1) only using frequencyArray to store 26 letters
    public int longestRepeatingCharacterReplacement(String s, int k){
        int[] frequencyArray = new int[26]; // to store the frequency for the string
        int maxFrequency = 0; // to store the max frequency for the string
        int start = 0, end = 0; // open window, close window
        int maxLen = 0; // maximum substring length
        int sLen = s.length();
        while (end < sLen){
            char currentChar = s.charAt(end);
            frequencyArray[currentChar - 'a']++; //update the current frequency
            maxFrequency = Math.max(maxFrequency, frequencyArray[currentChar - 'a']); //update the max frequency
            while (end - start + 1 - maxFrequency > k) { // if the window is larger than the max frequency + k
                //begin move the start
                char startChar = s.charAt(start);
                frequencyArray[startChar - 'a']--; // decrease it
                start++; // move the start
            }
            maxLen = Math.max(maxLen, end - start + 1); // update the max length
            end++; // expand the window
        }
        return maxLen;
    }
}
