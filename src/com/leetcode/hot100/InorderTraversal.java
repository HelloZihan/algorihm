package com.leetcode.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历(左 -> 根 -> 右)
 * <p>
 * 此方法有点意思，通用的方法
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
 *
 * @author zhaojun
 */
public class InorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        return inorderTraversal(root, new ArrayList<>());
    }

    public List<Integer> inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return null;
        }
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
        return result;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        Stack<TreeNode> treeNodes = new Stack<>();
        List<Integer> result = new ArrayList<>();
        while (!treeNodes.isEmpty() || root != null) {
            while (root != null) {
                treeNodes.push(root);
                root = root.left;
            }
            root = treeNodes.pop();
            result.add(root.val);
            root = root.right;

        }
        return result;
    }


    class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node, String color) {
            this.node = node;
            this.color = color;
        }
    }

    /**
     * 此方法可以统一不同的遍历顺序，见开始的链接
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, "white"));

        while (!stack.empty()) {
            ColorNode cn = stack.pop();

            if (cn.color.equals("white")) {
                if (cn.node.right != null) {
                    stack.push(new ColorNode(cn.node.right, "white"));
                }
                stack.push(new ColorNode(cn.node, "gray"));
                if (cn.node.left != null) {
                    stack.push(new ColorNode(cn.node.left, "white"));
                }
            } else {
                res.add(cn.node.val);
            }
        }
        return res;
    }

    /**
     * 补一个java版的解。这个题解的宗旨就是使用一个颜色或者任何东西，记录节点的访问次数。
     * 在中序中，节点第二次访问会被输出。
     * 因此使用颜色，或者hash表来记录节点的访问次数，次数使用hash表来记录
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {

        HashMap<TreeNode, Integer> map = new HashMap<>(16);
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            //初始检查
            return list;
        }
        stack.push(root);
        //1表示第一次访问,2表示第二次访问。
        map.put(root, 1);
        while (!stack.isEmpty()) {
            //弹栈
            TreeNode node = stack.pop();
            //如果是第一次访问的话，则将其右子节点，自身，左子结点入栈
            if (1 == map.get(node)) {
                //将右子节点入栈
                if (node.right != null) {
                    stack.push(node.right);
                    map.put(node.right, 1);
                }
                //将自身入栈，改变访问次数
                stack.push(node);
                //更新访问次数
                map.put(node, 2);
                //将左子节点入栈
                if (node.left != null) {
                    stack.push(node.left);
                    map.put(node.left, 1);
                }

            } else {
                //else表示是第2次访问，就输出
                list.add(node.val);
            }
        }
        return list;
    }
}
