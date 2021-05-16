package com.jianzhi.offer.tree;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 * 思路：平衡树的子树也是平衡树，一直递归下去，找到叶子节点，根据左右子树的深度差值来判断
 * @author zhaojun
 */
public class BalancedTree {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            data = x;
        }
    }

    public int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDeep = deep(root.left);
        if (leftDeep == -1) {
            return -1;
        }
        int rightDeep = deep(root.right);
        if (rightDeep == -1) {
            return -1;
        }
        //来到这里，leftDeep和rightDeep分别代表该节点的左子树深度和右子数深度
        if (Math.abs(leftDeep-rightDeep) <= 1) {
            //小于1代表是搜索树，然后返回当前节点的深度
            return 1 + Math.max(rightDeep, leftDeep);
        } else {
            return -1;
        }
    }

    public boolean isBalanced(TreeNode node) {
        return deep(node) != -1;
    }
}
