package com.jianzhi.offer.pointer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 返回值描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 *
 * 输入
 * [1,2,4,7,11,15],15
 * 返回值
 * [4,11]
 *
 * @author zhaojun
 */
public class FindNumbersWithSum {

    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int tmp = Integer.MAX_VALUE;
        int i=0,j=array.length-1;
        while (i<j) {
            if (array[i] + array[j] == sum) {
                if (tmp > array[i] * array[j]) {
                    result.clear();
                    result.add(array[i]);
                    result.add(array[j]);
                    //左右相差越大，则乘积越小，其实第一次相等时已经是答案
                    return result;
                }
                j--;
            } else if (array[i] + array[j] > sum) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}
