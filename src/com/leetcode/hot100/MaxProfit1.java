package com.leetcode.hot100;

/**
 * 121. 买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第i个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 股票系列通解：
 * https://leetcode-cn.com/circle/article/qiAgHn/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class MaxProfit1 {
    /**
     * 时间O(n), 空间O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int result = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            result = Math.max(prices[i]-min, result);
            min = Math.min(min, prices[i]);
        }
        return result;
    }

    /**
     * 时间O(n), 空间O(n)
     * dp[i] 表示前i天的最大利润，因为我们始终要使利润最大化，则：
     *  dp[i]=max(dp[i−1],prices[i]−minprice)
     * @param prices
     * @return
     */
    public int maxProfitDp(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0]=0;
        //minprice代表历史最低价格，
        int minprice=prices[0];
        // 所以i从1开始历史最低价格肯定是prices[0]
        for (int i = 1; i < prices.length; i++) {
            dp[i]=Math.max(dp[i-1],prices[i]-minprice);
            minprice=Math.min(minprice,prices[i]);

        }
        return dp[prices.length-1];
    }
}
