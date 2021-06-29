package com.jianzhi.offer.array;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任一一个重复的数字。
 * 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3。存在不合法的输入的话输出-1
 * 
 * 示例1
 * 输入
 * [2,3,1,0,2,5,3]
 * 返回值
 * 2
 * 说明
 * 2或3都是对的
 * @author zhaojun
 */
public class Duplicate {
    public int duplicate (int[] numbers) {
       int[] index = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= numbers.length) {
                return -1;
            }
            index[numbers[i]]++;
            if (index[numbers[i]] > 1) {
                return numbers[i];
            }
        }
        return -1;
    }
}
