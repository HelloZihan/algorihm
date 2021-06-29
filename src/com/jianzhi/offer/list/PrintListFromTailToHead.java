package com.jianzhi.offer.list;

import java.util.ArrayList;

/**
 * 翻转链表：输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 输入
 * {67,0,24,58}
 * 返回值
 * [58,24,0,67]
 * @author zhaojun
 */
public class PrintListFromTailToHead {
    ArrayList<Integer> list = new ArrayList<>();

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归。 也可以使用栈
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode.next != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
    /**
     * 反转链表
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ListNode pre = null, current = listNode, next = listNode.next;
        while (next != null) {
            pre = current;
            current = next;
        }
        return list;
    }
}
