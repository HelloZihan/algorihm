package com.leetcode.hot100;

/**
 * 下一个排列
 *
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class NextPermutation {

    /**
     * 下一个排列(字典顺序的下一个值)  https://segmentfault.com/a/1190000004276023 https://blog.csdn.net/qq_26410101/article/details/81261308
     * 首先从数组右向左查找，找到第一个满足nums[k]<nums[k+1]的下标k，如果不存在这个k，那么这个数组是一个递减数组，直接返回数组的逆序。
     * 然后找到下标l满足：l>k并且nums[l]>nums[k]，交换nums[k]和nums[l]
     * 最后对大于k的子数组进行逆序排序
     * 如果不知道这个规律（估计没人知道），这道题完全不可能做出来。。。zz
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int k=-1;
        for (int i = nums.length - 2; i >=0; i--) {
            if (nums[i] < nums[i+1]) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            int i=0, j = nums.length-1;
            while (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        } else {
            int j = nums.length-1;
            while (j>k) {
                if (nums[j] > nums[k]) {
                    int tmp = nums[k];
                    nums[k] = nums[j];
                    nums[j] = tmp;
                    break;
                }
                j--;
            }
            j = nums.length-1;
            int i = k+1;
            while(i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
    }
}
