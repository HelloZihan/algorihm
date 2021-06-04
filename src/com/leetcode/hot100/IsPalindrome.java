package com.leetcode.hot100;

/**
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhaojun
 */
public class IsPalindrome {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode middle = slow;
        if (middle.next == null) {
            return true;
        }
        ListNode last = reversal(middle.next);
        while (last != null) {
            if (last.val != head.val) {
                return false;
            }
            last = last.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reversal(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reversal(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
