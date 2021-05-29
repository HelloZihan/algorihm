package com.leetcode.hot100;

import java.util.Arrays;

/**
 * 字符串全匹配
 *
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串！！！！
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * @author zhaojun
 */
public class IsMatch {
    /**
     * 方案一：递归
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        return solve(s, p, 0, 0);
    }

    private boolean solve(String s, String p, int index1, int index2) {
        // 递归终止条件1 abbb ab*
        if (s.length() == index1 && (p.length() == index2 ||  (index2+1 == p.length()-1 && (p.charAt(index2+1) == '*')))) {
            return true;
        }
        if (s.length() == index1 || p.length() == index2) {
            if (index1==s.length()) {
                //aba与abac*d*f*
                return change(p, index2);
            } else {
                return false;
            }
        }
        if (index2 + 1 < p.length() && p.charAt(index2+1) == '*') {
            if (judge(s.charAt(index1), p.charAt(index2))) {
                return solve(s,p,index1,index2+2) || solve(s, p, index1+1, index2);
            } else {
                return solve(s,p,index1,index2+2);
            }
        }
        if(judge(s.charAt(index1), p.charAt(index2))) {
            return solve(s, p, index1+1, index2+1);
        }
        return false;
    }

    private boolean change(String p, int index2) {
        while (index2 < p.length()) {
            if (index2 + 1 < p.length() && p.charAt(index2 + 1) == '*') {
                index2 += 2;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean judge(char s1, char p1) {
        if (s1 == p1 || p1 == '.') {
            return true;
        }
        return false;
    }


    /**
     * 方案2：动态规划
     * dp[i][j]表示s的前i个字符到p的前j个字符是否匹配
     * dp[i][j]=true表示s[0:i)与p[0:j)匹配
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        //注意是length+1 dp[1][1] 代表第一个字符是否匹配，即0->1是否匹配，故数组最大length，代表第length个字符是否匹配，即0->length个字符是否匹配
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //dp[0][0]代表两个长度为0的空串进行匹配
        dp[0][0] = true;
        //注意i从0开始，假如当"aa"和"a*", dp[0][2] = true。j为0且i不为0时，必然false，初始化已经是false了。
        for (int i = 0; i < s.length()+1; i++) {
            for (int j = 1; j < p.length()+1; j++) {
                //假设j为10，代表与p的前10个字符是否匹配，p.charAt(j-1)即为当前字符，并不是前一个字符
                if (p.charAt(j-1) == '*') {
                    if (j == 1) {
                        dp[i][j] = false;
                    } else {
                        if (match(s, p, i, j)) {

                        } else {

                        }
                        if (i== 0 || p.charAt(j-2) != s.charAt(i-1) && p.charAt(j-2)!= '.') {
                            dp[i][j] = dp[i][j-2];
                        } else {
                            //dp[i][j-1]能用dp[i-1][j])表示
                            //dp[i][j] = (dp[i][j-2] || dp[i][j-1] || dp[i-1][j]);
                            dp[i][j] = (dp[i][j-2] || dp[i-1][j]);
                        }
                    }
                } else {
                    if (i == 0) {
                        dp[i][j] = false;
                    } else {
                        dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.');
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private boolean match(String s, String p, int i, int j) {
        //char为""，始终无法匹配
        if (i == 0) {
            return false;
        }
        if (p.charAt(j-1) == '.') {
            return true;
        }
        return s.charAt(i-1) == p.charAt(j-1);
    }

    public static void main(String[] args) {
        System.out.println(new IsMatch().isMatch2("","."));
    }


}
