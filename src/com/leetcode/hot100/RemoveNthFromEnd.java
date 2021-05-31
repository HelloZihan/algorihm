package com.leetcode.hot100;

/**
 * 删除链表的倒数第 N 个结点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * @author zhaojun
 */
public class RemoveNthFromEnd {

      private class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        //此题需要注意的是head可能被删除掉，所以直接声明一个前驱节点
        ListNode start = pre;
        ListNode end = pre;
        while (start != null) {
            start = start.next;
            if (n >= 0) {
                n--;
            } else {
                end = end.next;
            }
        }
        //由此可见，end为倒数第n+1个节点
        end.next = end.next.next;
        return pre.next;
    }
}
