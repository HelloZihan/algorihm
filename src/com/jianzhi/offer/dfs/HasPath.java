package com.jianzhi.offer.dfs;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如
 * a b c e
 * s f c s
 * a d e e
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * @author zhaojun
 */
public class HasPath {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param matrix char字符型二维数组
     * @param word string字符串
     * @return bool布尔型
     */
    private boolean  result = false;
    public boolean hasPath (char[][] matrix, String word) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == word.charAt(0)) {
                    boolean[][] flag = new boolean[matrix.length][matrix[0].length];
                    if (dfs(matrix, i, j, word, 0, flag)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] matrix, int i, int j, String word, int index, boolean[][] flag) {
        if (i < 0 || j<0 || i>= matrix.length || j >= matrix[0].length || flag[i][j]) {
            return false;
        }
        if (index >= word.length() || matrix[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() -1) {
            result = true;
            return true;
        }
        if (result) {
            return true;
        }
        flag[i][j] = true;
        dfs(matrix, i+1, j, word, index+1, flag);
        dfs(matrix, i-1, j, word, index+1, flag);
        dfs(matrix, i, j+1, word, index+1, flag);
        dfs(matrix, i, j-1, word, index+1, flag);
        flag[i][j] = false;
        return result;
    }
}
