package com.leetcode.hot100;

/**
 * 79.单词搜索
 *
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class Exist {
    boolean result = false;
    public boolean exist(char[][] board, String word) {
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, word, 0, flag);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, String word, int index, boolean[][] flag) {
        if (index >= word.length()) {
            result = true;
            return;
        }
        if (result) {
            return;
        }
        if (i >= board.length || j >= board[0].length || i<0 || j<0) {
            return;
        }
        if (flag[i][j]) {
            return;
        }
        if (board[i][j] != word.charAt(index)) {
            return;
        }
        flag[i][j] = true;
        dfs(board, i, j+1, word, index+1, flag);
        dfs(board, i+1, j, word, index+1, flag);
        dfs(board, i-1, j, word, index+1, flag);
        dfs(board, i, j-1, word, index+1, flag);
        //注意 很重要。需要重置结果，否则会影响
        flag[i][j] = false;
    }

    public static void main(String[] args) {
//        [["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
//        "ABCEFSADEESE"
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        System.out.println(new Exist().exist(board, "ABCEFSADEESE"));
    }
}
