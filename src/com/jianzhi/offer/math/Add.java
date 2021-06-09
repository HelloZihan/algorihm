package com.jianzhi.offer.math;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 在计组中，半加器、全加器中：
 * 两个二进制的相加结果是用一个异或门实现的；
 * 两个二进制的进位结果是用一个与门来实现的
 * a+b = (a ^ b) + ((a & b) << 1), 因为不能用加号, 故反复重复该运算
 * https://blog.nowcoder.net/n/07f2bd03162d40ddaebefd666e0d71b2?f=comment
 * @author zhaojun
 */
public class Add {
    public int add(int num1,int num2) {
        int result, ans;
        do {
            // 每一位相加
            result = num1 ^ num2;
            // 进位
            ans = (num1 & num2) << 1;
            num1 = result;
            num2 = ans;
        } while (ans != 0);
        return result;
    }
    
    //递归
    public int add1(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        // 转换成非进位和 + 进位
        return add1(a ^ b, (a & b) << 1);
    }
}
