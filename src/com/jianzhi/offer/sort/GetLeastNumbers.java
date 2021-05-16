package com.jianzhi.offer.sort;

import java.util.Arrays;

/**
 * 排序
 * 题目描述
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 如果K>数组的长度，那么返回一个空的数组
 * @author zhaojun
 *
 * 熟悉快排
 * 时间复杂度：平均O(nlogn) 最坏O(n^2)
 * 空间复杂度：
 */
public class GetLeastNumbers {

    public static void quickSort(int[]a, int left, int right) {
        if (left >= right) {
            return;
        }
        int i=left, j=right, base=a[left];
        while (i<j) {
            while (i<j && a[j]>base) {
                j--;
            }
            if (i<j) {
                a[i] = a[j];
                i++;
            }
            while (i<j && a[i] < base) {
                i++;
            }
            if (i<j) {
                a[j]=a[i];
                j--;
            }
        }
        a[i] = base;

        quickSort(a,0,i-1);
        quickSort(a, j+1, right);
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

}
