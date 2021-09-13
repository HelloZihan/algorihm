package com.codetop;

/**
 * 202. 快乐数
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为 1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 *
 *
 * 示例 1：
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：false
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class IsHappy {

    /**
     * 最终会成为一个环
     * https://leetcode-cn.com/problems/happy-number/solution/kuai-le-de-zhi-shi-dian-zeng-jia-liao-by-sweetiee/
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int slow = calu(n);
        int fast = calu(calu(n));
        while(slow != fast) {
            slow = calu(slow);
            fast = calu(calu(fast));
        }
        return slow == 1 ? true : false;
    }

    private int calu(int n) {
        int result = 0;
        while(n != 0) {
            int tmp = n%10;
            result += tmp*tmp;
            n = n/10;
        }
        return result;
    }

}
