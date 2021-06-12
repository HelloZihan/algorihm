package com.jianzhi.offer.list;

import java.util.HashMap;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * https://www.cnblogs.com/xuechengmeigui/p/12613633.html
 * @author zhaojun
 */
public class EntryNodeOfLoop {

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法一：复制HashMap
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop1(ListNode pHead) {

        HashMap<ListNode,Integer> first = new HashMap<>(16);
        ListNode pListNode = pHead;
        while(pListNode != null){
            if(!first.containsKey(pListNode)){
                first.put(pListNode, 1);
            }
            else{
                return pListNode;
            }
            pListNode = pListNode.next;
        }
        return null;
    }

    /**
     * 方法二：快慢指针
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        //slow fast和重置后的fast起点均为phead
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = pHead;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

}
