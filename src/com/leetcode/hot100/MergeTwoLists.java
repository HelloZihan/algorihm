package com.leetcode.hot100;

/**
 * 合并两个有序的链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author zhaojun
 */
public class MergeTwoLists {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();
        ListNode tmp = pre;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                tmp.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                tmp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                if (l1.val > l2.val) {
                    tmp.next = new ListNode(l2.val);
                    l2 = l2.next;
                } else {
                    tmp.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
            }
            tmp = tmp.next;
        }
        return pre.next;
    }
}
