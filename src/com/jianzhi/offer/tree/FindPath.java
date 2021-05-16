package com.jianzhi.offer.tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 输入：
 * {10,5,12,4,7},22
 * 输出：
 * [[10,5,7],[10,12]]
 * @author zhaojun
 */
public class FindPath {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            data = x;
        }
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        solve(root, target);
        return res;
    }

    private void solve(TreeNode root, int target) {
        path.add(root.data);
        if (root.data == target && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (root.left != null) {
            solve(root.left, target - root.data);
        }
        if (root.right != null) {
            solve(root.right, target - root.data);
        }
        path.remove(path.size() -1);
    }

}
