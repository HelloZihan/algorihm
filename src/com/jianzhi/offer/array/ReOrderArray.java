package com.jianzhi.offer.array;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author zhaojun
 */
public class ReOrderArray {
    public int[] reOrderArray (int[] array) {
        int i = 0, j = array.length-1;
        int[] result = new int[array.length];
        int left=0, right=array.length-1;
        while (i<array.length && j >=0) {
            if (array[i] % 2 == 1) {
                result[left++] = array[i];
            }
            i++;
            if (array[j]%2 == 0) {
                result[right--] = array[j];
            }
            j--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        new ReOrderArray().reOrderArray(a);
    }
}
