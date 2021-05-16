package com.jianzhi.offer.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串。*
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhaojun
 */
public class SerializeAndDeserialize {
    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            data = x;
        }
    }

    private static final String EMPTY = "[]";

    public String serialize(TreeNode root) {
        if (root == null) {
            return EMPTY;
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            } else {
                stringBuilder.append("null,");
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            } else {
                stringBuilder.append(treeNode.data + ",");
            }
        }
        //移除末尾的null

        while (stringBuilder.toString().endsWith("null,")) {
            stringBuilder.delete(stringBuilder.capacity()-5, stringBuilder.capacity());
        }
        //移除最后的",", 再加上括号
        return stringBuilder.deleteCharAt(stringBuilder.capacity()).append("]").toString();
    }

    public TreeNode deserialize(String str) {
        if (Objects.equals(EMPTY, str)) {
            return null;
        }
        String[] params = str.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(params[0]));
        LinkedList<TreeNode> treeNodeLinkedList = new LinkedList<>();
        treeNodeLinkedList.add(root);
        //队列的索引
        int index = 0;
        boolean isLeft = true;
        for (int i = 1; i < params.length; i++) {
            if (!Objects.equals(params[i], "null")) {
                TreeNode treeNode = new TreeNode(Integer.parseInt(params[i]));
                treeNodeLinkedList.add(treeNode);
                if (isLeft) {
                    treeNodeLinkedList.get(index).left= treeNode;
                } else {
                    treeNodeLinkedList.get(index).right= treeNode;
                }
            }
            if (!isLeft) {
                //代表此时是右节点。然后索引加1，开始给下一个节点增加左子树
                index++;
            }
            isLeft = !isLeft;
        }
        return root;
    }
}
