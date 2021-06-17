package com.leetcode.hot100;

/**
 *
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组nums中。
 *
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。这里的 i - 1 和 i + 1 代表和i相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * 示例 1：
 * 输入：nums = [3,1,5,8]
 * 输出：167
 * 解释：
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * 示例 2：
 *
 * 输入：nums = [1,5]
 * 输出：10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class MaxCoins {

    /**
     * dp[i][j]代表(i,j)之间的气球戳破拿到的最大分数
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length+2];
        newNums[0] = newNums[nums.length+1] = 1;
        for (int i = 1; i < nums.length+1; i++) {
            newNums[i] = nums[i-1];
        }
        //dp[i][j]代表(i,j)开区间之间的分数，dp[0][n]即为所求. dp[i][j] = max(newNums[i] * newNums[k] * newNums[j] + dp[i][k] + dp[k][j]). 其中k为最后戳破的气球
        //只要最后戳破气球k，那么何时戳破k左边的气球与k无关，且与k右边也无关，这样独立性就出来了dp[i][j] = newNums[i] * newNums[k] * newNums[j] + dp[i][k] + dp[k][j]
        int dp[][] = new int[newNums.length][newNums.length];
        //根据dp推算，要算出dp[i][j]，必须先知道dp[i][k] 和dp[k][j], 且i<k<j,最终需要求出dp[0][n-1]; 可以行从左到右，列从下到上
        for (int j = 1; j < newNums.length; j++) {
            for (int i = j-1; i>=0; i--) {
                for (int k = i+1; k < j; k++) {
                    //想象一下求dp[0][n-1]时，当k为1，dp[0][n-1] = dp[0][1] + dp[1][n-1] + newNums[0] * newNums[1] * newNums[n-1], dp[0][1]为0最合适，与初始值相同
                    dp[i][j] = Math.max(newNums[i] * newNums[k] * newNums[j] + dp[i][k] + dp[k][j], dp[i][j]);
                }
            }
        }
        return dp[0][newNums.length-1];
    }
}
