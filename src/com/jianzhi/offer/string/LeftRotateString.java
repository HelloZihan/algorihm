package com.jianzhi.offer.string;

/** 
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 示例1
 * 输入
 * "abcXYZdef",3
 * 返回值
 * "XYZdefabc"
 *
 * 思路：这道题考查的核心是灵活利用字符串翻转。
 * 假设字符串abcdef，n=3，设X=abc，Y=def，所以字符串可以表示成XY，
 * 如题干，问如何求得YX。
 * 假设X的翻转为XT，XT=cba，同理YT=fed，那么YX=(XTYT)T，三次翻转后可得结果
 * @author zhaojun
 */
public class LeftRotateString {

    public String LeftRotateString(String str, int n) {
        char[] chars = str.toCharArray();
        if (chars.length < n) {
            return "";
        }
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);

        return new String(chars);
    }

    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
