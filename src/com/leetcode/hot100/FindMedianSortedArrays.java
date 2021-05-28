package com.leetcode.hot100;

/**
 *
 * 给定两个大小分别为m和n的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * @author zhaojun
 */
public class FindMedianSortedArrays {

    /**
     * 解法1：合并俩数组
     * 解法2：在该数组上优化，其实并不用合并俩数组，只需要指针找到中间的位置即可
     * 该俩种方法都需要遍历全部，复杂度为O(m+n)，无法达到O(log(m+n))
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] all = new int[nums1.length + nums2.length];
        int i=0, j=0, index=0;
        while (i<nums1.length || j< nums2.length) {
            if (i == nums1.length) {
                all[index++] = nums2[j++];
                continue;
            }
            if (j == nums2.length) {
                all[index++] = nums1[i++];
                continue;
            }
            if (nums1[i] > nums2[j]) {
                all[index] = nums2[j];
                j++;
            } else {
                all[index] = nums1[i];
                i++;
            }
            index++;
        }
        if (all.length%2 == 1) {
            return all[all.length/2];
        } else {
            return (all[all.length/2 - 1] + all[all.length/2])/2.0;
        }
    }

    /**
     * 解法3：https://www.bilibili.com/video/BV1H5411c7oC?from=search&seid=10266816546231387113
     *
     * 复杂度为O(log(min(m,n)))
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0, right = nums1.length;
        //奇数为true，偶数为false
        boolean flag = (((nums1.length + nums2.length) & 1) == 1);
        while(left <= right) {
            int i = left + (right - left)/2;
            int j = (nums1.length + nums2.length + 1)/2 - i;
            if(i>0 && nums1[i-1] > nums2[j]) {
                right = i-1;
            } else if(i<nums1.length && nums2[j-1] > nums1[i]) {
                left = i+1;
            } else {
                //1、求左边界
                int leftMax = 0;
                if (i == 0) {
                    leftMax = nums2[j-1];
                } else if (j == 0) {
                    //j是大于等于i的，如果到达了0，则i必然是num1.length
                    leftMax = nums1[i-1];
                } else {
                    leftMax = Math.max(nums1[i-1], nums2[j-1]);
                }
                if (flag) {
                    return leftMax;
                }
                int rightMax = 0;
                if (i == nums1.length) {
                    //此时j=0
                    rightMax = nums2[j];
                } else if (j == nums2.length) {
                    rightMax = nums1[i];
                } else {
                    rightMax = Math.min(nums1[i], nums2[j]);
                }
                return (leftMax + rightMax)/2.0;
            }
        }
        return 0.0;
    }
}
