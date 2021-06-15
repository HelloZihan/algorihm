package com.leetcode.hot100;

/**
 * 494. 目标和
 *
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class FindTargetSumWays {
    int count = 0;
    //回溯
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    public void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }

    /**
     * 转化成0/1背包恰好装满的问题
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
    public int findTargetSumWays2(int[] nums, int target) {
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
