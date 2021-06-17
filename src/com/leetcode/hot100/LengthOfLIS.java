package com.leetcode.hot100;

import java.util.Arrays;

/**
 *
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 *
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class LengthOfLIS {

    /**
     * dp[i]代表以nums[i]为结尾的递增子序列最大值
     * 向前遍历i,找到dp[i]的最大值
     * dp[0]代表以nums[0]为结尾的递增子序列，必然是1
     *
     * 很巧妙，理解之后，真是彻底利用了dp的思想，不断利用dp[j]的最大子序列，如果nums[i] > nums[j]，则子序列长度加1
     *
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-er-fen-cha-zhao-tan-xin-suan-fa-p/
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        //dp[i]代表以nums[i]为结尾的递增子序列最大值
        //注意，并不是dp[nums.length-1]是最大值，dp[i]只是代表以nums[i]为结尾的最大值
        int[] dp = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            //dp[i]只是代表以nums[i]为结尾的最大值,故初始化均为1
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                result = Math.max(result, dp[i]);
            }
        }
        //[1, 0, 0, 1, 1, 2, 3, 3]
        System.out.println(Arrays.toString(dp));
        return result;
    }

    public static void main(String[] args) {
        int[] a = {10,9,2,5,3,7,101,18};
        System.out.println(new LengthOfLIS().lengthOfLIS(a));
    }
}
