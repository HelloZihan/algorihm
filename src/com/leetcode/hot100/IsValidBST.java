package com.leetcode.hot100;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 * 1、节点的左子树只包含小于当前节点的数。
 * 2、节点的右子树只包含大于当前节点的数。
 * 3、所有左子树和右子树自身必须也是二叉搜索树
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhaojun
 */
public class IsValidBST {

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

    /**
     * 方法1：递归. 时间复杂度，空间复杂度均为O(n)。
     * 方法2：中序遍历. 左根右，所以每次弹出的节点要大于上一次的节点
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //根节点的值可以是任意的，从int类型到int类型最大均可。只要其子节点满足要求就可以。
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    /**
     * 注意此处为long类型
     */
    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        //可能该树刚好有一个节点是Integer.MIN_VALUE，故long类型判定等号比较可靠
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }
}
