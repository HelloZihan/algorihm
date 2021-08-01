package com.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 227. 基本计算器 II
 *
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 *
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 *
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class Calculate {

    public int calculate(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        int num = 0;
        char preSign = '+';
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + s.charAt(i) - '0';
            }
            if((s.charAt(i) < '0' || s.charAt(i) > '9') && s.charAt(i) != ' ' || i == s.length() - 1) {
                if(preSign == '+') {
                    deque.push(num);
                } else if(preSign == '-') {
                    deque.push(-num);
                } else if(preSign == '*') {
                    deque.push(num * deque.pop());
                } else {
                    deque.push(deque.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int result = 0;
        while(!deque.isEmpty()) {
            result += deque.pop();
        }
        return result;
    }

}
