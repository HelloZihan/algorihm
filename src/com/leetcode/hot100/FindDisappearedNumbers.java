package com.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 *
 * 给你一个含n个整数的数组nums，其中nums[i]在区间[1, n]内。请你找出所有在[1, n]范围内但没有出现在nums中的数字，并以数组的形式返回结果。
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 *
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class FindDisappearedNumbers {

    /**
     * 提示：
     *
     * n == nums.length
     * 1 <= n <= 105
     * 1 <= nums[i] <= n
     * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //在index-1处的元素加上一个值
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - 1)%nums.length;
            nums[index] += nums.length;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                result.add(i+1);
            }
        }
        return result;
    }
}
