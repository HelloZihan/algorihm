package com.leetcode.hot100;

/**
 * 152. 乘积最大子数组
 *
 * 给你一个整数数组nums，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释:子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int[] maxF = new int[nums.length];
        int[] minF = new int[nums.length];
        maxF[0] = nums[0];
        minF[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxF[i] = Math.max(maxF[i-1]* nums[i], Math.max(minF[i-1] * nums[i], nums[i]));
            minF[i] = Math.min(maxF[i-1]* nums[i], Math.min(minF[i-1] * nums[i], nums[i]));
            result = Math.max(result, maxF[i]);
        }
        return result;
    }
}
