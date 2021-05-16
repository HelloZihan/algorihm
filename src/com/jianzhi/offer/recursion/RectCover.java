package com.jianzhi.offer.recursion;

/**
 *
 *我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *详细描述：https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
 * @author zhaojun
 */
public class RectCover {
    public static int count(int n) {
        if (n<=2) {
            return n;
        }
        return count(n-1) + count(n-2);
    }

    public static void main(String[] args) {
        System.out.println(count(10));

    }
}
