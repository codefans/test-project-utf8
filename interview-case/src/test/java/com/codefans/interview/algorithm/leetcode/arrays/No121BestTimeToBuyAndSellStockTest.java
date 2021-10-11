package com.codefans.interview.algorithm.leetcode.arrays;


import com.codefans.reusablecode.util.FileUtils;
import org.junit.Test;

/**
 *
 * 买卖股票的最佳时机测试类
 *
 * @author: codefans
 * @Date: 2021/10/11 20:32
 * @since: 1.0.0
 */
public class No121BestTimeToBuyAndSellStockTest {

    /**
     * 示例 1：
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     *
     * 示例 2：
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     */
    @Test
    public void maxProfitTest() {

        No121BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new No121BestTimeToBuyAndSellStock();
        int[] prices = new int[]{7,1,5,3,6,4};
        int maxProfit = bestTimeToBuyAndSellStock.maxProfit2(prices);
        System.out.println("maxProfit=" + maxProfit);

        prices = new int[]{7,6,4,3,1};
        maxProfit = bestTimeToBuyAndSellStock.maxProfit2(prices);
        System.out.println("maxProfit=" + maxProfit);

        String str = FileUtils.fileToStr(No121BestTimeToBuyAndSellStock.class.getResourceAsStream("bestTimeToBuyOrSellStock.txt"));
        String[] arr = str.split(",");
        System.out.println("arr.length=" + arr.length);

        int[] nums = new int[arr.length];
        for(int i = 0; i < arr.length; i ++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        maxProfit = bestTimeToBuyAndSellStock.maxProfit(nums);
        System.out.println("maxProfit=" + maxProfit);

    }
}