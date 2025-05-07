package com.codefans.interview.algorithm.leetcode.arrays;

/**
 * No 123 买股票的最佳时机
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 题目描述：
 *    You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 * 解题思路：
 *    这个思路很简单，灵感来源于《只出现一次的数字 II》（Single Number II）的最优解法（我在用动态规划解完这道题后看了讨论区才想到）。
 *
 * 假设我们最初有 0 元资金；
 * 用 4 个变量 来维护当前可能的几个关键“上限”值：
 * 刚完成第一次买入股票后的最大资金（即持有第一支股票时的最小成本）；
 * 刚完成第一次卖出股票后的最大资金（即第一次交易完成后的最大利润）；
 * 刚完成第二次买入股票后的最大资金（即持有第二支股票时的最小成本，需扣除第一次交易的利润）；
 * 刚完成第二次卖出股票后的最大资金（即最终的最大总利润）。
 * 代码非常简洁，而且效果很好。不得不说，这个逻辑比《只出现一次的数字 II》的解法更直观！
 *
 * 补充说明
 * 这段话描述的是 最多完成两笔交易的最大利润问题 的优化解法（动态规划空间压缩版）。
 * 核心思想是通过四个状态变量跟踪不同阶段的资金情况，避免使用二维 DP 数组。
 * 类似思路也可用于解决 K 次交易的最大利润问题（只需扩展状态变量数量）。
 *
 * @Author: codefans
 * @Date: 2025-05-06 15:09
 */

public class No123BestTimeToBuyAndSellStockIII {

    /**
     * 入参示例：
     * Example 1:
     * Input: prices = [3,3,5,0,0,3,1,4]
     * Output: 6
     * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
     * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
     *
     * Example 2:
     * Input: prices = [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
     *
     * Example 3:
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     * 算法思路：
     * 变量含义
     * hold1：第一次买入股票后的最大资金（即持有第一支股票时的最小成本）。
     * 初始值为 Integer.MIN_VALUE，表示初始时无法买入（因为没钱）。
     * 更新逻辑：hold1 = max(hold1, -i) → 要么保持之前的状态，要么以当前价格买入（资金变为 -i）。
     * release1：第一次卖出股票后的最大资金（即完成第一次交易后的利润）。
     * 更新逻辑：release1 = max(release1, hold1 + i) → 要么保持之前的利润，要么卖出当前持有的股票（利润为 hold1 + i）。
     * hold2：第二次买入股票后的最大资金（即持有第二支股票时的净成本）。
     * 更新逻辑：hold2 = max(hold2, release1 - i) → 要么保持之前的状态，要么用第一次交易的利润买入第二支股票（净成本为 release1 - i）。
     * release2：第二次卖出股票后的最大资金（即最终的最大总利润）。
     * 更新逻辑：release2 = max(release2, hold2 + i) → 要么保持之前的利润，要么卖出第二支股票（利润为 hold2 + i）。
     *
     * 状态转移逻辑
     * 第一次交易：
     * 买入：hold1 = max(hold1, -i)
     * （初始时 hold1 是负无穷，第一次买入后变为 -i；之后保持或更新为更小的买入成本）。
     * 卖出：release1 = max(release1, hold1 + i)
     * （卖出后利润为 hold1 + i，取之前利润和当前利润的最大值）。
     * 第二次交易：
     * 买入：hold2 = max(hold2, release1 - i)
     * （用第一次交易的利润 release1 减去当前价格 i，得到第二次买入后的净成本）。
     * 卖出：release2 = max(release2, hold2 + i)
     * （卖出后总利润为 hold2 + i，取之前利润和当前利润的最大值）。
     *
     * 为什么这样可行？
     * 贪心扩展：将两次交易拆解为两个独立的一次交易问题，通过动态维护状态变量，逐步累积最大利润。
     * 状态压缩：用四个变量代替二维DP数组，空间复杂度从 O(n) 降为 O(1)。
     * 时间复杂度：O(n)，只需遍历一次价格数组。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE; // 持有股票的状态
        int release1 = 0, release2 = 0; // 已卖出股票的状态
        for(int i:prices){// Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);   // 第二次卖出后的最大利润
            hold2    = Math.max(hold2,    release1-i);// 第二次买入后的最大利润
            release1 = Math.max(release1, hold1+i);   // 第一次卖出后的最大利润
            hold1    = Math.max(hold1,    -i);        // 第一次买入后的最大利润, 花了i元买股票, 所以利润为-i
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }

    public static void main(String[] args) {
        No123BestTimeToBuyAndSellStockIII no123 = new No123BestTimeToBuyAndSellStockIII();
        int[] prices = new int[] {3,3,5,0,0,3,1,4};
        System.out.println(no123.maxProfit(prices));
        prices = new int[] {1,2,3,4,5};
        System.out.println(no123.maxProfit(prices));
        prices = new int[] {7,6,4,3,1};
        System.out.println(no123.maxProfit(prices));
    }

}
