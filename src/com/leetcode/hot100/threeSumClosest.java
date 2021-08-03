package com.leetcode.hot100;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * 给定一个包括n个整数的数组nums和一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class threeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 20000;
        for(int i=0; i<nums.length-2; i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1, right = nums.length -1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if(sum == target) {
                    return target;
                } else if(sum > target) {
                    if(sum-target < Math.abs(result - target)) {
                        result = sum;
                    }
                    right--;
                    while(right>left && nums[right] == nums[right+1]) {
                        right--;
                    }
                } else {
                    if(target-sum < Math.abs(result - target)) {
                        result = sum;
                    }
                    left++;
                    while(right>left && nums[left] == nums[left-1]) {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
