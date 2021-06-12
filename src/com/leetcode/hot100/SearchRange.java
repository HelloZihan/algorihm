package com.leetcode.hot100;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhaojun
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int start = -1, end = -1;
        while (left <= right) {
            int middle = left + (right - left)/2;
            if (nums[middle] == target) {
                start = middle;
                right = middle - 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (start == -1) {
            return new int[]{-1, -1};
        }
        left = 0;
        right = nums.length -1;
        while (left <= right) {
            int middle = left + (right - left)/2;
            if (nums[middle] == target) {
                end = middle;
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return new int[] {start, end};
    }
}
