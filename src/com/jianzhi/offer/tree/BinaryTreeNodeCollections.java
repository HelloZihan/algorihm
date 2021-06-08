package com.jianzhi.offer.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树的简单算法汇总
 * 颜色标记法(注意访问的顺序)
 * https://www.chaochaogege.com/2019/09/17/19/
 * @author zhaojun
 */
public class BinaryTreeNodeCollections {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            data = x;
        }
    }

    /**
     * 前序遍历递归
     * @param node
     */
    public static void preOrderTraveral(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.data+" ");
        preOrderTraveral(node.left);
        preOrderTraveral(node.right);
    }

    /**
     * 前序遍历非递归
     */
    public static void preOrderTraveralWithStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = node;
        while (tmp != null || !stack.isEmpty()) {
            while (tmp != null) {
                System.out.println(tmp.data + " ");
                stack.push(tmp);
                tmp = tmp.left;
            }
            if (!stack.isEmpty()) {
                tmp = stack.pop();
                tmp = tmp.right;
            }
        }
    }

    /**
     * 二叉树中序遍历   左-> 根-> 右
     * @param node   二叉树节点
     */
    public static void inOrderTraveral(TreeNode node){
        if(node == null){
            return;
        }
        inOrderTraveral(node.left);
        System.out.print(node.data+" ");
        inOrderTraveral(node.right);
    }

    /**
     * 中序遍历非递归
     * @param node
     */
    public static void inOrderTraveralWithStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = node;
        while (tmp != null || !stack.isEmpty()) {
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
            if (!stack.isEmpty()) {
                tmp = stack.pop();
                System.out.println(tmp.data + " ");
                tmp = tmp.right;
            }
        }
    }

    /**
     * 二叉树后序遍历   左-> 右-> 根
     * @param node    二叉树节点
     */
    public static void postOrderTraveral(TreeNode node){
        if(node == null){
            return;
        }
        postOrderTraveral(node.left);
        postOrderTraveral(node.left);
        System.out.print(node.data+" ");
    }

    /**
     * 二叉树后序遍历：双栈写法
     * 后序遍历的遍历顺序是左右根。我们是否可以从我们熟悉且简单的前序遍历转化过去后序遍历呢？
     *
     * 答案是可以的。我们可以观察到，可以先求出遍历顺序是根右左的节点序列，再倒序，便刚好是后序遍历的顺序：左右根。而遍历顺序是根右左的话，很好办，从前序遍历的代码中改两行就是了。
     *
     * 所以我们可以选用两个栈，一个用于根右左遍历，一个用于保存序列，最后的代码和前序遍历只是稍作几点修改即可。
     */
    public void postorderTraversalWithDoubleStack(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        // 保存节点序列的栈
        Stack<Integer> res = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !s.isEmpty()) {
            while(cur!=null) {
                res.push(cur.data);
                s.push(cur);
                //修改处
                cur = cur.right;
            }
            if(!s.isEmpty()) {
                cur = s.pop();
                //修改处
                cur = cur.left;
            }

        }
        while(!res.isEmpty()) {
            // 获取倒序的根右左序列
            System.out.println(res.pop());
        }
    }

    /**
     * 二叉树后序遍历：单栈写法
     * 实际上，我们可以只使用一个栈去模拟后序遍历，但是会比较麻烦。为了避免问题变得复杂，我们可以先考虑一下能不能借鉴一下前序遍历的思路。
     *
     * 首先，我们很确定的是，后序遍历的开头和前序遍历是可以一样的，都是先经过二叉树的最左分支，直到经过的节点是个叶子节点（没有左右孩子）为止。
     * https://zhuanlan.zhihu.com/p/80578741
     * @param root
     */
    public void postorderTraversalWithStack(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        // 用于记录上一次访问的节点
        TreeNode pre = null;
        while(cur != null || !s.isEmpty()) {
            while(cur!=null) {
                s.push(cur);
                cur = cur.left;
            }
            if(!s.isEmpty()) {
                cur = s.pop();
                // 访问节点的条件
                if(cur.right==null || pre==cur.right) {
                    // 访问
                    System.out.println(cur.data);
                    // 这一步是记录上一次访问的节点
                    pre = cur;
                    // 此处为了跳过下一次循环的访问左子节点的过程，直接进入栈的弹出阶段，因为但凡在栈中的节点，它们的左子节点都肯定被经过且已放入栈中。
                    cur = null;
                } else { // 不访问节点的条件
                    // 将已弹出的根节点放回栈中
                    s.push(cur);
                    // 经过右子节点
                    cur = cur.right;
                }
            }
        }
    }

    /**
     * 层次遍历
     * @param root
     */
    public static void levelOrder(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            root = queue.pop();
            System.out.print(root.data+" ");
            if(root.left!=null) {
                queue.add(root.left);
            }
            if(root.right!=null) {
                queue.add(root.right);
            }
        }
    }

}
