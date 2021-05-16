package com.jianzhi.offer.sort;

/**
 * 归并排序 O(nlogn)
 * @author zhaojun
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {11,44,23,67,88,65,34,48,9,12};
        mergeSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid =(low + high) / 2;
        //对左边序列进行归并排序
        mergeSort(arr, low, mid);
        //对右边序列进行归并排序
        mergeSort(arr, mid+1, high);
        //合并两个有序序列
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] tmp = new int[arr.length];
        //i为左边序列起始索引，j为右边序列起始索引，index为tmp数组索引
        int i = low, j = mid+1, index=0;
        while (i<=mid && j<=high) {
            if (arr[i] < arr[j]) {
                tmp[index++] = arr[i++];
            } else {
                tmp[index++] = arr[j++];
            }
        }
        while (i<=mid) {
            tmp[index++] = arr[i++];
        }
        while (j<=high) {
            tmp[index++] = arr[j++];
        }
        for (int t = low; t <= high; t++) {
            arr[t] = tmp[t-low];
        }
    }
}
