package com.codetop;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 402. 移掉 K 位数字
 *
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * 示例 1 ：
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 *
 * 示例 2 ：
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 *
 * 示例 3 ：
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhaojun
 */
public class RemoveKdigits {

    public String removeKdigits(String num, int k) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for(int i=0; i<num.length();i++) {
            int tmp = num.charAt(i) - '0';
            while(!deque.isEmpty() && k>0 && deque.peek()>tmp) {
                deque.pop();
                k--;
            }
            deque.push(tmp);
        }
        //防止相等，导致没移动完，或者K很大。
        for(int i=0; i<k; i++) {
            deque.pop();
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean isStart = true;
        while(!deque.isEmpty()) {
            int tmp = deque.pollLast();
            if(isStart) {
                if(tmp == 0) {
                    continue;
                }
                isStart = false;
            }
            stringBuilder.append(tmp);
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }
}
