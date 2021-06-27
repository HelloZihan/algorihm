package com.leetcode.hot100;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 *
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @author zhaojun
 */
public class TopKFrequent {

    /**
     * O(nlog(n))
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count+1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparing(map::get));
        for (Integer key: map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else {
                if (map.get(key) > map.get(priorityQueue.peek())) {
                    priorityQueue.remove();
                    priorityQueue.add(key);
                }
            }
        }
        System.out.println(priorityQueue);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.remove();
        }
        return result;
    }


    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,3,2};
        new TopKFrequent().topKFrequent(nums, 2);
    }

    public List<Integer> topKFrequent1(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(list[i] == null){
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
        for(int i = list.length - 1;i >= 0 && res.size() < k;i--){
            if(list[i] != null) {
                res.addAll(list[i]);
            }
        }
        return res;
    }
}
