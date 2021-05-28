package com.leetcode.hot100;

/**
 * 给你一个字符串 s，找到s中最长的回文子串。
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 * @author zhaojun
 */
public class LongestPalindrome {
    /**
     * 马拉车 缝隙间新增# O(n2)
     * https://www.cxyxiaowu.com/2869.html
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i)).append("#");
        }
        String k = stringBuilder.toString();
        String result = k.substring(0,1);
        for (int i=1; i< k.length(); i++) {
            int left =i, right = i;
            while (left>=0 && right<k.length() && k.charAt(left) == k.charAt(right)) {
                left--;
                right++;
            }
            //left+1是起始位置，right-1是结束位置！！！
            if (right - left - 1 >result.length()) {
                result = k.substring(left+1, right);
            }
        }
        return result.replace("#","");
    }

    /**
     * 方案2：dp
     *
     * 由于最长回文子串是要求连续的，所以我们可以假设i为子串的起始坐标，j为子串的终点坐标，
     * 其中i和j都是大于等于0并且小于字符串长度length的，且 i <= j，这样子串的长度就可以使用j-j+1表示了。
     *
     * 我们从长度为1的子串依次遍历，长度为1的子串肯定是回文的，其长度就是1；
     * 然后是长度为2的子串依次遍历，只要str[i] 等于 str[j] ，它就是回文的，其长度为 2；
     * 接下来就好办了，长度大于2的子串，如果它要满足是回文子串的性质，就必须有str[i]等于str[j]，并且去掉两头的子串str[i+1 ... j-1]也一定是回文子串，
     * 所以我们使用一个数组来保存以 i 为子串起始坐标，j 为子串终点坐标的子串是否是回文的，由于我们是从子问题依次增大求解的，
     * 所以求解 [i ... j] 的问题时，比它规模更小的问题结果都是可以直接使用的了。
     * https://blog.csdn.net/afei__/article/details/83214042
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        boolean[][] flag = new boolean[s.length()][s.length()];
        String result = s.substring(0,1);
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (j-i + 1 < 3) {
                    flag[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    flag[i][j] = flag[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                }
                if (j-i+1 > result.length() && flag[i][j]) {
                    result = s.substring(i, j+1);
                }
            }
        }
        return result;
    }
}
