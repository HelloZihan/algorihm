package com.jianzhi.offer.math;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），每段绳子的长度记为k[1],...,k[m]。
 * 请问k[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 剪下i米，则最大成绩为i * (max(n-i, f(n-i)))，如果i从1到n/2，取最大值。
 * https://www.bilibili.com/video/BV1Q5411L7Uz?from=search&seid=6148910355646376562
 *
 * https://www.bilibili.com/video/BV19a411A7ku?from=search&seid=6148910355646376562
 *
 * @author zhaojun
 */
public class CutRope {

    public int cutRope(int target) {
        if (target == 2) {
            return 1;
        }
        int[] dp = new int[target+1];
        dp[2] = 1;
        //i一直增大，dp[i]由dp[i-1]推出，才能在dp这个数组中把值填满
        for (int i = 3; i < target+1; i++) {
            for (int j = 1; j < i/2+1; j++) {
                //j的遍历，找出j从1一直到最大，哪个算出来的dp最大
                dp[i] = Math.max(dp[i], j * Math.max(i-j,dp[i-j]));
            }
        }
        return dp[target];
    }
}
