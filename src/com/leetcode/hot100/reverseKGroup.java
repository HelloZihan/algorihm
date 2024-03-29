package com.leetcode.hot100;

/**
 * 25. K个一组翻转链表
 *
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * k是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class reverseKGroup {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode before = new ListNode();
        before.next = head;
        ListNode pre = before;
        while(head != null) {
            ListNode tail = pre;
            for(int i=0; i<k; i++) {
                tail = tail.next;
                if(tail == null) {
                    return before.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] l = reverse(head, tail);
            pre.next = l[0];
            l[1].next = next;
            pre = l[1];
            head = pre.next;
        }
        return before.next;
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode cur = head;
        ListNode next = head.next;
        ListNode pre = null;
        while(cur != tail) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        return new ListNode[]{cur, head};
    }
}
