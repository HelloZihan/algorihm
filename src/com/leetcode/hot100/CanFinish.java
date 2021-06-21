package com.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 207. 课程表
 *
 * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai 则 必须 先学习课程bi 。
 *
 * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class CanFinish {

    /**
     * https://blog.csdn.net/m0_37605197/article/details/107555360
     * prerequisites是否存在环形链表？
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        int[] flag = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(list, i, flag)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> list, int index, int[] flag) {
        if (flag[index] == 1) {
            return false;
        }
        if (flag[index] == -1) {
            return true;
        }
        flag[index] = 1;

        for (int i = 0; i < list.get(index).size(); i++) {
            if (!dfs(list, list.get(index).get(i), flag)) {
                return false;
            }
        }
        flag[index] = -1;
        return true;
    }
}
