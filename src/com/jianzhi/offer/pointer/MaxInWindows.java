package com.jianzhi.offer.pointer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 窗口大于数组长度的时候，返回空
 *
 * 输入
 * [2,3,4,2,6,2,5,1],3
 * 返回值
 * [4,4,6,6,6,5]
 *
 * @author zhaojun
 */
public class MaxInWindows {
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (size > num.length || size == 0) {
            return result;
        }
        //队列中0位置元素始终是最大值的索引
        LinkedList<Integer> indexs = new LinkedList<>();
        for (int i = 0; i < size-1; i++) {
            while (!indexs.isEmpty() && num[i] > num[indexs.peekLast()]) {
                indexs.removeLast();
            }
            indexs.add(i);
        }
        for (int i = size-1; i < num.length; i++) {
            while (!indexs.isEmpty() && num[i] > num[indexs.peekLast()]) {
                indexs.removeLast();
            }
            indexs.add(i);
            if (indexs.getFirst() < i-size+1) {
                indexs.removeFirst();
            }
            result.add(num[indexs.getFirst()]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {16,14,12,10,8,6,4};
        System.out.println(maxInWindows(num, 5));
    }
}
