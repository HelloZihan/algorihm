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

    /**
     * 转化成0/1背包恰好装满的问题
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum&1) == 1) {
            return false;
        }
        sum = sum/2;
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        dp[0][0] = true;
        for (int i = 1; i < nums.length+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if (nums[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][sum];
    }

    public boolean canPartition1(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum&1) == 1) {
            return false;
        }
        sum = sum/2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int i = 1; i < nums.length+1; i++) {
            for (int j = sum; j >= nums[i-1]; j--) {
                //https://blog.csdn.net/nicolelili1/article/details/89062044 为什么要或上dp[j]，看完这个就理解了，因为dp[j]是i的上一次循环算出来的值存在这里
                //dp[j-nums[i]] || dp[j]中，dp[j-nums[i]]代表选该物品，dp[j]代表不选该物品
                dp[j] = dp[j-nums[i-1]] || dp[j];
            }
        }
        return dp[sum];
    }

}
