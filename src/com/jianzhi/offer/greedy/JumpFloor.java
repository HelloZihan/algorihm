package com.jianzhi.offer.greedy;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(1)
 * f(n-1) = f(n-2) + f(n-3) + ... + f(1)
 * 两式相减 f(n) = 2f(n-1)
 * @author zhaojun
 */
public class JumpFloor {
    public int count(int n) {
        if (n == 1) {
            return 1;
        }
        return 2 * count(n-1);
    }
}
