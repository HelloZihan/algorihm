package com.jianzhi.offer.list;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author zhaojun
 */
public class Merge {


    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode pHead;
        if (list1.val < list2.val) {
            pHead = list1;
            list1 = list1.next;
        } else {
            pHead = list2;
            list2 = list2.next;
        }
        ListNode head = pHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pHead.next = list1;
                list1 = list1.next;
            } else {
                pHead.next = list2;
                list2 = list2.next;
            }
            pHead = pHead.next;
        }
        if (list1 == null) {
            pHead.next = list2;
        } else {
            pHead.next = list1;
        }

        return head;
    }
}
