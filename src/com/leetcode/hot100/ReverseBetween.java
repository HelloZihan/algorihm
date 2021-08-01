package com.leetcode.hot100;

/**
 *
 * 92. 反转链表 II
 *
 * 给你单链表的头指针head和两个整数left和right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 进阶： 你可以使用一趟扫描完成反转吗？
 *
 * @author zhaojun
 */
public class ReverseBetween {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) {
            return head;
        }
        ListNode before = new ListNode();
        before.next = head;
        ListNode pre = before;
        for(int i=0; i<left-1; i++) {
            pre = pre.next;
        }
        //作为备份
        ListNode cur = pre.next;
        //作为翻转
        ListNode begin = pre.next;
        ListNode next = begin.next;
        ListNode pre1 = null;
        while(right-- > left) {
            begin.next = pre1;
            pre1 = begin;
            begin = next;
            next =next.next;
        }
        begin.next = pre1;
        cur.next = next;
        pre.next = begin;
        return before.next;
    }

}
