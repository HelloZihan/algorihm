package com.leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 * @author zhaojun
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        int result = 0;
        for (int i : hashSet) {
            if (hashSet.contains(i-1)) {
                continue;
            }
            int end = i+1;
            while (hashSet.contains(end)) {
                end++;
            }
            result = Math.max(result, end - i);
        }
        return result;
    }
}
