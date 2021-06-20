package com.leetcode.hot100;

/**
 * 200. 岛屿数量
 *
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class NumIslands {
    /**
     * https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !flag[i][j]) {
                    dfs(grid, i, j, m, n, flag);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n, boolean[][] flag) {
        if (i<0 || i>= m || j<0 || j>= n) {
            return;
        }
        if (flag[i][j]) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        flag[i][j] = true;
        dfs(grid, i+1, j, m, n, flag);
        dfs(grid, i-1, j, m, n, flag);
        dfs(grid, i, j-1, m, n, flag);
        dfs(grid, i, j+1, m, n, flag);
    }
}
