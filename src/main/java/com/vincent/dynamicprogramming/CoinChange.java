package com.vincent.dynamicprogramming;

import java.util.Arrays;

/**
 * LeetCode 322 - Medium
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];
        // 初始化 dp 数组
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0; // 凑成金额 0 所需的硬币数是 0
        }
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = amount + 1; // no coin to make
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
            }
            // 如果最终的值仍然是大值，说明无法凑成该金额

        }
        return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];
    }

    public int coinChange1D(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    

}
