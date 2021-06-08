package com.jianzhi.offer.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 请实现一个函数按照之字形打印二叉树
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 * 输入
 * {8,6,10,5,7,9,11}
 * 返回值
 * [[8],[10,6],[5,7,9,11]]
 * @author zhaojun
 */
public class PrintTreeByZhi {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            data = x;
        }
    }
    
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(pRoot);
        boolean order = true;
        while (!treeNodes.isEmpty()) {
            int end = treeNodes.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int start=0; start < end; start++) {
                TreeNode treeNode = treeNodes.poll();
                if (treeNode.left != null) {
                    treeNodes.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodes.add(treeNode.right);
                }
                arrayList.add(treeNode.data);
            }
            if (!order) {
                Collections.reverse(arrayList);
            }
            order = !order;
            result.add(arrayList);
        }
        return result;
    }
}
