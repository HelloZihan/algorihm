package com.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * 说明 :
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * @author zhaojun
 */
public class SubarraySum {
    /**
     * 1、暴力枚举，双重循环
     * 2、前缀和
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(16);
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //连续子数组的和等于当前sum减去历史的某个sum
            if (map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(new SubarraySum().subarraySum(a, 3));
    }
}
