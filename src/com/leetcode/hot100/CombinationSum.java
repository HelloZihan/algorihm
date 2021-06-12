package com.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhaojun
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(result, path, target, candidates, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> path, int target, int[] candidates,int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
        }
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(result, path, target - candidates[i], candidates, i);
            path.remove(path.size() - 1);
        }
    }
}
