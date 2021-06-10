package com.leetcode.hot100;

/**
 * 33. 搜索旋转排序数组
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums在预先未知的某个下标k（0 <= k < nums.length）上进行了旋转，使数组变为[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如[0,1,2,4,5,6,7] 在下标3处经旋转后可能变为[4,5,6,7,0,1,2]。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 *
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 *
 * 示例2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhaojun
 */
public class Search {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int middle = low + (high-low)/2;
            if(nums[middle] == target) {
                return middle;
            }
            if(nums[middle] >= nums[low]) {
                if(target >= nums[low] && target < nums[middle]) {
                    high = middle-1;
                } else {
                    low = middle + 1;
                }
            } else {
                if(target > nums[middle] && target <= nums[high]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search search = new Search();
        int[] a = {3,1};
        System.out.println(search.search(a, 1));
    }
}
