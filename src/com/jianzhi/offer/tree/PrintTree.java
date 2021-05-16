package com.jianzhi.offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 思路：在获取子节点之前的队列大小就是当前层的节点个数
 * @author zhaojun
 */
public class PrintTree {
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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> arrayList= new ArrayList<>();
            int start = 0;
            int end = queue.size();
            while (start < end) {
                start++;
                TreeNode treeNode = queue.poll();
                arrayList.add(treeNode.data);
                if (treeNode.left != null) {
                    queue.add(treeNode);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode);
                }
            }
            result.add(arrayList);
        }
        return result;
    }
}
