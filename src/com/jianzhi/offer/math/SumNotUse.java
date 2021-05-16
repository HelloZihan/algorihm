package com.jianzhi.offer.math;

/**
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C)
 *
 * 短路求值是什么:
 * 作为"&&"和"||"操作符的操作数表达式，这些表达式在进行求值时，只要最终的结果已经可以确定是真或假，求值过程便告终止，这称之为短路求值（short-circuit evaluation）。
 * 假如expr1和expr2都是表达式，并且expr1的值为0，在下面这个逻辑表达式的求值过程中：
 *
 * expr1 && expr2
 * expr2将不会进行求值，因为整个逻辑表达式的值已经可以确定为0。
 * expr1 || expr2
 * expr2将不会进行求值，因为整个逻辑表达式的值已经确定为1。
 *
 * @author zhaojun
 */
public class SumNotUse {

    public int sum(int n) {
        int sum=n;
        //n=1时直接返回1
        boolean flag=(sum>0)&&((sum+=sum(n-1))>0);
        return sum;
    }
}
