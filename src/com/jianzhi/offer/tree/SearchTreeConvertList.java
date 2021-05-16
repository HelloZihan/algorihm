package com.jianzhi.offer.tree;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 节点的left作为前驱指针，right作为后驱指针
 * @author zhaojun
 */
public class SearchTreeConvertList {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            data = x;
        }
    }

    private TreeNode head, pre;
    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        dfs(pRootOfTree);
        head.left = pre;
        pre.right = head;
        return head;
    }

    /**
     * 中序遍历为有序，在dfs(current.left)和dfs(current.right)中间做操作
     * @param current
     */
    private void dfs(TreeNode current) {
        if (current == null) {
            return;
        }
        dfs(current.left);
        if (pre == null) {
            head = current;
        } else {
            pre.right = current;
        }
        current.left = pre;
        pre = current;
        dfs(current.right);
    }
}
