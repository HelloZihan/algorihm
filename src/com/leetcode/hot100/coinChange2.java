package com.leetcode.hot100;

/**
 * 518. 零钱兑换 II
 *
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 *
 * 题目数据保证结果符合 32 位带符号整数。
 *
 * 示例 1：
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * 示例 2：
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 *
 * 示例 3：
 * 输入：amount = 10, coins = [10]
 * 输出：1
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhaojun
 */
public class coinChange2 {
    /**
     * dfs超时
     */
    private int result = 0;
    public int change(int amount, int[] coins) {
        dfs(amount, coins, 0);
        return result;
    }
    private void dfs(int amount, int[] coins, int index) {
        if(amount < 0) {
            return;
        }
        if(amount == 0) {
            result++;
            return;
        }
        for(int i=index; i<coins.length; i++) {
            amount -= coins[i];
            dfs(amount, coins, i);
            amount += coins[i];
        }
    }


    /**
     * 动态规划 求组合，跟爬楼梯的不同之处：爬楼梯先两步，再一步与先一步，再两步算不同的，属于排列；这个算相同的，数组组合
     */
    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i=0; i<coins.length; i++) {
            for(int j=coins[i]; j<=amount; j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
