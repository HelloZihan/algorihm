package com.leetcode.hot100;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 581. 最短无序连续子数组
 *
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的最短子数组，并输出它的长度。
 *
 * 示例 1：
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class FindUnsortedSubarray {

    /**
     * 排序，比较位置不一样的数组索引，即为结果
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }

    /**
     * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
     * 时间O(n) 空间O(1)
     * @param nums
     * @return
     */
    public int findUnsortedSubarray1(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        int start=nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peek()] > nums[i]) {
                start = Math.min(deque.pop(), start);
            }
            deque.push(i);
        }
        if (start == nums.length) {
            return 0;
        }
        deque.clear();
        int end = -1;
        for (int i = nums.length-1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[deque.peek()] < nums[i]) {
                end = Math.max(deque.pop(), end);
            }
            deque.push(i);
        }
        return end - start + 1;
    }

    /**
     * 去掉栈 时间O(n) 空间O(1)
     * @param nums
     * @return
     */
    public int findUnsortedSubarray2(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

}
