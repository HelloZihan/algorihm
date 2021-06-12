package com.leetcode.hot100;

/**
 * 287. 寻找重复数
 * 给定一个包含n+1个整数的数组nums ，其数字都在1到n之间（包括1和n），可知至少存在一个重复的整数。
 *
 * 假设nums只有一个重复的整数 ，找出这个重复的数 。
 *
 * 你设计的解决方案必须不修改数组nums且只用常量级 O(1) 的额外空间。
 *
 * 示例 1：
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhaojun
 */
public class FindDuplicate {
    /**
     * 环形链表，快慢指针
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        //slow，fast和下面的p1起点均为0，slow每次变化一次，fast每次变化两次
        int slow = nums[0], fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int p1 = nums[0];
        int p2 = nums[slow];
        while (p1 != p2){
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        new FindDuplicate().findDuplicate(nums);

    }
}
