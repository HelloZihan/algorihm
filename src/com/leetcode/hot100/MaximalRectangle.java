package com.leetcode.hot100;

import java.util.Arrays;

/**
 *  85. 最大矩形
 * 给定一个仅包含0和1、大小为rows x cols的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class MaximalRectangle {

    /**
     * https://leetcode-cn.com/problems/maximal-rectangle/solution/jie-jin-shuang-100javajie-fa-su-kan-by-w-47dv/
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] height = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    height[i][j] = matrix[i][j] - '0';
                } else if(matrix[i][j] - '0' == 0){
                    height[i][j] = 0;
                } else {
                    height[i][j] = matrix[i][j] - '0' + height[i-1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(height));
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //向左右两边找大于它的值，局部最大值再与全局最大值比较
                int left = j-1, right = j+1;
                int width = 1;
                while (left >= 0 && height[i][left] >= height[i][j]) {
                    left--;
                    width++;
                }
                while (right < n && height[i][right] >= height[i][j]) {
                    right++;
                    width++;
                }
                result = Math.max(result, width * height[i][j]);
            }
        }
        return result;
    }
}
