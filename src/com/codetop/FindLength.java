package com.codetop;

/**
 * 718. 最长重复子数组
 *
 * 给两个整数数组A和B，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class FindLength {

    /**
     * dp[i][j]代表从num1以i-1元素与nums2以i-1元素结尾的子数组的公共长度
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m][n];
        int result = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 || j == 0) {
                    dp[i][j] = nums1[i] == nums2[j] ? 1: 0;
                } else {
                    dp[i][j] = nums1[i] == nums2[j] ? dp[i-1][j-1] + 1: 0;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

}
