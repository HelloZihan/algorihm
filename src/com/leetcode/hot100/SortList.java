package com.leetcode.hot100;

/**
 * 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * 输入：head = []
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhaojun
 */
public class SortList {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //[4,2,1,3]
        //断开链表后，head为前半部分起点，slow为后半部分起点
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        //链表从这之后断掉，因为空节点为上面的循环截止条件
        pre.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return mergeSort(left, right);
    }

    private ListNode mergeSort(ListNode left, ListNode right) {
        ListNode pre = new ListNode(-1);
        ListNode current = pre;
        while (left != null || right != null) {
            if (left == null) {
                current.next = right;
                break;
            } else if (right == null) {
                current.next = left;
                break;
            } else {
                if (left.val < right.val) {
                    current.next = left;
                    left = left.next;
                    current = current.next;
                } else {
                    current.next = right;
                    right = right.next;
                    current = current.next;
                }
            }
        }
        return pre.next;
    }

    public static void main(String[] args) {
        //[4,2,1,3]
        SortList sortList = new SortList();
        SortList.ListNode test = sortList.new ListNode(4);
        test.next = sortList.new ListNode(2);
        test.next.next = sortList.new ListNode(1);
        test.next.next.next = sortList.new ListNode(3);
        ListNode listNode = sortList.sortList(test);
        System.out.println(listNode);
    }
}
