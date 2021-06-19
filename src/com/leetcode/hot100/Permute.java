package com.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * @author zhaojun
 */
public class Permute {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        dfs(nums, tmp, 0);
        return result;
    }

    private void dfs(int[] nums, List<Integer> tmp, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tmp.contains(nums[i])) {
                continue;
            }
            tmp.add(nums[i]);
            dfs(nums, tmp, index+1);
            tmp.remove(index);
        }
    }
}
