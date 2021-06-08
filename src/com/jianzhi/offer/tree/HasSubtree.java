package com.jianzhi.offer.tree;


/**
 * 是否是子树
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * @author zhaojun
 */
public class HasSubtree {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            data = x;
        }
    }

    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 ==null) {
            return false;
        }
        return isSubtree(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        //先判断root2，root2为null，代表root2递归结束了，一直满足要求
        if (root2 == null) {
            return true;
        }
        //root1结束了并且roo2还没结束，就代表不是子树
        if (root1 == null) {
            return false;
        }
        if (root1.data == root2.data) {
            return  isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
        }
        return false;
    }
}
