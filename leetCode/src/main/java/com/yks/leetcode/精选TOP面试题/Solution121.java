package com.yks.leetcode.精选TOP面试题;

import static java.lang.Math.max;
import static java.util.Collections.min;

/**
 * @Description: 121. 买卖股票的最佳时机
 * @Author: Yu ki-r
 * @CreateDate: 2020/12/2 21:14
 */
public class Solution121 {
    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     *
     * 注意：你不能在买入股票前卖出股票。
     * 示例：
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     *
     */
    /**
     * [7,1,5,3,6,4]
     * i=0
     * i=1 1<5 minBuy = 1 maxProfit = 4
     * i=2
     * i=3 minBuy = 3 maxProfit=
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;//记录最大利润
        int minBuy = Integer.MAX_VALUE;//记录最小的买入



        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minBuy) {
                minBuy = prices[i]; //获取最小的买入
            } else if (prices[i] - minBuy > maxProfit) {
                maxProfit = prices[i] - minBuy;

            }
        }
        return maxProfit;


    }
}
