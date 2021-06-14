package com.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 32. 最长有效括号
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * @author zhaojun
 */
public class LongestValidParentheses {

    /**
     * ")()())"
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int result = 0;
        //记住不匹配的最后一个')'的索引 方便后面计算个数
        int start = -1;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                deque.push(i);
            } else {
                if (deque.isEmpty()) {
                    start = i;
                    continue;
                }
                deque.pop();
                //')'不会入库 要记住不成立的第一个)的索引，后面方便减去
                if (deque.isEmpty()) {
                    result = Math.max(result, i - start);
                } else {
                    result = Math.max(result, i - deque.peek());
                }
            }
        }
        return result;
    }

    /**
     * dp
     * 我们定义dp[i]表示以下标i字符结尾的最长有效括号的长度。我们将dp数组全部初始化为0。显然有效的子串一定以‘)’ 结尾，因此我们可以知道以‘(’结尾的子串对应的dp值必定为0 ，我们只需要求解 ‘)’ 在dp数组中对应位置的值。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    //'()'
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    //'))' i - dp[i - 1] - 1代表上一个有效长度之前的字符
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    /**
     * 时间O(n) 空间O(1)
     * @param s
     * @return
     */
    public int longestValidParentheses3(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}
