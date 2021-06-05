package com.leetcode.hot100;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class MergeKLists {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeSort(lists, 0, lists.length-1);
    }

    private ListNode mergeSort(ListNode[] lists, int low, int high) {
        if (low >= high) {
            return lists[low];
        }
        int middle = low + (high-low)/2;
        ListNode left = mergeSort(lists, low, middle);
        ListNode right = mergeSort(lists, middle+1, high);
        return mergeTwoLists(left, right);
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
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
