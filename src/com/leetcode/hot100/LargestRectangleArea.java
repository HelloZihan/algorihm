package com.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * @author zhaojun
 */
public class LargestRectangleArea {

    /**
     * 1、单调栈
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode-/
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        //left记住左边界
        int[] left = new int[heights.length];
        //right记住右边界
        int[] right = new int[heights.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!deque.isEmpty() && heights[deque.peek()]>=heights[i]) {
                deque.pop();
            }
            left[i] = deque.isEmpty() ? -1 : deque.peek();
            deque.push(i);
        }
        deque.clear();
        for (int i = heights.length-1; i >=0; i--) {
            while (!deque.isEmpty() && heights[deque.peek()]>=heights[i]) {
                deque.pop();
            }
            right[i] = deque.isEmpty() ? heights.length : deque.peek();
            deque.push(i);
        }
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (right[i] - left[i] - 1);
            result = Math.max(result, area);
        }
        return result;
    }


    /**
     * 进栈代表left，出栈代表right。用一个循环，还是上面的方法直观一些
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Deque<Integer> mono_stack = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                right[mono_stack.peek()] = i;
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
