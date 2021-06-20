package com.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 394. 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class DecodeString {

    //s = "3[a]2[bc]"  s = "3[a2[c]]"
    public String decodeString(String s) {
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                StringBuilder stringBuilder = new StringBuilder();
                while (!deque.peek().equals("[")) {
                    stringBuilder.insert(0, deque.pop());
                }
                deque.pop();
                int count = Integer.parseInt(deque.pop());
                count--;
                String s1 = stringBuilder.toString();
                while (count > 0) {
                    stringBuilder.append(s1);
                    count--;
                }
                deque.push(stringBuilder.toString());
            } else {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    String s1 = String.valueOf(s.charAt(i) - '0');
                    while (i+1<s.length() && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9') {
                        s1 = s1 + (s.charAt(i+1) - '0');
                        i++;
                     }
                    deque.push(s1);
                } else {
                    deque.push(String.valueOf(s.charAt(i)));
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()) {
            result.insert(0, deque.pop());

        }
        return result.toString();
    }

    public static void main(String[] args) {
        //accaccacc
        System.out.println(new DecodeString().decodeString("10[leetcode]"));
    }
}
