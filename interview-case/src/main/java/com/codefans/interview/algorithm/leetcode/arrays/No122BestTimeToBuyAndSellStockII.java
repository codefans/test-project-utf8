package com.codefans.interview.algorithm.leetcode.arrays;

/**
 * No 122 买股票的最佳时机
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 题目描述：
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 * 解题思路：
 *     只要判断每一天比前一天价格高，就把收益相加。
 * 关键逻辑
 * 遍历价格数组：从第2天（索引1）开始比较相邻两天的价格。
 * 捕捉正收益：如果当天价格比前一天高（prices[i] > prices[i-1]），则将差值（即利润）累加到 maxProfit 中。
 * 忽略负收益：如果价格下降，则跳过（不操作）。
 *
 * 为什么这样可行？
 * 贪心策略：
 * 每次在价格上升时买入前一天并卖出当天，相当于在连续上升区间内“分批”买卖。
 * 例如：[1, 2, 3, 4]
 * 第1天买，第2天卖 → 利润1
 * 第2天买，第3天卖 → 利润1
 * 第3天买，第4天卖 → 利润1
 * 总利润 = 1 + 1 + 1 = 3（与直接第1天买第4天卖结果相同）。
 * 数学等价性：
 * 多次买卖的累加利润等于最高点和最低点的单次买卖利润（但实际操作中可能无法预知全局高低点）。
 *
 * @Author: codefans
 * @Date: 2025-05-06 10:27
 */

public class No122BestTimeToBuyAndSellStockII {

    /**
     * 入参示例：
     * Example 1:
     * Input: prices = [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     * Total profit is 4 + 3 = 7.
     *
     * Example 2:
     * Input: prices = [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Total profit is 4.
     *
     * Example 3:
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i ++) {
            if(prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        No122BestTimeToBuyAndSellStockII no122 = new No122BestTimeToBuyAndSellStockII();
        int[] prices = new int[] {7,1,5,3,6,4};
        System.out.println(no122.maxProfit(prices));
        prices = new int[] {1,2,3,4,5};
        System.out.println(no122.maxProfit(prices));
        prices = new int[] {7,6,4,3,1};
        System.out.println(no122.maxProfit(prices));
    }

}
