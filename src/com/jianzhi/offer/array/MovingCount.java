package com.jianzhi.offer.array;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * 示例1
 * 输入
 * 5,10,10
 * 返回值
 * 21
 * @author zhaojun
 */
public class MovingCount {
    private int count = 0;

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] status = new boolean[rows][cols];
        solve(0, 0, rows, cols, threshold, status);
        return count;
    }

    private void solve(int x, int y, int rows, int cols, int threshold, boolean[][] status) {
        if (x<0 || x >= rows || y<0 || y>=cols || cal(x, y) > threshold || status[x][y]) {
            return;
        }
        // 当前位置(x,y)是可以走的，那么就从当前位置往四个方向移动即可
        status[x][y] = true;
        count++;
        solve(x+1, y, rows, cols, threshold, status);
        solve(x-1, y, rows, cols, threshold, status);
        solve(x, y-1, rows, cols, threshold, status);
        solve(x, y+1, rows, cols, threshold, status);
    }
    private int cal(int x, int y) {
        int result = 0;
        while (x != 0) {
            result += x%10;
            x = x/10;
        }
        while (y != 0) {
            result += y%10;
            y = y/10;
        }
        return result;
    }


}
