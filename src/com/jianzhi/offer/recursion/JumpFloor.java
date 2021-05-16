package com.jianzhi.offer.recursion;

/**
 * 递归 跳台阶
 * 理解递归：
 * 步骤1：找到该方法是要干什么
 * 步骤2：找到递归结束的条件。例如n<=2时，就返回
 * 步骤3：找到函数等价表达式。即f(n)与f(n-1)或者f(n-2)等之间的关系，即构成递归
 *
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 思路：
 * 步骤1：计算台阶的跳法.设为f(n)，其中n为台阶的阶数
 * 步骤2：当n=1时，f(n)为1. 当n为2时，f(n)=2(一次跳两阶或者每次跳一阶，跳两次)
 * 步骤3：当青蛙在第n阶台阶上时，它要么是从n-1上跳上来的，要么是从n-2上一次性跳上来的
 * 故函数等价表达式为f(n) = f(n-1) + f(n-2)
 * @author zhaojun
 */
public class JumpFloor {

    public static int count(int n) {
        if (n<=2) {
            return n;
        }
        return count(n-1) + count(n-2);
    }

    public static void main(String[] args) {
        int n = count(50);
        System.out.println("result:" + n);
    }
}
