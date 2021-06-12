package com.leetcode.hot100;

import java.util.*;

/**
 * 56.合并区间
 * 以数组intervals表示若干个区间的集合，其中单个区间为intervals[i]=[starti, endi]
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhaojun
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Deque<int[]> result = new LinkedList<>();
        result.add(intervals[0]);
        int max = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
             if (intervals[i][0] <= max) {
                 int[] tmp = result.removeLast();
                 max = Math.max(max, intervals[i][1]);
                 result.add(new int[]{tmp[0], max});
             } else {
                 result.add(intervals[i]);
                 max = intervals[i][1];
             }
        }
        return result.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] a = {{4,5,6},{3,8,9},{1,2,3}};
        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));
        System.out.println(Arrays.toString(a[0]));
        System.out.println(Arrays.toString(a[1]));
        System.out.println(Arrays.toString(a[2]));
    }
}
