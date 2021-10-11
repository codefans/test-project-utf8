package com.codefans.interview.algorithm.leetcode.arrays;


/**
 *
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * 给定一个数组 prices ，它的第i个元素prices[i] 表示一支给定股票第i天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @author: codefans
 * @Date: 2021/10/11 20:30
 * @since: 1.0.0
 */
public class No121BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int len = prices.length;
        for(int i = 0; i < len; i ++) {
            for(int j = len - 1; j >= i + 1; j --) {
                if(prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }

}