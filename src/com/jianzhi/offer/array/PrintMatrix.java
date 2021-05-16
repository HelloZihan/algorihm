package com.jianzhi.offer.array;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 示例1
 * 输入
 * [[1,2],[3,4]]
 * 返回值
 * [1,2,4,3]
 *
 * @author zhaojun
 */
public class PrintMatrix {

    public int moreThanHalfNum_Solution(int [] array) {
        int count=0;
        int target = array[0];
        for (int a : array) {
            if (count == 0) {
                target = a;
                count = 1;
            } else {
                if (a == target) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return target;
    }
}
