package com.jianzhi.offer.tree;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 * （ps：我们约定空树不是二叉搜素树）
 *
 * 数组的最后一个节点是根节点，然后其余连续小于根节点的位于左子树，连续大于根节点的位于右子树，依次递归
 * @author zhaojun
 */
public class VerifySquenceOfBST {

    public boolean verifySquenceOfBST(int [] sequence) {
        if (sequence == null) {
            return false;
        }
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        int root = sequence[sequence.length-1];
        //index为第一次大于root元素对应的位置
        int index = sequence.length-1;
        for (int i = 0; i < sequence.length-1; i++) {
            if(sequence[i] > root) {
                index = i;
                break;
            }
        }
        for (int i = index; i < sequence.length-1; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        if (index == sequence.length-1) {
            return verifySquenceOfBST(Arrays.copyOfRange(sequence,0, index));
        } else if (index == 0) {
            return verifySquenceOfBST(Arrays.copyOfRange(sequence, index, sequence.length-1));
        } else {
            return verifySquenceOfBST(Arrays.copyOfRange(sequence,0, index))
                    && verifySquenceOfBST(Arrays.copyOfRange(sequence, index, sequence.length-1));
        }
    }
}
