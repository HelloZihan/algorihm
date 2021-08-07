package com.leetcode.hot100;

/**
 *
 * 41. 缺失的第一个正数
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 *  请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class FirstMissingPositive {

    /**
     *  思路③、使用座位交换法
     *       根据思路② 可知，缺失的第一个整数是 [1, len + 1] 之间，
     *       那么我们可以遍历数组，然后将对应的数据填充到对应的位置上去，比如 1 就填充到 nums[0] 的位置， 2 就填充到 nums[1]
     *       如果填充过程中， nums[i] < 1 && nums[i] > len，那么直接舍弃
     *       填充完成，我们再遍历一次数组，如果对应的 nums[i] != i + 1，那么这个 i + 1 就是缺失的第一个正数
     *
     *       比如 nums = [7, 8, 9, 10, 11], len = 5
     *       我们发现数组中的元素都无法进行填充，直接舍弃跳过，
     *       那么最终遍历数组的时候，我们发现 nums[0] != 0 + 1，即第一个缺失的是 1
     *
     *       比如 nums = [3, 1, 2], len = 3
     *       填充过后，我们发现最终数组变成了 [1, 2, 3]，每个元素都对应了自己的位置，那么第一个缺失的就是 len + 1 == 4
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            /**
             * 只有在 nums[i] 是 [1, len] 之间的数，并且不在自己应该呆的位置， nums[i] != i + 1 ，
             * 并且 它应该呆的位置没有被同伴占有（即存在重复值占有）	nums[nums[i] - 1] != nums[i] 的时候才进行交换
             *
             * 为什么使用 while ？ 因为交换后，原本 i 位置的 nums[i] 已经交换到了别的地方，
             * 交换后到这里的新值不一定是适合这个位置的，因此需要重新进行判断交换
             * 如果使用 if，那么进行一次交换后，i 就会 +1 进入下一个循环，那么交换过来的新值就没有去找到它该有的位置
             * 比如 nums = [3, 4, -1, 1] 当 3 进行交换后， nums 变成 [-1，4，3，1]，
             * 此时 i == 0，如果使用 if ，那么会进入下一个循环， 这个 -1 就没有进行处理
             */
            while(nums[i]>0 && nums[i] < nums.length && nums[nums[i]-1] != nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[nums[i]-1] = tmp;
            }
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != (i+1)) {
                return i+1;
            }
        }
        return nums.length;
    }

}
