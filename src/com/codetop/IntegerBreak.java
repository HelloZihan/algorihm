package com.codetop;

/**
 * 343. 整数拆分
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * @author zhaojun
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2; i<n+1; i++) {
            for(int j=1; j<i; j++) {
                int max = j * Math.max(i-j, dp[i-j]);
                dp[i] = Math.max(dp[i], max);
            }
        }
        return dp[n];
    }

}
