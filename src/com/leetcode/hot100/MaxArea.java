package com.leetcode.hot100;

/**
 * 盛水最多的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * https://www.jianshu.com/p/01a62f56e45f
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhaojun
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int result = 0;
        int i = 0, j = height.length-1;
        while (i < j) {
            result = Math.max(result, (j-i) * Math.min(height[j], height[i]));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}
