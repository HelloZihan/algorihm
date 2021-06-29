package com.jianzhi.offer.list;

/**
 * 
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author zhaojun
 */
public class DeleteDuplication {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode solve(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        //防止phead与下一个节点重合，导致pHead被移除
        ListNode finalPre = pre;
        pre.next = pHead;
        ListNode current = pHead;
        while (current != null) {
            //该题重复节点应该不能是地址重复，只可能是数值重复。地址重复，那next是自身？
            if (current.next != null && current.val == current.next.val) {
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                pre.next = current.next;
                current = current.next;
            } else {
                pre = pre.next;
                current = current.next;
            }
        }
        return finalPre.next;
    }

    public static void main(String[] args) {
        DeleteDuplication deleteDuplication = new DeleteDuplication();
        ListNode listNode1 = deleteDuplication.new ListNode(1);
        ListNode listNode2 = deleteDuplication.new ListNode(1);
        ListNode listNode3 = deleteDuplication.new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(deleteDuplication.solve(listNode1));

    }
}
