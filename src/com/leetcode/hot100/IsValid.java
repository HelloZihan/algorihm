package com.leetcode.hot100;

import java.util.Stack;

/**
 * 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 输入：s = "{[]}"
 * 输出：true
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhaojun
 */
public class IsValid {
    /**
     * 碰到这种要处理相邻字符时，可以想一下栈
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char old = stack.pop();
                    if (c == '}' && old != '{')  {
                        return false;
                    } else if (c == ')' && old != '(') {
                        return false;
                    } else if (c == ']' && old != '[') {
                        return false;
                    }
                }
            } else {
                stack.push(c);
            }
        }
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
