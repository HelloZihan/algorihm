package com.jianzhi.offer.tree;

/**
 * 镜像二叉树
 * 比如：    源二叉树
 *              8
 *            /  \
 *           6   10
 *          / \  / \
 *         5  7 9 11
 *         镜像二叉树
 *              8
 *            /  \
 *           10   6
 *          / \  / \
 *         11 9 7  5
 * @author zhaojun
 */
public class MirrorTree {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            data = x;
        }
    }

    public TreeNode mirror (TreeNode pRoot) {
        if(pRoot == null) {
            return null;
        }
        TreeNode  tmp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.left = tmp;
        mirror(pRoot.left);
        mirror(pRoot.right);
        return pRoot;
    }
}
