package com.jianzhi.offer.tree;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * https://www.bilibili.com/video/BV1f741197Rx?from=search&seid=5274369075036761131
 * @author zhaojun
 */
public class ReConstructBinaryTree {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            data = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre,int[] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        int index = findIndex(pre, in);
        TreeNode result = new TreeNode(pre[0]);
        //假设现在有一棵树，先序遍历和中序遍历都出来了
        result.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, index+1), Arrays.copyOfRange(in, 0, index));
        result.right = reConstructBinaryTree(Arrays.copyOfRange(pre, index+1, pre.length), Arrays.copyOfRange(in, index+1, in.length));
        return result;
    }

    public int findIndex(int[] pre, int[] in) {
        for (int i=0; i< in.length; i++) {
            if (in[i] == pre[0]) {
                return i;
            }
        }
        return 0;
    }
}
