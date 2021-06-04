package com.leetcode.hot100;

/**
 * @author zhaojun
 */
public class ReverseList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 核心在于翻转pre和current之间的指向，current改变指向后需要next记住下一个节点
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        ListNode next = current.next;
        ListNode pre = null;
        while (next != null) {
            current.next = pre;
            pre = current;
            current = next;
            next = next.next;
        }
        current.next = pre;
        return current;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        //注意需要head为null判定，以防初始head就是null
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList1(head.next);
        head.next.next = head;
        //原来初始节点的next需要为null
        head.next = null;
        return last;
    }
}
