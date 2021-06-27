package com.leetcode.hot100;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * 给定一个数组prices ，其中prices[i]是一支给定股票第i天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *示例 1:
 *
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: prices = [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class MaxProfit2 {

    /**
     * dp[i][j]
     *
     * 定义状态dp[i][0]表示第i天交易完后手里没有股票的最大利润，dp[i][1] 表示第i天交易完后手里持有一支股票的最大利润(i从0开始)。
     * dp[i][0],要么前一天手里也没有股票，要么前一天手里有股票，今天卖掉了
     * dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]}
     *
     * dp[i][1],要么前一天手里有股票，要么前一天手里没有股票，今天花钱买了
     * dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}
     *
     * dp[0][0]=0，dp[0][1]=−prices[0]
     *
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode-s/
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }

    /**
     * 上述dp中，dp[i][] 至于dp[i-1][]有关，直接拿两个变量存储i-1. 优化空间复杂度为O(1)
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }

    /**
     * 贪心，可以反复买卖，只要存在利润就买卖
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                result = result + prices[i] - prices[i-1];
            }
        }
        return result;
    }
}
