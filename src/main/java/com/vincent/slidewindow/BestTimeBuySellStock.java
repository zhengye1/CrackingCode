package com.vincent.slidewindow;

/**
 * LeetCode 121 Easy
 * Given an array where the element at the index <i>i</i> represents the price of a stock on day <i>i</i>,
 * find the maximum profit that you can gain by buying the stock once and then selling it.
 * Need O(n) for time and O(1) for space
 */
public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int buyWindow = 0, sellWindow = 0;
        int priceLen = prices.length;
        int maxProfit = 0;
        int profit;
        while (sellWindow < priceLen) {
            profit = prices[sellWindow] - prices[buyWindow];
            if (profit >= maxProfit) {
                maxProfit = profit;
            }

            while (profit < 0) {
                buyWindow++;
                profit = prices[sellWindow] - prices[buyWindow];
                if (profit >= maxProfit) {
                    maxProfit = profit;
                }
            }
            sellWindow++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        new BestTimeBuySellStock().maxProfit(new int[] {2, 1, 4});
    }
}
