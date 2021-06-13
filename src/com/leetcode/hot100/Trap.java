package com.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42. 接雨水
 *
 * 给定n个非负整数表示每个宽度为1的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class Trap {

    /**
     * height数组中的0可以看做是高度为0的墙  dp 时间O(n) 空间O(n)
     *
     * https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
     * 解法三: 动态规划
     * @param height
     * @return
     */
    public int trap(int[] height) {
        //当前墙向左边看  左边最高的墙
        int[] left = new int[height.length];
        //当前墙向右边看  右边最高的墙
        int[] right = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i-1], height[i-1]);
        }
        for (int i = height.length-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], height[i+1]);
        }
        int result = 0;
        for (int i = 0; i < height.length-1; i++) {
            int tmp = (Math.min(left[i], right[i]) - height[i]);
            result = tmp > 0 ? result + tmp : result;
        }
        return result;
    }

    /**
     * 去掉方案一中的left数组 时间O(n) 空间O(n)
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int sum = 0;
        int left = 0;
        int[] max_right = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            left = Math.max(left, height[i - 1]);
            int min = Math.min(left, max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 双指针 再去掉right数组 时间O(n) 空间O(1)
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        /*
            使用双指针（左右两边各两个指针）

            我们使用一根一根柱子计算装水量的方法

            left 表示左边当前遍历的柱子（即左边我们需要计算能够装多少水的柱子）
            left_max 表示 left 的左边最高的柱子的索引（不包括 left）
            right 表示右边当前遍历的柱子
            right_max 表示 right 的右边最高的柱子索引（不包括 right）

            我们有以下几个公式：
            当 left_max < right_max 的话，那么我们就判断 left_max 是否比 left 高
                因为根据木桶效应，一个桶装水量取决于最短的那个木板，这里也一样，柱子能否装水取决于左右两边的是否都存在比它高的柱子
                因为 left_max < right_max 了，那么我们只需要比较 left_max 即可
                    如果 left_max > left，那么装水量就是 left_max - left
                    如果 left_max <= left，那么装水量为 0，即 left 装不了水
            当 left_max >= right_max 的话，同理如上，比较 right_max 和 right

            ？？？？ 为什么 right_max 和 left 隔这么远我们还可以使用 right_max 来判断？
            前提：left_max < right_max
            right_max 虽然跟 left 离得远，但有如下两种情况：
            1、left 柱子和 right_max 柱子之间，没有比 right_max 柱子更高的柱子了，
            那么情况如下：  left 能否装水取决于 left_max 柱子是否比 left 高
                            |
                |           |
                |   |       |
                ↑   ↑       ↑
               l_m  l      r_m

            2、left 柱子和 right_max 柱子之间存在比 right_max 柱子更高的柱子
            那么情况如下：因为存在了比 right_max 更高的柱子，那么我们仍然只需要判断 left_max 是否比 left 高，因为右边已经存在比 left 高的柱子
                        |
                        |   |
                |       |   |
                |   |   |   |
                ↑   ↑   ↑   ↑
               l_m  l  mid  r_m

            初始化指针：
            left = 1;
            right = len - 2;
            left_max = 0;
            right_max = len - 1;
            （因为第一个柱子和最后一个柱子肯定不能装水，因为不作为装水柱子，而是作为左边最高柱子和右边最高柱子）
        */

        int len = height.length;
        int left = 1;
        int right = len - 2;
        int left_max = 0;
        int right_max = len - 1;

        int res = 0;

        while(left <= right){
            //比较 始终选height小的那一边，同时计算每一列柱子存的水。左边最大高度和右边最大高度的最小值 大于 当前柱子则有水
            if(height[left_max] < height[right_max]){
                if(height[left_max] > height[left]){
                    res += height[left_max] - height[left];
                }else{
                    left_max = left;
                }
                left++;
            }else{
                if(height[right_max] > height[right]){
                    res += height[right_max] - height[right];
                }else{
                    right_max = right;
                }
                right--;
            }
        }
        return res;
    }

    /**
     * 单调栈 时间O(n) 空间O(n)
     *
     * 第二层while循环里，每个元素最多入栈一次，出栈一次，故复杂度最大O(2n)，不是O(n^2)
     *
     * 高度比原来栈顶小则入栈，高度比栈顶大则计算该墙高度之前的水容量
     * @param height
     * @return
     */
    public int trap4(int[] height) {
        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                //取出要出栈的元素
                int h = height[stack.pop()];
                //栈空就出去
                if (stack.isEmpty()) {
                    break;
                }
                //两堵墙之前的距离。
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            //当前指向的墙入栈
            stack.push(current);
            //指针后移
            current++;
        }
        return sum;
    }
}
