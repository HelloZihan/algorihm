package com.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * @author zhaojun
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        //[-4,-1,-1,0,1,2]
        int base = 0, left = 1, right = nums.length-1;
        while (base <= nums.length - 3 && nums[base] <= 0) {
            if(left >= right) {
                base++;
                while (base < nums.length && nums[base] == nums[base - 1]) {
                    base++;
                }
                left = base + 1;
                right = nums.length-1;
            }else if (nums[base] + nums[left] + nums[right] < 0) {
                left++;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            } else if (nums[base] + nums[left] + nums[right] > 0) {
                right--;
                while (right>left && nums[right] == nums[right+1]) {
                    right--;
                }
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[base]);
                list.add(nums[left]);
                list.add(nums[right]);
                result.add(list);
                left++;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
        return result;
    }
}
