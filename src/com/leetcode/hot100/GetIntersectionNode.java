package com.leetcode.hot100;

import com.jianzhi.offer.list.FindFirstCommonNode;

/**
 * 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null 。
 *
 * 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
 * @author zhaojun
 */
public class GetIntersectionNode {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1Backup = headA, l2Backup = headB;
        if (headA == null || headB == null) {
            return null;
        }
        int size1 = 1;
        while (headA.next != null) {
            headA = headA.next;
            size1++;
        }
        int size2 = 1;
        while (headB.next != null) {
            headB = headB.next;
            size2++;
        }
        if (headA != headB) {
            return null;
        }
        if (size1 > size2) {
            while (size2 < size1) {
                size2++;
                l1Backup = l1Backup.next;
            }
        } else {
            while (size1 < size2) {
                size1++;
                l2Backup = l2Backup.next;
            }
        }
        while (l1Backup != l2Backup) {
            l1Backup = l1Backup.next;
            l2Backup = l2Backup.next;
        }
        return l1Backup;
    }


    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(null == headA || null == headB){
            return null;
        }
        ListNode node1 = headA;
        ListNode node2 = headB;
        //两指针第二次走到第一个公共节点，就是两指针的第一次相遇
        while(node1 != node2){
            //如果两链表有公共节点，指针只有一次指向null
            //若两链表无公共节点，指针第二次指向null的时候，while循环结束
            node1 = (null == node1) ? headB : node1.next;
            node2 = (null == node2) ? headA : node2.next;
        }
        return node1;
    }
}
