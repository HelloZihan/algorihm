package com.leetcode.hot100;

/**
 *
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字0之外，这两个数都不会以0开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhaojun
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        int high = 0;
        ListNode preHead1 = new ListNode(-1);
        ListNode current = preHead1;
        while (l1 != null || l2 != null) {
            int c1 = 0;
            if (l1 != null) {
                c1 = l1.val;
                l1 = l1.next;
            }
            int c2 = 0;
            if (l2 != null) {
                c2 = l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode((c1 + c2 + high) % 10);
            high = (c1 + c2 + high)/10;
            current = current.next;
            System.out.println(current.val);

        }
        //此处很重要，可能两条链表走完，但是往前进1，导致high不为0，结果中漏掉
        if (high != 0) {
            current.next = new ListNode(high);
        }
        return preHead1.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode1 = addTwoNumbers.new ListNode(2);
        ListNode listNode2 = addTwoNumbers.new ListNode(4);
        ListNode listNode3 = addTwoNumbers.new ListNode(3, null);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = addTwoNumbers.new ListNode(5);
        ListNode listNode5 = addTwoNumbers.new ListNode(6);
        ListNode listNode6 = addTwoNumbers.new ListNode(4, null);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        System.out.println(addTwoNumbers.addTwoNumbers(listNode1, listNode4));
    }
}
