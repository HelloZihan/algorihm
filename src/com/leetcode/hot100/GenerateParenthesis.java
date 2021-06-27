package com.leetcode.hot100;

import java.util.*;

/**
 * 22. 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class GenerateParenthesis {

    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs1(0,0, n, new StringBuilder());
        return result;
    }

    /**
     * stringBuilder是一个可变对象的引用，每天增加完需要删除，可以尝试改为String
     * @param left
     * @param right
     * @param n
     * @param stringBuilder
     */
    private void dfs1(int left, int right, int n, StringBuilder stringBuilder) {
        if (left == n && right == n) {
            result.add(stringBuilder.toString());
            return;
        }
        //[((())), (())))()), (()))()))(), ()()))())(()), ()())())(()))()]
        if (left == right) {
            dfs1(left+1, right, n, stringBuilder.append("("));
            stringBuilder.delete(left+right, left+right+1);
        } else {
            if (left == n) {
                dfs1(left, right+1, n, stringBuilder.append(")"));
                stringBuilder.delete(left+right, left+right+1);
            } else if (right == n) {
                dfs1(left+1, right, n, stringBuilder.append("("));
                stringBuilder.delete(left+right, left+right+1);
            } else {
                dfs1(left+1, right, n, stringBuilder.append("("));
                stringBuilder.delete(left+right, left+right+1);
                dfs1(left, right+1, n, stringBuilder.append(")"));
                stringBuilder.delete(left+right, left+right+1);
            }
        }
    }

    /**
     * 回溯2
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        //类似于前序遍历，一直增加(，一路到最后
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}
