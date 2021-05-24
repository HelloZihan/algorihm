package com.jianzhi.offer.list;

/**
 * @author zhaojun
 */
public class FindKthToTail {

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail (ListNode pHead, int k) {
        if (pHead == null) {
            return pHead;
        }
        ListNode first = pHead, second = pHead;
        while (k > 0) {
            k--;
            if (first == null) {
                return null;
            }
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
