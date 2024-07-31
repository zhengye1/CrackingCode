package com.vincent.slidewindow;

/**
 * LeetCode 727 - Hard
 * Given two string <i>str1</i> and <i>str2</i>, find the shortest subtring in <i>str1</i>
 * such that <i>str2</i> is a subsequence of the substring <br>
 * Subsequence means it can delete any character that get the substring of the original string <br>
 * E.g <i>str1</i> = "abbcb", <i>str2</i> = "ac", result is "abbc" <br>
 * Constraint: <br>
 * 1 &lt;= str1.length &lt;= 20000 <br>
 * 1 &lt;= str2.length &lt;= 100
 * Leetcode version contains only lower case
 */
public class MinimumWindowSequence {
    public String minWindow(String str1, String str2) {
        int s1Len = str1.length();
        int s2Len = str2.length();
        int minLen = 20000; // pre-set on the constraint, since s1 at most have 20000 characters
        // Initialize pointers to zero and the minSubsequence to an empty string
        int indexS1 = 0;
        int indexS2 = 0;
        int start = 0, end = 0;
        String minSubsequence = "";
        while (indexS1 < s1Len) {
            if (str1.charAt(indexS1) == str2.charAt(indexS2)) {
                indexS2++;
                if (indexS2 == s2Len) {
                    start = indexS1;
                    end = indexS1;
                    indexS2--; // reset the indexS2 to the last matched character
                    while (indexS2 >= 0) {
                        if (str1.charAt(start) == str2.charAt(indexS2)) {
                            indexS2--;
                        }
                        start--; // move the start pointer to the left to find the minimum length
                    }
                    start++;

                    if (end - start + 1 < minLen) {
                        //update the length
                        minLen = end - start + 1;
                        minSubsequence = str1.substring(start, end + 1);
                    }
                    indexS1 = start;
                    indexS2 = 0;
                }

            }
            indexS1++;
        }
        return minSubsequence;
    }
}
