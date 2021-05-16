package com.jianzhi.offer.tree;

import java.util.LinkedList;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 也可以是用递归
 * @author zhaojun
 */
public class Symmetrical {
    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            data = x;
        }
    }

    /**
     * 方法一
     * 层次遍历，子数组对称
     * @param pRoot
     * @return
     */
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return false;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(pRoot);
        while (!treeNodes.isEmpty()) {
            int start = 0, end = treeNodes.size();
            while (start++ < end) {
                TreeNode treeNode = treeNodes.remove();
                if (treeNode.left != null) {
                    treeNodes.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodes.add(treeNode.right);
                }
            }
            //每次内层循环完毕的时候，队列中是下一层的从左到右所有节点。此时判断是否对称即可
            if (treeNodes.size() > 0) {
                int index = 0;
                int size = treeNodes.size();
                for (int i = 0; i < size/2; i++) {
                    if (treeNodes.get(index).data != treeNodes.get(size - index - 1).data) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 方法二，每次弹出两个
     * @param pRoot
     * @return
     */
    public boolean isSymmetrical2(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        LinkedList<TreeNode> q = new LinkedList<>();

        q.offer(pRoot.left);
        q.offer(pRoot.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null &&right == null){
                continue;
            }
            if(left == null ||right == null){
                return false;
            }
            if(left.data!=right.data){
                return false;
            }
            q.offer(left.left);
            q.offer(right.right);

            q.offer(left.right);
            q.offer(right.left);
        }
        return true;
    }

    /**
     * 方法三 递归
     * @param pRoot
     * @return
     */
    boolean isSymmetricalByRec(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        return isSame(pRoot.left, pRoot.right);
    }

    private boolean isSame(TreeNode left , TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        return left.data == right.data && isSame(left.left,right.right)&&isSame(left.right,right.left);
    }
}
