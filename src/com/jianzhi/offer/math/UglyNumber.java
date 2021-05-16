package com.jianzhi.offer.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 有点像动态规划
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
 *
 * 暴力破解：逐个判断每个整数是不是丑数的解法，直观但不高效。
 * 注：所谓一个数m是另一个数n的因子，是指n能被m整除，也就是n%m == 0。
 * 根据丑数的定义，丑数只能被2、3和5整除：
 * 即一个数能被2整除，我们把它连续除以2；
 * 如果能被3整除，就连续除以3；
 * 如果能被5整除，就连续除以5，直到最后如归我们得到的是1，那么这个数就是丑数，否则不是。
 * @author zhaojun
 */
public class UglyNumber {


    /**
     * 第二思路：创建数组保存已经找到的丑数，用空间换时间的解法(dp?)
     * 由丑数的定义：丑数应该是另一个丑数乘以2、3或者5的结果（1除外）。因此我们可以创建一个数组，里面的数字是排好序的丑数，每一个丑数都是前面的丑数乘以2、3或者5得到的。直观的优化措施就是看我们能不能降低时间复杂度，即只在丑数上花时间，而不在非丑数上浪费时间。故根据上面的丑数定义和思路，我们开辟O(n)的空间来得到时间复杂度为O(n）的算法。
     */
    public int getUglyNumber(int index) {
        List<Integer> dp = new ArrayList<>();
        dp.add(1);
        int t2=0, t3=0, t5=0;
        for (int i = 0; i < index; i++) {
            int min = Math.min(t2 * 2, Math.min(t3 * 3, t5 * 5));
            if (min == t2 * 2) {
                t2++;
            } else if (min == t3 * 3) {
                t3++;
            } else if (min == t5 * 5) {
                t5++;
            }
        }
        return dp.get(index - 1);
    }
}
