package com.leetcode.hot100;

/**
 * 53. 最大子序和
 *
 * 给定一个整数数组nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * @author zhaojun
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        //dp[n]代表以nums[n]为结尾的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];
        for(int i=1; i<nums.length; i++) {
            dp[i] = Math.max((dp[i-1] + nums[i]), nums[i]);
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
