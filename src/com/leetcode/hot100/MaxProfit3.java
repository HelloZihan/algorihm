package com.leetcode.hot100;

import java.util.Arrays;

/**
 * 123. 买卖股票的最佳时机 III
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class MaxProfit3 {

    /**
     * 根据MaxProfit4中可以完成k笔交易来实现
     *
     * 我们用buy[i][j]表示对于数组prices[0..i]中的价格而言，进行恰好j笔交易，并且当前手上持有一支股票，这种情况下的最大利润；
     * 用sell[i][j]表示恰好进行j笔交易，并且当前手上不持有股票，这种情况下的最大利润。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        //第一天买，第二天才能卖。如果第二天卖了再买，跟操作一样的利润
        int[][] buy = new int[n][3];
        int[][] sell = new int[n][3];
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= 2; ++i) {
            //边界不合法值
            buy[0][i] = Integer.MIN_VALUE / 2;
            sell[0][i] = Integer.MIN_VALUE / 2;
        }
        for (int i = 1; i < n; ++i) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            //循环条件一直到k，第k笔交易
            for (int j = 1; j <= 2; ++j) {
                //买了则代表进行了第k笔交易，而不是卖完才算交易
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }
        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-iii-by-wrnt/
     *
     * 由于我们最多可以完成两笔交易，因此在任意一天结束之后，我们会处于以下五个状态中的一种：
     * 未进行过任何操作；
     * 只进行过一次买操作；
     * 进行了一次买操作和一次卖操作，即完成了一笔交易；
     * 在完成了一笔交易的前提下，进行了第二次买操作；
     * 完成了全部两笔交易。
     * 由于第一个状态的利润显然为0，因此我们可以不用将其记录。对于剩下的四个状态，我们分别将它们的最大利润记为buy1,sell1,buy2,sell2
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-iii-by-wrnt/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
