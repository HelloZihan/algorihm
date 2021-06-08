package com.jianzhi.offer.tree;

/**
 * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针。
 * @author zhaojun
 */
public class GetNext {

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        //如果该节点存在右节点，那么该节点右子树的最左节点即为下一个节点
        if (pNode.right != null) {
            TreeLinkNode treeLinkNode = pNode.right;
            while (treeLinkNode.left != null) {
                treeLinkNode = treeLinkNode.left;
            }
            return treeLinkNode;
        }
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        //这里是中序遍历最后一个节点
       return null;
    }
}
