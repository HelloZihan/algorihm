package com.leetcode.hot100;

/**
 * 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * @author zhaojun
 */
public class CountBits {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++) {
            if((i & 1) == 1) {
                //奇数的1的个数就是前面一个偶数1的个数+1；
                dp[i] = dp[i-1] + 1;
            } else {
                //偶数1的个数，偶数一直左移，变成奇数
                int k = i>>1;
                while((k&1) == 0) {
                    k = k>>1;
                }
                dp[i] = dp[k];
            }
        }
        return dp;
    }
}
