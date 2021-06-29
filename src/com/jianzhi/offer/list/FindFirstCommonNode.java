package com.jianzhi.offer.list;

import java.util.Stack;

/**
 * 输入两个无环的单链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 *
 * 首先要理解什么是公共节点，并不是两个节点的值相同就是公共节点。
 * 而是在第一链表和第二链表中都存在一个节点，该节点往后的子链表在两个链表中是相同的。
 * @author zhaojun
 */
public class FindFirstCommonNode {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 如果两个链表存在公共节点，那么公共节点出现在两个链表的尾部。
     * 如果我们从两个链表的尾部开始往前比较，那么最后一个相同的节点就是我们要找的节点。
     * 但是这两个链表是单向的，要实现尾节点最先比较，我们可以借助两个辅助栈。
     * 分别将两个链表的节点放入两个栈中，这样栈顶就是两个链表的尾节点，
     * 比较两个栈顶节点是否相同，如果相同，将栈顶弹出比较下一个栈顶，直到找到最后一个相同的栈顶。
     * 时间复杂度O(m + n)。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (pHead1 != null){
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode result = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ListNode listNode1 = stack1.pop();
            ListNode listNode2 = stack2.pop();
            if (listNode1.val == listNode2.val) {
                result = listNode1;
            } else {
               break;
            }
        }
        return result;
    }

    /** 
     * 双指针
     * 两链表的头指针同时出发，当第二次经过第一个公共节点时，会完美相遇
     * 指针A从链表A出发，经过1，2，3，6，7后，走到4，5，6，第二次达到节点6时，走了7步，经过8个节点。指针B从链表B出发，经过4，5，6，7后，走到1，2，3，6，第二次达到节点6时，也走了7步，经过8个节点。两指针正好相遇。
     *
     * 作者：雁阵惊寒_zhn
     * 链接：https://www.jianshu.com/p/d5f1598694df
     * 来源：简书
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
