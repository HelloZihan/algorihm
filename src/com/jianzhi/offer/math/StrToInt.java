package com.jianzhi.offer.math;

/**
 *
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 * @author zhaojun
 */
public class StrToInt {

    /**
     * str转化为char数组后，char[0]为字符串最左边的字符。
     * @param str
     * @return
     */
    public static int strToInt(String str) {
        //此处需要注意chars数组怎么分布的
        char[] chars = str.toCharArray();
        int symbol = 0;
        if (chars[0] == '+') {
            symbol = 1;
            chars[0] = '0';

        } else if (chars[0] == '-') {
            symbol = -1;
            chars[0] = '0';
        }
        if (symbol == 0 && chars[0] == 0 || symbol!=0 && chars[1] == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            //tmp和c在数值上并不相等
//            int tmp = chars[i];
//            System.out.println(chars[i]);
//            System.out.println(tmp);
            int tmp = chars[i] - '0';
            if (tmp > 9 || tmp < 0) {
                return 0;
            }
            result += tmp * Math.pow(10, chars.length-i-1);
        }
        return result * symbol;
    }

    public static void main(String[] args) {
        strToInt("+2147483647");
    }
}
