package com.jianzhi.offer.math;

/**
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * @author zhaojun
 */
public class NumberOf1 {
    public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n&1) == 1) {
                count++;
            }
            //>>>代表无符号右移，若用>>会导致负数陷入死循环。每次操作后将n右移1位。
            n = n>>>1;
        }
        return count;
    }

    /**
     * ---------------解法二--------------------------------
     * 思想：用1（1自身左移运算，其实后来就不是1了）和n的每位进行位与，来判断1的个数
     * @param n
     * @return
     */
    private static int NumberOf1_low(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            //如此不用考虑符号位。
            flag = flag << 1;
        }
        return count;
    }

    /**
     * --------------------最优解----------------------------
     * 举例：一个二进制数1100，从右边数起第三位是处于最右边的一个1。
     * 减去1后，第三位变成0，它后面的两位0变成了1，而前面的1保持不变，因此得到的结果是1011.
     * 我们发现减1的结果是把最右边的一个1开始的所有位都取反了。
     * 这个时候如果我们再把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。
     * 如1100&1011=1000.也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0。
     * 那么一个整数的二进制有多少个1，就可以进行多少次这样的操作
     * @param n
     * @return
     */
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            //循环次数变少了很多
            n = (n - 1) & n;
        }
        return count;
    }


    public static int NumberOf1ByApi(int n) {
        return Integer.bitCount(n);
    }
}
