package com.leetcode.hot100;

import java.util.Arrays;

/**
 * 188. 买卖股票的最佳时机 IV
 *
 * 给定一个整数数组prices，它的第i个元素prices[i]是一支给定的股票在第i天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class MaxProfit4 {

    /**
     * 我们用buy[i][j]表示对于数组prices[0..i]中的价格而言，进行恰好j笔交易，并且当前手上持有一支股票，这种情况下的最大利润；
     * 用sell[i][j]表示恰好进行j笔交易，并且当前手上不持有股票，这种情况下的最大利润。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-iv-by-8xtkp/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        //第一天买，第二天才能卖。如果第二天卖了再买，跟操作一样的利润
        k = Math.min(k, n / 2);
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[0][i] = Integer.MIN_VALUE / 2;
            sell[0][i] = Integer.MIN_VALUE / 2;
        }
        for (int i = 1; i < n; ++i) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            //循环条件一直到k，第k笔交易
            for (int j = 1; j <= k; ++j) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }
        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }
}
