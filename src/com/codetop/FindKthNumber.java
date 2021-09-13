package com.codetop;

/**
 * 440. 字典序的第K小数字
 *
 * 给定整数n和k，找到1到n中字典序第k小的数字。
 *
 * 注意：1 ≤ k ≤ n ≤ 109。
 *
 * 示例 :
 *
 * 输入:
 * n: 13   k: 2
 *
 * 输出:
 * 10
 *
 * 解释:
 * 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class FindKthNumber {


    public static void main(String[] args) {
        System.out.println(new FindKthNumber().getNodes(13, 1));
    }

    /**
     * https://zhuanlan.zhihu.com/p/113194071
     * https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/solution/java-zi-dian-xu-si-lu-qing-xi-dai-ma-jia-2ugh/
     *
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber(int n, int k) {
        long cur = 1;
        k -= 1;

        while(k > 0){
            int nodes = getNodes(n, cur);
            if(k >= nodes){
                k -= nodes;
                cur++;      //go right
            }else{
                k -= 1;
                cur *= 10;  //go down
            }
        }

        return (int)cur;
    }

    private int getNodes(int n, long cur){
        long next = cur + 1;
        long totalNodes = 0;

        while(cur <= n){
            totalNodes += Math.min(n - cur + 1, next - cur);

            next *= 10;
            cur *= 10;
        }

        return (int)totalNodes;
    }
}
