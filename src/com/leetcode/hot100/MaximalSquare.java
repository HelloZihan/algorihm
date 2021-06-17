package com.leetcode.hot100;

/**
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhaojun
 */
public class MaximalSquare {
    /**
     * dp[i][j]代表以matrix[i][j]为右下角的最大正方形边长
     * 如果matrix数组当前值为'0'，最大正方形边长必然为0
     * 如果当前值不为'0'，则从右下角往上、往左、往左上看，如果均为1，则正方形边长加1
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 || j ==0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else if (matrix[i][j] - '0' == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result * result;
    }
}
