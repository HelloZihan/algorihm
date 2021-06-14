package com.leetcode.hot100;

/**
 * 279. 完全平方数
 *
 * 给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class NumSquares {

    /**
     * dp[n] 表示完全
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 1; i < n+1; i++) {
            dp[i] = i;
            for (int j = 1; j*j <= i; j++) {
                //j*j=i时，i自身是平方数，dp[0] + 1 = 1;
                dp[i] = Math.min(dp[i-j*j]+1, dp[i]);
            }
        }
        return dp[n];
    }
}
