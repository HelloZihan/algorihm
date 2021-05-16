package com.jianzhi.offer.math;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0。不得使用库函数，同时不需要考虑大数问题，也不用考虑小数点后面0的位数。
 * @author zhaojun
 */
public class Power {
    public double power(double base, int exponent) {
        if (exponent < 0 ) {
            //2的-1次方，等于2的倒数的2次方
            base = 1/base;
            exponent = - exponent;
        }
        //todo 头很晕，不想做这种题，后续补上
        return 0.0;
    }
}
