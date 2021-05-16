package com.jianzhi.offer.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 示例1
 * 输入
 * [3,32,321]
 * 返回值
 * "321323"
 * @author zhaojun
 */
public class PrintMinNumber {
    /**
     * 定义新的排序规则
     * 使用的是快排，但是会栈溢出
     */
    public String printMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        quickSort(numbers, 0 , numbers.length-1);
        StringBuilder sb = new StringBuilder();
        for (int n : numbers) {
            sb.append(n);
        }
        return sb.toString();
    }

    public void quickSort(int[] numbers, int i, int j) {
        if (i>=j) {
            return;
        }
        int base =numbers[i];
        while (i<j) {
            System.out.println("i:" + i);
            System.out.println("j:" + j);
            while (i<j && ("" + numbers[j] + base).compareTo(("" + base + numbers[j])) > 0) {
                j--;
            }
            if (i<j) {
                numbers[i] = numbers[j];
                i++;
            }
            while (i<j && ("" + numbers[i] + base).compareTo(("" + base + numbers[i])) < 0) {
                i++;
            }
            if (i<j) {
                numbers[j] = numbers[i];
                j--;
            }
            System.out.println("i:" + i);
            System.out.println("j:" + j);
        }
        numbers[i] = base;
        quickSort(numbers, 0, i-1);
        quickSort(numbers, j+1, numbers.length-1);
    }

    public static void main(String[] args) {
        int[] n = {1,2,3,4,5,6};
        System.out.println(new PrintMinNumber().printMinNumber(n));
    }
}
