package com.leetcode.hot100;


/**
 * 416. 分割等和子集
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class CanPartition {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum + target) < 0 || ((sum + target) &1) == 1) {
            return 0;
        }
        //这是目标和
        target = (sum + target)/2;
        int[][] dp = new int[nums.length+1][target+1];
        dp[0][0] = 1;
        for (int i = 1; i < nums.length+1; i++) {
            for (int j = 0; j < target+1; j++) {
                if (nums[i-1] > j) {
                    //二维数组时，每个格子都要计算，不能省略
                    dp[i][j] = dp[i-1][j];
                } else {
                    //取的话有这么多写法，不取的话有这么多写法。一共有相加的种数
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }
            }
        }
        return dp[nums.length][target];
    }
    /**
     * 优化成一维
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays1(int[] nums, int target) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum + target) < 0 || ((sum + target) &1) == 1) {
            return 0;
        }
        //这是目标和
        target = (sum + target)/2;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i < nums.length+1; i++) {
            for (int j = target; j >= nums[i-1]; j--) {
                //取的话有这么多写法，不取的话有这么多写法。一共有相加的种数
                dp[j] = dp[j-nums[i-1]] + dp[j];
            }
        }
        return dp[target];
    }
}
