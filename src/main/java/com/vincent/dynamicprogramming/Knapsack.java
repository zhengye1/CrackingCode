package com.vincent.dynamicprogramming;

public class Knapsack {
    public int knapsack(int capacity, int[] values, int[] weights) {
        int[][] dp = new int[weights.length + 1][capacity + 1];
        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                dp[i][j] =
                    (weights[i - 1] <= j) ? Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]) :
                        dp[i - 1][j];
            }
        }
        return dp[weights.length][capacity];
    }

    public int knapsack1D(int capacity, int[] values, int[] weights) {
        int[] dp = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            dp[i] = 0;
        }
        for (int i = 0; i < weights.length; i++){
            for (int j = capacity; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }
        return dp[capacity];
    }
}
