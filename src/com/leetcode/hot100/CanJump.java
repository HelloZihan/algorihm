package com.leetcode.hot100;

/**
 * 55. 跳跃游戏
 *
 * 给定一个非负整数数组nums ，你最初位于数组的第一个下标。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhaojun
 */
public class CanJump {
    /**
     * 解题思路：
     * 如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
     * 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
     * 如果可以一直跳到最后，就成功了。
     *
     * 作者：ikaruga
     * 链接：https://leetcode-cn.com/problems/jump-game/solution/55-by-ikaruga/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
    //end代表能碰到的右边最大值
        int end=0;
        for(int i=0; i<nums.length; i++) {
            end = Math.max(i + nums[i], end);
            if(i>=end && end != nums.length-1) {
                return false;
            }
        }
        return true;
    }
}
