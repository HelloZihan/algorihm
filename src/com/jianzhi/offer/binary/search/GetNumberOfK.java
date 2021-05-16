package com.jianzhi.offer.binary.search;

/**
 * 题目描述
 * 统计一个数字在升序数组中出现的次数。
 * 示例1
 * 输入
 * [1,2,3,3,3,3,4,5],3
 * 返回值
 * 4
 * @author zhaojun
 */
public class GetNumberOfK {

    public int getNumberOfK(int [] array , int k) {
        //第一次出现为first,最后一次出现为last
        int first = getFirst(array, k);
        int last = getLast(0, array.length-1, array, k);
        if (first == -1 || last == -1) {
            return 0;
        }
        return last - first + 1;
    }

    private int getLast(int start, int end, int[] array, int k) {
        if (start >= end) {
            return end;
        }
        int mid = end - (end - start)/2;
        if (array[mid] <= k) {
            return getLast(mid, end, array, k);
        } else {
            return getLast(start, mid-1, array, k);
        }
    }

    /**
     * 注意getLast与getFirst的区别。特别是mid的设置
     * @param array
     * @param k
     * @return
     */
    private int getLast(int[] array, int k) {
        int start=-1, end=array.length-1;
        //获得第一次出现的位置
        while (start < end) {
            int mid = end - (end - start) / 2;
            if (array[mid] <= k) {
                start = mid;
            } else {
                end = mid-1;
            }
        }
        if (array[end] != k) {
            return -1;
        }
        return end;
    }

    private int getFirst(int[] array, int k) {
        int start=0, end=array.length;
        //获得第一次出现的位置
        while (start < end) {
            int mid = start + (end - start)/2;
            if (array[mid] < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (array[start] != k) {
            return -1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,3,3,3,3,3,3};
        System.out.println(new GetNumberOfK().getNumberOfK(a, 0));
    }

}
