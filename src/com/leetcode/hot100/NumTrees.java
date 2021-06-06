package com.leetcode.hot100;

/**
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
 * 返回满足题意的二叉搜索树的种数。
 *
 * 注意：是二叉搜索树
 *
 * 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）
 * 它或者是一棵空树，或者是具有下列性质的二叉树：
 * 1、若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 2、若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 3、它的左、右子树也分别为二叉排序树
 *
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * @author zhaojun
 */
public class NumTrees {
    /**
     * 二叉搜索树个数，等于i节点为根节点，1->i-i这些节点作为左子树，i+1到n为右子树组成的个数。 i可以从1到n，而且i不同树不会重复，所以对不同i求和
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < i+1; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
