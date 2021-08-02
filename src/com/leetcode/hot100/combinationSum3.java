package com.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 *
 * 找出所有相加之和为n的k个数的组合。组合中只允许含有 1 -9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class combinationSum3 {

    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        if(k>9) {
            return result;
        }
        dfs(nums, new ArrayList<>(), k, 0, n, 0);
        return result;
    }

    private void dfs(int[] nums, List<Integer> list, int count, int sum, int target, int j) {
        if(list.size() > count) {
            return;
        }
        if(sum > target) {
            return;
        }
        if((sum == target) && (list.size() == count)) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=j; i<nums.length; i++) {
            list.add(nums[i]);
            sum += nums[i];
            dfs(nums, list, count, sum, target, i+1);
            sum -= nums[i];
            list.remove(list.size()-1);
        }
    }
}
