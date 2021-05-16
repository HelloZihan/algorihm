package com.jianzhi.offer.dynamic.planning;

import java.util.Arrays;

/**
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度为 O(n).
 *
 * 输入：[1,-2,3,10,-4,7,2,-5]
 * 输出：18
 *
 * 输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和 18。
 *
 * 动态规划，找出dp数组
 *
 * 步骤1:定义dp数组的含义
 * 步骤2:思考dp[0],dp[1]等如何退到dp[2],dp[3]，由开始往后推导
 * 步骤3:初始化dp[0],dp[1]
 * @author zhaojun
 */
public class GreatestSum {
    public static int FindGreatestSumOfSubArray(int[] array) {
        //dp是什么呢，dp是以int[i]结尾的所有子数组最大值
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int result = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i-1] + array[i], array[i]);
            result = Math.max(result, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-2,-8,-1,-5,-9};
        FindGreatestSumOfSubArray(a);
    }
}
