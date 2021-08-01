package com.leetcode.hot100;

/**
 * 303. 区域和检索 - 数组不可变
 *
 * 给定一个整数数组nums，求出数组从索引i到j（i≤j）范围内元素的总和，包含i、j两点。
 *
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引i到j（i≤j）范围内元素的总和，包含i、j两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length+1];
        for(int i=1; i < nums.length+1; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
    }
    public int sumRange(int left, int right) {
        return sum[right+1] - sum[left];
    }
}
