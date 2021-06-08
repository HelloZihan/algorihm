package com.jianzhi.offer.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。
 * {5,3,7,2,4,6,8},3
 * {4}
 *思路：搜索树的中序遍历即为有序数组
 * @author zhaojun
 */
public class KthNode {
    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            data = x;
        }

    }
    private List<TreeNode> sortTreeNodes = new LinkedList<>();

    public void sort(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        sort(pRoot.left);
        sortTreeNodes.add(pRoot);
        sort(pRoot.right);
    }

    public TreeNode kThNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        sort(pRoot);
        return sortTreeNodes.get(k-1);
    }
}
