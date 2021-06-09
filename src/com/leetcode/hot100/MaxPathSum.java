package com.leetcode.hot100;

/**
 * 124. 二叉树中的最大路径和
 *
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhaojun
 */
public class MaxPathSum {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        solve(root);
        return result;
    }

    private int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(solve(root.left), 0);
        int right = Math.max(solve(root.right), 0);
        result = Math.max(left + right + root.val, result);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        MaxPathSum maxPathSum = new MaxPathSum();
        MaxPathSum.TreeNode treeNode = maxPathSum.new TreeNode(0);
        System.out.println(maxPathSum.maxPathSum(treeNode));
    }

}
