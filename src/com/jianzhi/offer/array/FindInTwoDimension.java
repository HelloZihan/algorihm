package com.jianzhi.offer.array;

/**
 * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @author zhaojun
 */
public class FindInTwoDimension {
    //增序数组，有提示。 斜对角开始找，有规律
    public boolean find(int target, int [][] array) {
        int i = 0, j = array[0].length-1;
        while (i>=0 && i < array.length && j>=0 && j < array[0].length) {
            if (array[i][j] > target) {
                i--;
            } else if (array[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
