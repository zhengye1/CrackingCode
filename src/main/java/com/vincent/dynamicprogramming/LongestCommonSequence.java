package com.vincent.dynamicprogramming;

/**
 * LeetCode 1143 - Medium
 */
public class LongestCommonSequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1Array = text1.toCharArray();
        char[] text2Array = text2.toCharArray();

        int m = text1Array.length;
        int n = text2Array.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (text1Array[i - 1] == text2Array[j - 1]) ? (dp[i - 1][j - 1] + 1) :
                    Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}
